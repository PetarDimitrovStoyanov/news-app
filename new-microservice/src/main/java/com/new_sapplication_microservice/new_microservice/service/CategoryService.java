package com.new_sapplication_microservice.new_microservice.service;

import com.new_sapplication_microservice.new_microservice.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllCategories();
}
