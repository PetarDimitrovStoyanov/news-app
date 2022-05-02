package com.news_application_microservice.user_microservice.enums;

public enum RoleEnum {
    CREATOR("creator"),MANAGER("manager"), ADMIN("admin");
    private String name;

    RoleEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
