package pl.lukaszmalina.mas2021.service;

import org.springframework.stereotype.Service;
import pl.lukaszmalina.mas2021.dto.MechanicRepairDto;
import pl.lukaszmalina.mas2021.dto.RepairRequestDto;
import pl.lukaszmalina.mas2021.exception.*;
import pl.lukaszmalina.mas2021.model.*;
import pl.lukaszmalina.mas2021.repository.GarageRepository;
import pl.lukaszmalina.mas2021.repository.MechanicRepository;
import pl.lukaszmalina.mas2021.repository.PartRepository;
import pl.lukaszmalina.mas2021.repository.RepairRepository;
import pl.lukaszmalina.mas2021.util.EmailSender;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RepairService {

    private final RepairRepository repairRepository;
    private final GarageRepository garageRepository;
    private final MechanicRepository mechanicRepository;
    private final PartRepository partRepository;
    private final EmailSender emailSender;

    public RepairService(RepairRepository repairRepository,
                         GarageRepository garageRepository,
                         MechanicRepository mechanicRepository,
                         PartRepository partRepository, EmailSender emailSender) {
        this.repairRepository = repairRepository;
        this.garageRepository = garageRepository;
        this.mechanicRepository = mechanicRepository;
        this.partRepository = partRepository;
        this.emailSender = emailSender;
    }

    @Transactional
    public void registerRepair(RepairRequestDto repairRequest, User user) {
        if (repairRequest.getClientId() != user.getId()) {
            throw new UserNotPermittedException("You cannot register visit for another user");
        }

        Garage garage = garageRepository.findById(repairRequest.getGarageId())
                                        .orElseThrow(() -> new GarageNotFoundException(repairRequest.getGarageId()));

        Car repairCar = user.getCars().stream()
                            .filter(car -> car.getId() == repairRequest.getCarId())
                            .findFirst()
                            .orElseThrow(() -> new CarNotFoundException(repairRequest.getCarId()));

        removeVisitDate(garage, repairRequest.getVisitDate());

        Repair repair = new Repair(
                repairRequest.getDescription(),
                repairRequest.getVisitDate(),
                garage,
                repairCar,
                repairRequest.isDoorToDoor(),
                repairRequest.isInvoiceNeeded(),
                Status.REGISTERED
        );

        repairRepository.save(repair);
    }

    @Transactional
    public void completeRepair(long repairId, User user) {
        Repair repair = repairRepository.findById(repairId).orElseThrow(() -> new RepairNotFoundException(repairId));

        if (repair.getGarage().getOwner().getId() != user.getId()) {
            throw new UserNotPermittedException("You can complete repairs from your services only");
        }

        repair.setStatus(Status.COMPLETED);
        repairRepository.save(repair);

        sendRepairCompletionEmail(repair);
    }

    private void removeVisitDate(Garage garage, LocalDateTime visitDate) {
        if (!garage.getAvailableDates().contains(visitDate)) {
            throw new GarageDateNotAvailableException(visitDate);
        }

        garage.getAvailableDates().remove(visitDate);

        garageRepository.save(garage);
    }

    public List<MechanicRepairDto> getAllMechanics(long repairId) {
        Repair repair = repairRepository.findById(repairId).orElseThrow(() -> new RepairNotFoundException(repairId));

        return repair.getMechanics().stream()
                     .map(mechanicRepair -> new MechanicRepairDto(
                             mechanicRepair.getMechanic(),
                             mechanicRepair.getNotes(),
                             mechanicRepair.getHours()))
                     .collect(Collectors.toList());
    }

    @Transactional
    public void addMechanic(long repairId, MechanicRepairDto mechanicRepairDto, User user) {
        Repair repair = repairRepository.findById(repairId).orElseThrow(() -> new RepairNotFoundException(repairId));

        if (repair.getGarage().getOwner().getId() != user.getId()) {
            throw new UserNotPermittedException("You can complete repairs from your services only");
        }

        Mechanic mechanic = mechanicRepository.findById(mechanicRepairDto.getMechanicId())
                                              .orElseThrow(() -> new MechanicNotFoundException(
                                                      mechanicRepairDto.getMechanicId()));

        repair.getMechanics()
              .add(new MechanicRepair(mechanic, repair, mechanicRepairDto.getNotes(), mechanicRepairDto.getHours()));

        if (repair.getStatus() == Status.REGISTERED) {
            repair.setStatus(Status.STARTED);
        }

        repairRepository.save(repair);
    }

    @Transactional
    public void addPart(long repairId, Part part, User user) {
        Repair repair = repairRepository.findById(repairId).orElseThrow(() -> new RepairNotFoundException(repairId));

        if (repair.getGarage().getOwner().getId() != user.getId()) {
            throw new UserNotPermittedException("You can complete repairs from your services only");
        }

        part.setId(0);
        partRepository.save(part);

        repair.getParts().add(part);

        if (repair.getStatus() == Status.REGISTERED) {
            repair.setStatus(Status.STARTED);
        }

        repairRepository.save(repair);
    }

    private void sendRepairCompletionEmail(Repair repair) {
        Car userCar = repair.getCar();
        String toEmail = userCar.getOwner().getEmail();

        final BigDecimal[] mechanicsTotal = {BigDecimal.ZERO};

        repair.getMechanics()
              .forEach(mechanicRepair -> mechanicsTotal[0] = mechanicsTotal[0].add(
                      mechanicRepair.getMechanic().getHourlyRate()
                                    .multiply(BigDecimal.valueOf(
                                            mechanicRepair.getHours()))));

        final BigDecimal[] partsTotal = {BigDecimal.ZERO};

        repair.getParts().forEach(part -> partsTotal[0] = partsTotal[0].add(part.getPrice()));


        String subject = "Your repair in service " + repair.getGarage().getName() + " is completed! ";


        String emailStringBuilder = "Hello " +
                userCar.getOwner().getFirstName() +
                "\r\n" +
                "We completed your " +
                userCar.getBrand() +
                " " +
                userCar.getModel() +
                " repair!" +
                "\r\n\r\n" +
                "Total mechanics cost: " +
                mechanicsTotal[0] +
                "z??." +
                "\r\n" +
                "Total parts cost: " +
                partsTotal[0] +
                "z??." +
                "\r\n" +
                "Total cost: " +
                partsTotal[0].add(mechanicsTotal[0]) +
                "z??." +
                "\r\n" +
                "You can receive your car now!";
        emailSender.sendEmail(toEmail, subject, emailStringBuilder);
    }
}
