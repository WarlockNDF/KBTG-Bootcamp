package com.kbtg.bootcamp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kbtg.bootcamp.product.model.ProductSize;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.List;

@Entity()
@Getter
@Setter
public class Product {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String productName;
    private double productPrice;
    private double productStar;
    private int productStock;
    private String productSizeList;



}
