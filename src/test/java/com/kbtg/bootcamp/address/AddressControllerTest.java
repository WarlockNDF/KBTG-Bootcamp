package com.kbtg.bootcamp.address;

import com.kbtg.bootcamp.address.dto.AddressRequestDTO;
import com.kbtg.bootcamp.response.ResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AddressControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private AddressService addressService;

    @Test
    @DisplayName("ดึงข้อมูลจาก User ที่มีอยู่")
    void getFromExistUser() {
        ResponseModel result = testRestTemplate.getForObject("/user/address/1", ResponseModel.class);
        assertEquals(200, result.getStatus());
    }

    @Test
    @DisplayName("ดึงข้อมูลจาก User ไม่ที่มีอยู่")
    void getFromNonExistUser() {
        ResponseModel result = testRestTemplate.getForObject("/user/address/50", ResponseModel.class);
        assertEquals(400, result.getStatus());
    }

    @Test
    @DisplayName("เพิ่มที่จัดส่ง")
    void postUserAddress() {
        AddressRequestDTO requestDTO = new AddressRequestDTO();
        requestDTO.setReceiverFullName("HELLO");
        requestDTO.setReceiverEmail("nichi");
        requestDTO.setReceiverPostalCode("10000");
        requestDTO.setArea("area");
        requestDTO.setProvince("BangNa");
        requestDTO.setReceiverAddressInfo("Elden Ring");
        ResponseModel result = testRestTemplate.postForObject("/user/address/1", requestDTO,ResponseModel.class);
        assertEquals(200, result.getStatus());
    }

}