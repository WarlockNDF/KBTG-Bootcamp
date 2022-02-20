package com.kbtg.bootcamp.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity()
@Getter
@Setter
public class ProductEntities {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String productName;
    private String productPrice;
    private double productStar;

}
