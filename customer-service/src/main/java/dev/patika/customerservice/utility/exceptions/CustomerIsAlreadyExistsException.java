package dev.patika.customerservice.utility.exceptions;

public class CustomerIsAlreadyExistsException extends RuntimeException {
    public CustomerIsAlreadyExistsException(String s) {
        super(s);
    }
}
