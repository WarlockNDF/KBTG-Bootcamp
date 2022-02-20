package com.kbtg.bootcamp.users;

import com.kbtg.bootcamp.entities.UserEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntities, String> {

}
