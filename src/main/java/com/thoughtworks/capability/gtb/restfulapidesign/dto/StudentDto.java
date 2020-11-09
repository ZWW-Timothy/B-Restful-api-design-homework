package com.thoughtworks.capability.gtb.restfulapidesign.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    @JsonProperty("id")
    private Integer studentId;

    @NotEmpty(message = "名字不为空")
    @JsonProperty("name")
    private String studentName;

    @NotNull(message = "性别不为空")
    @JsonProperty("gender")
    private Gender studentGender;

    @JsonProperty("note")
    private String studentNote;
}
