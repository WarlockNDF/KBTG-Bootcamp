package com.kbtg.bootcamp.product.dto;

import com.kbtg.bootcamp.entities.Product;
import com.kbtg.bootcamp.exception.exceptions.InternalProcessException;
import lombok.Data;

@Data
public class ProductDetailedResponseDTO {

    private Integer id;
    private String name;
    private double price;
    private double starRated;
    private int overallStock;
    private String optionList; //List<ProductSize>
    private double discountedPrice;
    private double discountPercent;
    private boolean isDiscountActive;

    public void setDiscountedPrice(double price, double discountPercent){
        this.discountedPrice = price - (price * (discountPercent/100));
    }

    public ProductDetailedResponseDTO _ToResponseDTO(Product product) {
        try {
            this.setId(product.getId());
            this.setName(product.getProductName());
            this.setPrice(product.getProductPrice());
            this.setStarRated(product.getProductStar());
            this.setOverallStock(product.getProductStock());
            this.setOptionList(product.getProductSizeList());
            if(product.isDiscountActive()){
                this.setDiscountedPrice(product.getProductPrice(), product.getDiscountPercent());
            }else {
                this.setDiscountedPrice(0);
            }
            this.setDiscountPercent(product.getDiscountPercent());
            this.setDiscountActive(product.isDiscountActive());
            return this;
        }catch (Exception e) {
            throw new InternalProcessException(e.getMessage());
        }
    }

}
