package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.GroupDto;
import com.thoughtworks.capability.gtb.restfulapidesign.dto.StudentDto;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.GroupRepository;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {

    private StudentRepository studentRepository;
    private GroupRepository groupRepository;

    private static int groupNum = 6;

    public GroupService(StudentRepository studentRepository, GroupRepository groupRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }

    public List<GroupDto> getGroupList() {
        return groupRepository.getGroupList();
    }

    public List<GroupDto> divideGroup() {
        List<StudentDto> studentList = studentRepository.shuffleStudentList();
        int studentPerGroupIntPart = studentList.size() / groupNum;
        int studentPerGroupReminder = studentList.size() % groupNum;
        int dividedStudentTotal = 0;
        for (int groupIndex = 0; groupIndex < 6; groupIndex += 1) {
            List<StudentDto> studentInGroup = new ArrayList<>();
            for (int studentIndex = 0; studentIndex < studentPerGroupIntPart ; studentIndex += 1) {
                studentInGroup.add(studentList.get(dividedStudentTotal));
                dividedStudentTotal += 1;
            }
            if (studentPerGroupReminder > 0) {
                studentInGroup.add(studentList.get(dividedStudentTotal));
                dividedStudentTotal += 1;
                studentPerGroupReminder -= 1;
            }
            groupRepository.getGroupList().get(groupIndex).setStudentList(studentInGroup);
        }
        return groupRepository.getGroupList();
    }

    public GroupDto updateGroupName(Integer groupId, GroupDto groupDto) {
        int groupIndex = groupId - 1;
        groupRepository.getGroupList().get(groupIndex).setGroupName(groupDto.getGroupName());
        return groupRepository.getGroupList().get(groupIndex);
    }
}
