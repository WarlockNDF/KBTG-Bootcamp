package com.kbtg.bootcamp.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class PaymentType {

    @Id
    private String paymentCode;
    private String name;

}
