package com.kbtg.bootcamp.product.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductSize {

    private String size;
    private int numberOfStock;

}
