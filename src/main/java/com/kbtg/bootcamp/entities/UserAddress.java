package com.kbtg.bootcamp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity()
@Getter
@Setter
@NamedEntityGraph(
        name = "get-address",
        attributeNodes = {
                @NamedAttributeNode("user")
        }
)
public class UserAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String receiverEmail;
    private String receiverFullName;
    private String receiverPostalCode;
    private String receiverAddressInfo;
    private String area;
    private String province;
    private String receiverPhoneNumber;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    //@JsonManagedReference
    @JsonIgnore
    private User user;

}