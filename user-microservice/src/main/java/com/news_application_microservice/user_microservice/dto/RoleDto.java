package com.news_application_microservice.user_microservice.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {
    private String id;
    private String name;
}
