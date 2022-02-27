package com.kbtg.bootcamp.address;

import com.kbtg.bootcamp.entities.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<UserAddress, Integer> {

   // @EntityGraph( value = "get-address")
    List<UserAddress> findAllByUserId(Integer id);

}