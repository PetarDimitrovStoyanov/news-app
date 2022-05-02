package com.news_application_microservice.user_microservice.service;

import com.news_application_microservice.user_microservice.dto.RoleDto;

import java.util.Optional;

public interface RoleService {
    RoleDto findByName(String name);
}
