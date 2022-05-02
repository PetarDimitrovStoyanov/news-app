package com.news_application_microservice.user_microservice.service;

import com.news_application_microservice.user_microservice.enums.RoleEnum;
import com.news_application_microservice.user_microservice.dto.RoleDto;
import com.news_application_microservice.user_microservice.entity.RoleEntity;
import com.news_application_microservice.user_microservice.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Override
    public RoleDto findByName(String name) {
        RoleEntity roleEntity = roleRepository.findByName(RoleEnum.valueOf(name).getName());

        return modelMapper.map(roleEntity, RoleDto.class);
    }
}
