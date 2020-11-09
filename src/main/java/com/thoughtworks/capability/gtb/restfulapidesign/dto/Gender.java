package com.thoughtworks.capability.gtb.restfulapidesign.dto;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {

    MALE("Male"),
    FEMALE("Female");

    @JsonValue
    private final String genderJson;

    Gender(String genderJson) {
        this.genderJson = genderJson;
    }
}
