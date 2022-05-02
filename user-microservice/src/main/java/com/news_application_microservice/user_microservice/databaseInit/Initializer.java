package com.news_application_microservice.user_microservice.databaseInit;

import com.news_application_microservice.user_microservice.enums.RoleEnum;
import com.news_application_microservice.user_microservice.entity.RoleEntity;
import com.news_application_microservice.user_microservice.entity.UserEntity;
import com.news_application_microservice.user_microservice.repository.RoleRepository;
import com.news_application_microservice.user_microservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Initializer implements CommandLineRunner {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (roleRepository.findAll().isEmpty()) {
            RoleEntity creator = new RoleEntity();
            creator.setName(RoleEnum.CREATOR.getName());

            RoleEntity manager = new RoleEntity();
            manager.setName(RoleEnum.MANAGER.getName());

            RoleEntity admin = new RoleEntity();
            admin.setName(RoleEnum.ADMIN.getName());

            roleRepository.saveAllAndFlush(List.of(creator, manager, admin));
        }

        if (userRepository.findAll().isEmpty()) {
            UserEntity admin = new UserEntity();
            admin.setEmail("admin@admin.bg");
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setRoles(roleRepository.findAll());
            admin.setFirstName("Admin");
            admin.setLastName("Adminov");
            admin.setPicture(null);
            userRepository.saveAndFlush(admin);
        }
    }
}
