package com.new_sapplication_microservice.new_microservice.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryEnum {
    SPORT("sport"), FINANCES("finances"), TECHNOLOGIES("technologies"), PUBLIC("public");

    private String name;
}
