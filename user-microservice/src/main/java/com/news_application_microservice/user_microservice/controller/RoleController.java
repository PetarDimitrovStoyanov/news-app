package com.news_application_microservice.user_microservice.controller;

import com.news_application_microservice.user_microservice.dto.RoleDto;
import com.news_application_microservice.user_microservice.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/roles")
@RequiredArgsConstructor
@Slf4j
public class RoleController {
    private final RoleService roleService;

    @GetMapping
    public RoleDto getRoleByName(String name) {
        log.info("Getting a role {}", name);

        return roleService.findByName(name);
    }
}
