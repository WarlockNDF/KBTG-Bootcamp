package com.kbtg.bootcamp.mockup;


import com.kbtg.bootcamp.address.AddressService;
import com.kbtg.bootcamp.entities.Product;
import com.kbtg.bootcamp.entities.User;
import com.kbtg.bootcamp.entities.UserAddress;
import com.kbtg.bootcamp.product.ProductService;
import com.kbtg.bootcamp.product.dto.ProductDTO;
import com.kbtg.bootcamp.product.model.ProductSize;
import com.kbtg.bootcamp.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitializeTestData {

    private final UserService userService;
    private final AddressService addressService;
    private final ProductService productService;


    public void init(){
        starter();
        productStarter();
    }

    private void starter() {
        User user = userService.getRepo().save(User.builder().firstName("Tim").lastName("Dev").build());
        UserAddress userAddress = new UserAddress();
        userAddress.setUser(user);
        userAddress.setReceiverEmail("test@email.com");
        userAddress.setReceiverFullName("Tim W");
        userAddress.setReceiverPhoneNumber("0000000000");
        userAddress.setReceiverPostalCode("10250");
        userAddress.setArea("Bangkapi");
        userAddress.setProvince("BKK");
        addressService.getRepo().save(userAddress);
    }

    private void productStarter() {
        ProductDTO product = new ProductDTO();
        product.setProductName("NINTEN STATION");
        product.setProductPrice(5000);
        product.setProductStar(3);
        product.setProductStock(50);
        product.setProductSizeList(List.of(ProductSize.builder().size("15").numberOfStock(50).build()));
        productService.saveProductToSystem(product, 1);
    }

}
