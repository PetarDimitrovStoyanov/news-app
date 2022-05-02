package com.news_application_microservice.user_microservice.service;

import com.news_application_microservice.user_microservice.dto.UserDto;
import com.news_application_microservice.user_microservice.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserDto getUserByEmail(String email);

    List<UserDto> getAllUsers();

    UserEntity createUser(UserDto userDto);

    UserDto getFirstUser();
}
