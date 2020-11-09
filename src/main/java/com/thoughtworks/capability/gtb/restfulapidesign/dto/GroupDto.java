package com.thoughtworks.capability.gtb.restfulapidesign.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupDto {

    @JsonProperty("id")
    private Integer groupId;

    @JsonProperty("name")
    private String groupName;

    @JsonProperty("note")
    private String groupNote;
}
