package pl.lukaszmalina.mas2021.exception;

public class CompanyNotFoundException extends RuntimeException {

    public CompanyNotFoundException(long companyId) {
        super("Company with id " + companyId + " not found");
    }
}
