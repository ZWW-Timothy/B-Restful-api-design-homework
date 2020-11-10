package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.GroupDto;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GroupRepository {

    private List<GroupDto> groupList = new ArrayList<GroupDto>() {
        {
            add(new GroupDto(1, "Team 1", null, null));
            add(new GroupDto(2, "Team 2", null, null));
            add(new GroupDto(3, "Team 3", null, null));
            add(new GroupDto(4, "Team 4", null, null));
            add(new GroupDto(5, "Team 5", null, null));
            add(new GroupDto(6, "Team 6", null, null));
        }
    };

    public List<GroupDto> getGroupList() {
        return groupList;
    }
}
