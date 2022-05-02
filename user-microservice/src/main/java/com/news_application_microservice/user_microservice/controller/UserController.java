package com.news_application_microservice.user_microservice.controller;

import com.news_application_microservice.user_microservice.dto.UserDto;
import com.news_application_microservice.user_microservice.entity.UserEntity;
import com.news_application_microservice.user_microservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/{email}")
    public UserDto getUserByEmail(@PathVariable String email) {
        log.info("Getting a user by email {}", email);

        return userService.getUserByEmail(email);
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        log.info("Getting of all users");

        return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserDto userDto) {
        log.info("Creating a user {}", userDto.toString());
        UserEntity user = userService.createUser(userDto);

        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/get-first")
    public ResponseEntity<UserDto> getFirstUser(){
        log.info("Getting a first user");
        UserDto firstUser = userService.getFirstUser();

        return ResponseEntity.ok().body(firstUser);
    }
}
