package com.new_sapplication_microservice.new_microservice.repository;

import com.new_sapplication_microservice.new_microservice.entity.NewEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NewRepository extends MongoRepository<NewEntity, String> {
}
