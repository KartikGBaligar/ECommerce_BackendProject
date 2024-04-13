package com.kartik.ecomcart.Service;

import com.kartik.ecomcart.Model.User;
import com.kartik.ecomcart.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUser(Long id)
    {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty())
        {
            User user = new User();
            user.setId(id);
            userRepository.save(user);
            return user;
        }

        else {
            User user = optionalUser.get();
            return user;
        }

    }

}
