package com.thoughtworks.capability.gtb.restfulapidesign.api;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.GroupDto;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/groups")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public List<GroupDto> getGroupList() {
        return groupService.getGroupList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<GroupDto> divideGroup() {
        return groupService.divideGroup();
    }

//    @PutMapping("/{id}")
//    public GroupDto updateGroupName() {
//        return groupService.updateGroupName();
//    }
}
