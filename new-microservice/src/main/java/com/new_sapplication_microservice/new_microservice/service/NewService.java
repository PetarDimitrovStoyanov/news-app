package com.new_sapplication_microservice.new_microservice.service;

import com.new_sapplication_microservice.new_microservice.dto.CreateANewDto;
import com.new_sapplication_microservice.new_microservice.dto.NewDto;
import com.new_sapplication_microservice.new_microservice.entity.NewEntity;

import java.util.List;

public interface NewService {
    List<NewDto> findAllNews();

    NewDto findById(String id);

    NewEntity createANew(CreateANewDto newDto);
}
