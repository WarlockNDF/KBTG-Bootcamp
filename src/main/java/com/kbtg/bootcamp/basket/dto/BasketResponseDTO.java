package com.kbtg.bootcamp.basket.dto;


import com.kbtg.bootcamp.entities.Product;
import com.kbtg.bootcamp.product.dto.ProductResponseDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class BasketResponseDTO {

    private ProductResponseDTO product = new ProductResponseDTO();
    private int quantity;
    private double total;

    public BasketResponseDTO _ToResponseDTO(Product product, Integer quantity) {
        this.product._ToResponseDTO(product);
        this.quantity = quantity;
        this.total = (this.product.isDiscountActive() ? this.product.getDiscountedPrice() : this.product.getPrice()) * this.quantity;
        return this;
    }

}
