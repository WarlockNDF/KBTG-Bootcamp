package com.kbtg.bootcamp.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController()
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public ResponseEntity<Object> testProduct() {
        return ResponseEntity.ok(Map.of(
                "status",200,
                "message","Test Controller",
                "data", productService.getRepo().findAll()
        ));
    }

}
