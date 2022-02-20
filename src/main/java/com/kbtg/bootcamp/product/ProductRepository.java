package com.kbtg.bootcamp.product;

import com.kbtg.bootcamp.entities.ProductEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface ProductRepository extends JpaRepository<ProductEntities, String> {

}
