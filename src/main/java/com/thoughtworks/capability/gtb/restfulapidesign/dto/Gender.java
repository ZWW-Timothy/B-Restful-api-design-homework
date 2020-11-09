package com.thoughtworks.capability.gtb.restfulapidesign.dto;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {

    MALE("male"),
    FEMALE("female");

    @JsonValue
    private final String genderJson;

    Gender(String genderJson) {
        this.genderJson = genderJson;
    }
}
