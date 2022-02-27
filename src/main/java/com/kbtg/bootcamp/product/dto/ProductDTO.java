package com.kbtg.bootcamp.product.dto;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kbtg.bootcamp.entities.Product;
import com.kbtg.bootcamp.exception.exceptions.FailedToSaveDataException;
import com.kbtg.bootcamp.exception.exceptions.ProductNotFoundException;
import com.kbtg.bootcamp.product.model.ProductSize;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
public class ProductDTO {

    private Integer Id;
    private String productName;
    private double productPrice;
    private double productStar;
    private int productStock;
    private List<ProductSize> productSizeList;
    private double discountPercent;
    private boolean isDiscountActive;

    public Product toEntity(){
        Product product = new Product();
        product.setId(this.Id);
        product.setProductName(this.productName);
        product.setProductPrice(this.productPrice);
        product.setProductStar(this.productStar);
        product.setProductStock(this.productStock);
        product.setDiscountPercent(this.discountPercent);
        product.setDiscountActive(this.isDiscountActive);
        try {
            product.setProductSizeList(new ObjectMapper().writeValueAsString(this.productSizeList));
        } catch (JsonProcessingException e){
            throw new FailedToSaveDataException(e.getMessage());
        }
        return product;
    }


}
