package com.new_sapplication_microservice.new_microservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "news")
public class NewEntity {
    @Id
    private String id;
    private String description;
    private String topic;
    private Integer views;
    private LocalDateTime createdDate;
    private LocalDateTime editedDate;
    private Boolean isActive;
    private String mainPicture;
    private String secondPicture;
    private String thirdPicture;
    private String forthPicture;
    private List<CategoryEntity> categories;
    private String authorId;
    private String mangerId;
}
