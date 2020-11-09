package com.thoughtworks.capability.gtb.restfulapidesign.api;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.ErrorResponse;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.ParamNumNotAllowException;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.StudentNotExistException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    static Integer codeBadRequest = HttpStatus.BAD_REQUEST.value();
    static Integer codeNotFound = HttpStatus.NOT_FOUND.value();

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(MethodArgumentNotValidException exception) {
        String message = exception.getBindingResult().getFieldError().getDefaultMessage();
        ErrorResponse error = new ErrorResponse(codeBadRequest, message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(HttpMessageNotReadableException exception) {
        String message = "性别输入不合法";
        ErrorResponse error = new ErrorResponse(codeBadRequest, message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(StudentNotExistException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(StudentNotExistException exception) {
        String message = "学生不存在";
        ErrorResponse error = new ErrorResponse(codeNotFound, message);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(ParamNumNotAllowException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(ParamNumNotAllowException exception) {
        String message = "只允许输入一个参数";
        ErrorResponse error = new ErrorResponse(codeBadRequest, message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
