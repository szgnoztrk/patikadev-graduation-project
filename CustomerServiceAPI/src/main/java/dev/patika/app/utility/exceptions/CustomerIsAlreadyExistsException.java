package dev.patika.app.utility.exceptions;

public class CustomerIsAlreadyExistsException extends RuntimeException {
    public CustomerIsAlreadyExistsException(String s) {
        super(s);
    }
}
