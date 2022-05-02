package com.new_sapplication_microservice.new_microservice.controller;

import com.new_sapplication_microservice.new_microservice.dto.CreateANewDto;
import com.new_sapplication_microservice.new_microservice.dto.NewDto;
import com.new_sapplication_microservice.new_microservice.entity.NewEntity;
import com.new_sapplication_microservice.new_microservice.service.NewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/news")
@RequiredArgsConstructor
@Slf4j
public class NewController {
    private final NewService newService;

    @GetMapping
    public ResponseEntity<List<NewDto>> getAllNews() {
        log.info("Getting all news");
        List<NewDto> news = newService.findAllNews();

        return ResponseEntity.ok().body(news);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewDto> getANewById(@PathVariable String id) {
        log.info("Getting a new by id: {}", id);
        NewDto dto = newService.findById(id);

        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<NewEntity> createANew(@RequestBody @Valid CreateANewDto newDto) {
        log.info("Creating a new {}", newDto);

        NewEntity aNew = newService.createANew(newDto);
        return ResponseEntity.ok().body(aNew);
    }
}
