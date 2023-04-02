package com.example.unit_test_app.exception;

import com.example.unit_test_app.exception.handler.AppError;
import com.example.unit_test_app.exception.type.ErrorType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.List;

class AppExceptionTest {

    @Test
    void appExceptionCustomErrorTypeTest() {
        AppException exception = new AppException(AppError.builder()
                .code(1021)
                .status( HttpStatus.BAD_REQUEST)
                .message( "Test")
                .errors( List.of("Wow"))
                .build());
        Assertions.assertThrows(AppException.class, ()->{throw exception;});
        Assertions.assertNotNull(exception.getAppError());
    }

    @Test
    void appExceptionErrorTypeTest() {
        AppException exception = new AppException(ErrorType.GET_EMPLOYEE_NOT_FOUND);
        Assertions.assertThrows(AppException.class, ()->{throw exception;});
        Assertions.assertNotNull(exception.getAppError());
    }

    @Test
    void appExceptionErrorTypeTestWithVariable() {
        AppException exception =  new AppException(ErrorType.GET_EMPLOYEE_NOT_FOUND,"Cool Beans");
        Assertions.assertThrows(AppException.class, ()->{throw exception;});
        Assertions.assertNotNull(exception.getAppError());
    }

    @Test
    void appExceptionWithHttpStatus() {
        AppException exception =new AppException(HttpStatus.BAD_REQUEST,"Cool Beans");
        Assertions.assertThrows(AppException.class, ()->{throw exception;});
        Assertions.assertNotNull(exception.getAppError());
    }

    @Test
    void appExceptionWithMessage() {
        AppException exception = new AppException("Here Cool Beans lives.");
        Assertions.assertThrows(AppException.class, ()->{throw exception;});
        Assertions.assertNotNull(exception.get());
    }

    @Test
    void appExceptionWithMessageWithVariable() {
        AppException exception = new AppException("Here %s lives.","Cool Beans");
        Assertions.assertThrows(AppException.class, ()->{throw exception;});
        Assertions.assertNotNull(exception.getAppError());
    }
}
