package com.kbtg.bootcamp.basket;


import com.kbtg.bootcamp.basket.dto.BasketRequestDTO;
import com.kbtg.bootcamp.response.ResponseTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/user/basket")
@RequiredArgsConstructor
public class BasketController {

    private final ResponseTemplate responseTemplate;
    private final BasketService basketService;

    @GetMapping
    @ResponseBody()
    @ResponseStatus(HttpStatus.OK)
    public Object getUserBasket(@RequestParam(name = "user") Integer userId) {
        return responseTemplate.createResponse(
                HttpStatus.OK,"Get ALl Basket Item",
                basketService.getUserBasketItem(userId)
        );
    }

    @PostMapping()
    @ResponseBody()
    @ResponseStatus(HttpStatus.CREATED)
    public Object postUserBasketItem(@RequestBody() BasketRequestDTO requestDTO, @RequestParam(name = "user") Integer userId) {
        return responseTemplate.createResponse(
                HttpStatus.OK, "Add Item To User Basket",
                basketService.addItemToUserBasket(requestDTO, userId)
        );
    }

}
