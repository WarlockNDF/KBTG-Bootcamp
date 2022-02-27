package com.kbtg.bootcamp.address;

import com.kbtg.bootcamp.address.dto.AddressRequestDTO;
import com.kbtg.bootcamp.response.ResponseTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;
    private final ResponseTemplate responseTemplate;

    @GetMapping("/{id}")
    @ResponseBody()
    @ResponseStatus(HttpStatus.OK)
    private Object getUserAddress(@PathVariable() Integer id){
        return responseTemplate.createResponse(
                HttpStatus.OK,"Get Address Success",
                addressService.getListOfAddress(id));
    }

    //TODO CHANGE TO BEARER TOKEN THEN USE EXTRACTED PAYLOAD AS USER
    @PostMapping("/{user}")
    @ResponseBody()
    @ResponseStatus(HttpStatus.CREATED)
    public Object postUserAddress(@RequestBody() AddressRequestDTO address, @PathVariable Integer user) {
        return responseTemplate.createResponse(
                HttpStatus.OK,"User Address Had Been Added",
                addressService.saveUserAddress(address,user)
        );
    }

    @PatchMapping("/{user}")
    @ResponseBody()
    @ResponseStatus(HttpStatus.OK)
    public Object putUserAddress(@RequestBody() AddressRequestDTO address, @PathVariable Integer user){
        return responseTemplate.createResponse(
                HttpStatus.OK,"User Address Had Been Modify",
                addressService.updateUserAddress(address, user)
        );
    }

    @DeleteMapping("/{user}")
    @ResponseBody()
    @ResponseStatus(HttpStatus.OK)
    public Object deleteUserAddress(@RequestParam(name = "id") Integer addressId, @PathVariable Integer user) {
        return responseTemplate.createResponse(
                HttpStatus.OK,"User Address Removed",
                addressService.deleteUserAddress(addressId, user)
        );
    }

}
