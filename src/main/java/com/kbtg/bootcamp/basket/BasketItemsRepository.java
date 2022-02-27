package com.kbtg.bootcamp.basket;

import com.kbtg.bootcamp.entities.BasketItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BasketItemsRepository extends JpaRepository<BasketItems, Integer> {

    List<BasketItems> findAllByBasket_Id(Integer basketId);

}
