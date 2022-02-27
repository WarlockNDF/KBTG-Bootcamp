package com.kbtg.bootcamp.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ResponseModel {

    public ResponseModel() {
    }

    private Integer status;
    private String message;
    private Object data;

}
