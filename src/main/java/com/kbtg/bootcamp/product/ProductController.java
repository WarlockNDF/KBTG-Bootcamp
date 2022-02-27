package com.kbtg.bootcamp.product;

import com.kbtg.bootcamp.product.dto.ProductDTO;
import com.kbtg.bootcamp.response.ResponseTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ResponseTemplate responseTemplate;


    @GetMapping()
    @ResponseBody()
    @ResponseStatus(HttpStatus.OK)
    public Object getAllProduct() {
        return responseTemplate.createResponse(
                HttpStatus.OK,"Query Product Success",
                productService.getAllProduct()
        );
    }

    @GetMapping("/{name}")
    @ResponseBody()
    @ResponseStatus(HttpStatus.OK)
    public Object getFromName(@PathVariable() String name) {
        return responseTemplate.createResponse(
                HttpStatus.OK,"Query Product From Name Success",
                productService.getProductFromName(name)
        );
    }

    @GetMapping("/detail/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object getDetailedFromId(@PathVariable() Integer id) {
        return responseTemplate.createResponse(
                HttpStatus.OK,"Query Product Info Success",
                productService.getProductDetailedFromId(id)
        );
    }

//    @PostMapping()
//    @ResponseBody()
//    @ResponseStatus(HttpStatus.CREATED)
//    public Object postProduct(@RequestBody()ProductDTO reqProduct, @RequestParam(name = "user") Integer userId) {
//        return responseTemplate.createResponse(
//                HttpStatus.OK, "Product Had been Registered To System",
//                productService.saveProductToSystem(reqProduct, userId)
//        );
//    }

//    @PatchMapping()
//    @ResponseBody()
//    @ResponseStatus(HttpStatus.OK)
//    public  Object patchProduct(@RequestBody() ProductDTO reqProduct, @RequestParam( name = "user" ) Integer userId) {
//        return responseTemplate.createResponse(
//          HttpStatus.OK,"Product has been Updated To The System",
//                productService.updateProductToSystem(reqProduct, userId)
//        );
//    }

}
