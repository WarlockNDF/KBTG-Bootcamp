package com.kbtg.bootcamp.product;

import com.kbtg.bootcamp.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository()
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByProductName(String name);

}
