package com.new_sapplication_microservice.new_microservice.databaseInit;

import com.new_sapplication_microservice.new_microservice.enums.CategoryEnum;
import com.new_sapplication_microservice.new_microservice.entity.CategoryEntity;
import com.new_sapplication_microservice.new_microservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Initializer implements CommandLineRunner {
    private final CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.findAll().isEmpty()) {
            CategoryEntity sport = CategoryEntity.builder()
                    .name(CategoryEnum.SPORT.getName())
                    .build();

            CategoryEntity finances = CategoryEntity.builder()
                    .name(CategoryEnum.FINANCES.getName())
                    .build();

            categoryRepository.saveAll(List.of(finances, sport));
        }
    }
}
