package com.example.unit_test_app.exception.type;

import com.example.unit_test_app.exception.handler.AppError;
import org.springframework.http.HttpStatus;

import java.util.List;

public enum ErrorType {
    DELETE_EMPLOYEE_NOT_FOUND(1404, HttpStatus.NOT_FOUND,"Delete Employee %s.", "Employee was not found"),
    GET_EMPLOYEE_NOT_FOUND(2404, HttpStatus.NOT_FOUND,"Find Employee %s.", "Employee was not found");

    final public AppError error;
    ErrorType(int code, HttpStatus status, String message, String errors){
        error = new AppError(code,status,message, List.of(errors.split(",")));
    }

}
