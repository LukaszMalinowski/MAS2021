package pl.lukaszmalina.mas2021.service;

import org.springframework.stereotype.Service;
import pl.lukaszmalina.mas2021.dto.CompanyDto;
import pl.lukaszmalina.mas2021.dto.MechanicDto;
import pl.lukaszmalina.mas2021.exception.CompanyNotFoundException;
import pl.lukaszmalina.mas2021.exception.MechanicAlreadyExistsException;
import pl.lukaszmalina.mas2021.model.Company;
import pl.lukaszmalina.mas2021.model.Mechanic;
import pl.lukaszmalina.mas2021.repository.CompanyRepository;
import pl.lukaszmalina.mas2021.repository.MechanicRepository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final MechanicRepository mechanicRepository;

    public CompanyService(CompanyRepository companyRepository,
                          MechanicRepository mechanicRepository) {
        this.companyRepository = companyRepository;
        this.mechanicRepository = mechanicRepository;
    }

    public List<CompanyDto> getAllCompanies() {
        return companyRepository.findAll().stream().map(CompanyDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void addMechanic(long companyId, Mechanic mechanic) {
        Company company = companyRepository.findById(companyId).orElseThrow(() -> new CompanyNotFoundException(companyId));

        if (company.getMechanics().contains(mechanic)) {
            throw new MechanicAlreadyExistsException(companyId, new MechanicDto(mechanic));
        }

        mechanic.setCompany(company);

        mechanicRepository.save(mechanic);
    }

    @Transactional
    public void deleteCompany(long companyId) {
        if(!companyRepository.findById(companyId).isPresent()) {
            throw new CompanyNotFoundException(companyId);
        }

        companyRepository.deleteById(companyId);
    }
}
