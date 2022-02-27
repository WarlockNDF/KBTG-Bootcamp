package com.kbtg.bootcamp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

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
    private double discountPercent;
    private boolean isDiscountActive = false;

    @OneToMany(mappedBy = "products")
    @JsonBackReference
    private Set<BasketItems> baskets;

}
