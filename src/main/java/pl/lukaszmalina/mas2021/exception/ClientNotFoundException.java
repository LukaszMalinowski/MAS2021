package pl.lukaszmalina.mas2021.exception;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(long clientId) {
        super("Client with id " + clientId + " not found");
    }

}
