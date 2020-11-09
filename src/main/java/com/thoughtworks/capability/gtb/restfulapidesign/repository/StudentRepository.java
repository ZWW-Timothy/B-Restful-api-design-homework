package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.dto.StudentDto;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {

    private List<StudentDto> studentList = new ArrayList<StudentDto>() {
        {
            add(new StudentDto(1, "成吉思汗", Gender.MALE,null));
            add(new StudentDto(2, "鲁班七号", Gender.MALE,null));
            add(new StudentDto(3, "太乙真人", Gender.MALE,null));
            add(new StudentDto(4, "钟无艳", Gender.FEMALE,null));
            add(new StudentDto(5, "花木兰", Gender.FEMALE,null));
            add(new StudentDto(6, "雅典娜", Gender.FEMALE,null));
            add(new StudentDto(7, "芈月", Gender.FEMALE,null));
            add(new StudentDto(8, "白起", Gender.MALE,null));
            add(new StudentDto(9, "刘禅", Gender.MALE,null));
            add(new StudentDto(10, "庄周", Gender.MALE,null));
            add(new StudentDto(11, "马超", Gender.MALE,null));
            add(new StudentDto(12, "刘备", Gender.MALE,null));
            add(new StudentDto(13, "哪吒", Gender.MALE,null));
            add(new StudentDto(14, "大乔", Gender.FEMALE,null));
            add(new StudentDto(15, "蔡文姬", Gender.FEMALE,null));
        }
    };

    public List<StudentDto> getStudentList() {
        return studentList;
    }

    public Integer nextId() {
        return studentList.get(studentList.size()-1).getStudentId()+1;
    }

    public StudentDto createStudent(StudentDto studentDto) {
        studentDto.setStudentId(nextId());
        studentList.add(studentDto);
        return studentDto;
    }

    public void deleteStudentById(Integer id) {
        StudentDto studentDto = findStudentById(id);
        studentList.remove(studentDto);
    }

    public StudentDto findStudentById(Integer id) {
        Optional<StudentDto> studentDto = studentList.stream().filter(student -> student.getStudentId().equals(id)).findFirst();
        if (studentDto.isPresent()) {
            return studentDto.get();
        } else {
            return null;
        }
    }

    public List<StudentDto> findStudentByName(String name) {
        List<StudentDto> findByNameList = studentList.stream().filter(student -> student.getStudentName().equals(name)).collect(Collectors.toList());
        if (findByNameList.size() > 0) {
            return findByNameList;
        } else {
            return null;
        }
    }

    public List<StudentDto> findStudentByGender(Gender gender) {
        List<StudentDto> findByGenderList = studentList.stream().filter(student -> student.getStudentGender().equals(gender)).collect(Collectors.toList());
        if (findByGenderList.size() > 0) {
            return findByGenderList;
        } else {
            return null;
        }
    }

    public StudentDto updateStudent(Integer id, StudentDto studentDto) {
        StudentDto studentToUpdate = findStudentById(id);
        Integer index = studentList.indexOf(studentToUpdate);
        if (studentDto.getStudentName() != null) {
            studentToUpdate.setStudentName(studentDto.getStudentName());
        }
        if (studentDto.getStudentGender() != null) {
            studentToUpdate.setStudentGender(studentDto.getStudentGender());
        }
        studentToUpdate.setStudentNote(studentDto.getStudentNote());
        studentList.remove(index);
        studentList.add(index, studentToUpdate);
        return studentToUpdate;
    }
}
