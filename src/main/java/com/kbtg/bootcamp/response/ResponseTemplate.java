package com.kbtg.bootcamp.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ResponseTemplate {

    public Object createResponse(HttpStatus status, String message, Object data){
        return ResponseModel.builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();
    }

    public Object createExceptionResponse(HttpStatus status, String message){
        return ExceptionModel.builder()
                .status(status.value())
                .message(message)
                .build();
    }

    public ResponseModel getResponseModel() {
        return new ResponseModel();
    }

}

