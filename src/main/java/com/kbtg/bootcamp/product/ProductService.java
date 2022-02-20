package com.kbtg.bootcamp.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductRepository getRepo(){
        return productRepository;
    }

}
