package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.dto.StudentDto;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.ParamNumNotAllowException;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.StudentNotExistException;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentDto createStudent(StudentDto studentDto) {
        studentRepository.createStudent(studentDto);
        return studentRepository.findStudentById(studentDto.getStudentId());
    }

    public void deleteStudent(Integer studentId) throws StudentNotExistException {
        if (studentRepository.findStudentById(studentId) == null) {
            throw new StudentNotExistException();
        }
        studentRepository.deleteStudentById(studentId);
    }

    public StudentDto findStudent(Integer studentId) throws StudentNotExistException {
        if (studentRepository.findStudentById(studentId) == null) {
            throw new StudentNotExistException();
        }
        return studentRepository.findStudentById(studentId);
    }

//    public List<StudentDto> findStudent(String studentName) throws StudentNotExistException {
//        if (studentRepository.findStudentByName(studentName) == null) {
//            throw new StudentNotExistException();
//        }
//        return studentRepository.findStudentByName(studentName);
//    }

    public List<StudentDto> getStudentList(Gender studentGender, String studentName) throws StudentNotExistException, ParamNumNotAllowException {
        if (studentGender != null && studentName != null) {
            throw new ParamNumNotAllowException();
        }
        if (studentGender != null) {
            if (studentRepository.findStudentByGender(studentGender) == null) {
                throw new StudentNotExistException();
            }
            return studentRepository.findStudentByGender(studentGender);
        }
        if (studentName != null) {
            if (studentRepository.findStudentByName(studentName) == null) {
                throw new StudentNotExistException();
            }
            return studentRepository.findStudentByName(studentName);
        }
        if (studentRepository.getStudentList() == null) {
            throw new StudentNotExistException();
        }
        return studentRepository.getStudentList();
    }
}
