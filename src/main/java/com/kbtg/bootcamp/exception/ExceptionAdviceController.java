package com.kbtg.bootcamp.exception;


import com.kbtg.bootcamp.exception.exceptions.*;
import com.kbtg.bootcamp.response.ResponseTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionAdviceController {

    private final ResponseTemplate responseTemplate;

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseBody()
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Object productNotFound(ProductNotFoundException e) {
        return responseTemplate.createExceptionResponse(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(FailedToSaveDataException.class)
    @ResponseBody()
    @ResponseStatus(HttpStatus.NOT_MODIFIED)
    public Object failedToSave(FailedToSaveDataException e) {
        return responseTemplate.createExceptionResponse(HttpStatus.NOT_MODIFIED, e.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody()
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Object userNotFound(UserNotFoundException e) {
        return responseTemplate.createExceptionResponse(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(NoSuchAddressException.class)
    @ResponseBody()
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Object addressNotFound(NoSuchAddressException e) {
        return responseTemplate.createExceptionResponse(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(FailedToDeleteDataException.class)
    @ResponseBody()
    @ResponseStatus(HttpStatus.NOT_MODIFIED)
    public Object failToDelete(FailedToDeleteDataException e) {
        return responseTemplate.createExceptionResponse(HttpStatus.BAD_REQUEST, e.getMessage());
    }

}
