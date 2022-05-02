package com.new_sapplication_microservice.new_microservice.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NewDto {
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
    private List<CategoryDto> categories;
    private String authorId;
    private String mangerId;
}
