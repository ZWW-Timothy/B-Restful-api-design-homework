package com.thoughtworks.capability.gtb.restfulapidesign.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<StudentDto> studentList;
}
