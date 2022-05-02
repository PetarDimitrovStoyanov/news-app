package com.new_sapplication_microservice.new_microservice.exception;

public class NewNotFoundException extends RuntimeException {
    public NewNotFoundException(String id) {
        super(String.format("The new with id: %s was not found!", id));
    }
}
