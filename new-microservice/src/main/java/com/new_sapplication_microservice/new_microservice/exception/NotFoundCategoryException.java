package com.new_sapplication_microservice.new_microservice.exception;

public class NotFoundCategoryException extends RuntimeException {
    public NotFoundCategoryException(String id) {
        super(String.format("The category with name: %s was not found!", id));
    }
}
