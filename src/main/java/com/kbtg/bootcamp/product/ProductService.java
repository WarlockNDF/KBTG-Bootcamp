package com.kbtg.bootcamp.product;

import com.kbtg.bootcamp.entities.Product;
import com.kbtg.bootcamp.entities.User;
import com.kbtg.bootcamp.exception.exceptions.FailedToSaveDataException;
import com.kbtg.bootcamp.exception.exceptions.NoSuchProductException;
import com.kbtg.bootcamp.exception.exceptions.ProductNotFoundException;
import com.kbtg.bootcamp.exception.exceptions.UserNotFoundException;
import com.kbtg.bootcamp.product.dto.ProductDTO;
import com.kbtg.bootcamp.product.dto.ProductResponseDTO;
import com.kbtg.bootcamp.users.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final UserService userService;

    public List<ProductResponseDTO> getAllProduct(){
        List<ProductResponseDTO> responseDTOS = new ArrayList<>();
        productRepository.findAll().forEach(product -> {
            responseDTOS.add(new ProductResponseDTO()._ToResponseDTO(product));
        });
        return responseDTOS;
    }

    public List<Product> getProductFromName(String name){
        List<Product> product = productRepository.findAllByProductName(name);
        if (product.isEmpty()){
            throw new ProductNotFoundException("No Such Product");
        }
        return product;
    }

    public Product getProductDetailedFromId(Integer id){
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()){
            throw new ProductNotFoundException("No Such Product");
        }
        return product.get();
    }

    public ProductDTO saveProductToSystem(ProductDTO reqProduct, Integer userId) {
        Product product = productRepository.save(convertToEntity(reqProduct, userId));
        if(productRepository.findById(product.getId()).isEmpty()) {
            throw new FailedToSaveDataException("Failed To Save Product");
        }
        reqProduct.setId(product.getId());
        return reqProduct;
    }

    public ProductDTO updateProductToSystem(ProductDTO reqProduct, Integer userId) {
        if (!productRepository.existsById(userId)) {
            throw new NoSuchProductException("Product "+ reqProduct.getId() +" Does Not Exist");
        }
        return saveProductToSystem(reqProduct, userId);
    }

    private Product convertToEntity(ProductDTO requestDTO, Integer userId){
        Optional<User> user = userService.getRepo().findById(userId);
        if(user.isEmpty()){
            throw new UserNotFoundException("User Not Exist In the System");
        }
        return requestDTO.toEntity();
    }



}
