package com.new_sapplication_microservice.new_microservice.repository;

import com.new_sapplication_microservice.new_microservice.entity.CategoryEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CategoryRepository extends MongoRepository<CategoryEntity, String> {
    Optional<CategoryEntity> findByName(String name);
}
