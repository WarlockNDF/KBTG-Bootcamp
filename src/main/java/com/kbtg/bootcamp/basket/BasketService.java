package com.kbtg.bootcamp.basket;

import com.kbtg.bootcamp.basket.dto.BasketRequestDTO;
import com.kbtg.bootcamp.basket.dto.BasketResponseDTO;
import com.kbtg.bootcamp.entities.Basket;
import com.kbtg.bootcamp.entities.BasketItems;
import com.kbtg.bootcamp.entities.Product;
import com.kbtg.bootcamp.entities.User;
import com.kbtg.bootcamp.exception.exceptions.UserNotFoundException;
import com.kbtg.bootcamp.product.ProductRepository;
import com.kbtg.bootcamp.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;
    private final BasketItemsRepository basketItemsRepository;
    private final UserService userService;
    private final ProductRepository productRepository;
    private List<BasketResponseDTO> responseDTOS;
    private Basket basket;

    public List<BasketResponseDTO> getUserBasketItem(Integer userId) {
        if (!userService.getRepo().existsById(userId)){
            throw new UserNotFoundException("User Does not Exist");
        }
        responseDTOS = new ArrayList<>();
        basket = basketRepository.findByUserId(userId);
        basketItemsRepository.findAllByBasket_Id(basket.getId()).forEach(basketItems -> {
            responseDTOS.add(new BasketResponseDTO()._ToResponseDTO(basketItems.getProducts(),basketItems.getQuantity()));
        });
        return responseDTOS;
    }

    public BasketResponseDTO addItemToUserBasket(BasketRequestDTO requestDTO, Integer userId) {
        if (!userService.getRepo().existsById(userId)){
            throw new UserNotFoundException("User Does not Exist");
        }
        basket = basketRepository.findByUserId(userId);
        Product product = productRepository.getById(requestDTO.getProductId());
        BasketItems basketItems = new BasketItems();
        basketItems.setBasket(basket);
        basketItems.setProducts(product);
        basketItems.setQuantity(requestDTO.getQuantity());
        return new BasketResponseDTO()._ToResponseDTO(basketItemsRepository.save(basketItems).getProducts(), requestDTO.getQuantity());
    }

    // TODO Change WHEN IMPLEMENT USER FEATURE
    public BasketRepository getRepo() {
        return  basketRepository;
    }

}
