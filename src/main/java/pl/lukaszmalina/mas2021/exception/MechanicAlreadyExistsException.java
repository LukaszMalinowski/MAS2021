package pl.lukaszmalina.mas2021.exception;

import pl.lukaszmalina.mas2021.dto.MechanicDto;

public class MechanicAlreadyExistsException extends RuntimeException {

    public MechanicAlreadyExistsException(long companyId, MechanicDto mechanic) {
        super("Mechanic " + mechanic + " already exists in company with id: " + companyId);
    }
}
