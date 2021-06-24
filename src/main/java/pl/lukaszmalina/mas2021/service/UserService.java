package pl.lukaszmalina.mas2021.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.lukaszmalina.mas2021.dto.CarDto;
import pl.lukaszmalina.mas2021.dto.RepairDto;
import pl.lukaszmalina.mas2021.dto.UserDto;
import pl.lukaszmalina.mas2021.exception.UserNotPermittedException;
import pl.lukaszmalina.mas2021.model.Car;
import pl.lukaszmalina.mas2021.model.Repair;
import pl.lukaszmalina.mas2021.model.Role;
import pl.lukaszmalina.mas2021.model.User;
import pl.lukaszmalina.mas2021.repository.RepairRepository;
import pl.lukaszmalina.mas2021.repository.RoleRepository;
import pl.lukaszmalina.mas2021.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final RepairRepository repairRepository;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       RoleRepository roleRepository,
                       RepairRepository repairRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.repairRepository = repairRepository;
    }

    public boolean userExists(String email) {
        return userRepository.findUserByEmail(email).isPresent();
    }

    @Transactional
    public void registerUser(UserDto userDto) {
        Role role = roleRepository.findById(1L).orElse(new Role(1L, "ROLE_USER"));

        User user = new User(
                0,
                passwordEncoder.encode(userDto.getPassword()),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getPhoneNumber(),
                userDto.getAddress(),
                null,
                role
        );

        userRepository.save(user);
    }

    @Transactional
    public void addCar(Car car, long userId, User user) {
        if (userId != user.getId()) {
            throw new UserNotPermittedException("You cannot add cars to another user");
        }

        car.setOwner(user);
        user.getCars().add(car);
        userRepository.save(user);
    }

    public Set<Car> getAllUserCars(long userId, User user) {
        if (userId != user.getId()) {
            throw new UserNotPermittedException("You cannot get others users cars");
        }

        return user.getCars();
    }

    public List<RepairDto> getAllRepairs(long userId, User user) {
        if (userId != user.getId()) {
            throw new UserNotPermittedException("You cannot get others users repairs");
        }

        List<Repair> repairs = repairRepository.findAllByCarOwnerId(userId);

        return repairs.stream()
                      .map(repair -> new RepairDto(
                              repair.getId(),
                              repair.getDescription(),
                              repair.getReceiveDateTime(),
                              repair.getMechanics(),
                              new CarDto(repair.getCar()),
                              repair.getParts(),
                              repair.getStatus(),
                              repair.isDoorToDoor(),
                              repair.isInvoiceNeeded()
                      )).collect(Collectors.toList());
    }
}
