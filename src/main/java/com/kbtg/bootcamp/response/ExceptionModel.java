package com.kbtg.bootcamp.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionModel {

    private Integer status;
    private String message;

}
