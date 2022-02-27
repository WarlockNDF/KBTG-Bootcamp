package com.kbtg.bootcamp.basket;

import com.kbtg.bootcamp.entities.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface BasketRepository extends JpaRepository<Basket, Integer> {

    Basket findByUserId(Integer userId);

}