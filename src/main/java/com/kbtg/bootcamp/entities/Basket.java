package com.kbtg.bootcamp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne()
    @JsonBackReference
    private User user;

    @OneToMany( mappedBy = "basket")
    @JsonBackReference
    private Set<BasketItems> basketItems;

}