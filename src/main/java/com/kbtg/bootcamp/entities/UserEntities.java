package com.kbtg.bootcamp.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity()
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntities {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String firstName;
    private String lastName;

}
