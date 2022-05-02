package com.news_application_microservice.user_microservice.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String email) {
        super(String.format("The user with email: %s was not found!", email));
    }
}
