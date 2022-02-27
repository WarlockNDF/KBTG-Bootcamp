package com.kbtg.bootcamp.address.dto;

import com.kbtg.bootcamp.entities.User;
import com.kbtg.bootcamp.entities.UserAddress;
import lombok.Data;

@Data
public class AddressRequestDTO {

    private Integer id;
    private String receiverEmail;
    private String receiverFullName;
    private String receiverPostalCode;
    private String receiverAddressInfo;
    private String area;
    private String province;
    private String receiverPhoneNumber;

    public UserAddress toEntity(User user) {
        UserAddress userAddress = new UserAddress();
        userAddress.setUser(user);
        userAddress.setId(this.id);
        userAddress.setReceiverEmail(this.receiverEmail);
        userAddress.setReceiverFullName(this.receiverFullName);
        userAddress.setReceiverAddressInfo(this.receiverAddressInfo);
        userAddress.setReceiverPhoneNumber(this.receiverPhoneNumber);
        userAddress.setReceiverPostalCode(this.receiverPostalCode);
        userAddress.setArea(this.area);
        userAddress.setProvince(this.province);
        userAddress.setReceiverPostalCode(this.receiverPostalCode);
        return userAddress;
    }

}