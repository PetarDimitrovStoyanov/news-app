package com.new_sapplication_microservice.new_microservice.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class CreateANewDto {
    @NotBlank
    private String description;
    @NotBlank
    private String topic;
    @NotBlank
    private List<String> categories;
    private String mainPicture;
    private String secondPicture;
    private String thirdPicture;
    private String forthPicture;
}
