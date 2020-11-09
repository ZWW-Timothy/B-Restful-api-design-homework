package com.thoughtworks.capability.gtb.restfulapidesign.api;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.dto.StudentDto;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.ParamNumNotAllowException;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.StudentNotExistException;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDto createStudent (@RequestBody @Valid StudentDto studentDto) {
        return studentService.createStudent(studentDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent (@PathVariable Integer id) throws StudentNotExistException {
        studentService.deleteStudent(id);
    }

    @GetMapping("/{id}")
    public StudentDto findStudent (@PathVariable Integer id) throws StudentNotExistException {
        return studentService.findStudent(id);
    }

//    @GetMapping
//    public List<StudentDto> findStudent (@RequestParam String name) throws StudentNotExistException {
//        return studentService.findStudent(name);
//    }

    @GetMapping
    public List<StudentDto> getStudentList (@RequestParam(required = false) Gender gender, @RequestParam(required = false) String name)
            throws StudentNotExistException, ParamNumNotAllowException {
        return studentService.getStudentList(gender, name);
    }
}
