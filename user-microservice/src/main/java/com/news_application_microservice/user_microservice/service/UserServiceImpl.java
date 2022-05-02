package com.news_application_microservice.user_microservice.service;

import com.news_application_microservice.user_microservice.enums.RoleEnum;
import com.news_application_microservice.user_microservice.dto.RoleDto;
import com.news_application_microservice.user_microservice.dto.UserDto;
import com.news_application_microservice.user_microservice.entity.RoleEntity;
import com.news_application_microservice.user_microservice.entity.UserEntity;
import com.news_application_microservice.user_microservice.exceptions.UserNotFoundException;
import com.news_application_microservice.user_microservice.repository.RoleRepository;
import com.news_application_microservice.user_microservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public UserDto getUserByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(email));

        return convertUserEntityToDto(userEntity);
    }

    private UserDto convertUserEntityToDto(UserEntity userEntity) {

        return UserDto.builder()
                .email(userEntity.getEmail())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .id(userEntity.getId().toString())
                .roles(userEntity.getRoles().stream().map(this::mapRoleToDto).collect(Collectors.toList()))
                .picture(userEntity.getPicture())
                .build();
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(this::convertUserEntityToDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserEntity createUser(UserDto userDto) {
        RoleEntity roleEntity = roleRepository.findByName(RoleEnum.CREATOR.getName());
        UserEntity userEntity = mapDtoToUserEntity(userDto, roleEntity);
        return userRepository.saveAndFlush(userEntity);
    }

    @Override
    public UserDto getFirstUser() {
        return getAllUsers().get(0);
    }

    private UserEntity mapDtoToUserEntity(UserDto userDto, RoleEntity roleEntity) {
        return UserEntity.builder()
                .email(userDto.getEmail())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .picture(userDto.getPicture())
                .roles(List.of(roleEntity))
                .build();
    }

    private RoleDto mapRoleToDto(RoleEntity role) {

        return RoleDto.builder()
                .id(role.getId().toString())
                .name(role.getName())
                .build();
    }
}
