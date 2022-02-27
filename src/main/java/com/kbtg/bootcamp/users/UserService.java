package com.kbtg.bootcamp.users;

import com.kbtg.bootcamp.entities.User;
import com.kbtg.bootcamp.exception.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserRepository getRepo(){
        return  userRepository;
    }

}
