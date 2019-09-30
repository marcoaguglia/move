package com.unisalento.move.service;

import com.unisalento.move.model.User;
import com.unisalento.move.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String user) {

        User foundUser = (userRepository.findByUsername(user));

        return foundUser;

    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User deleteUser(String user) {

        User optionalUser = userRepository.findByUsername(user);


        userRepository.deleteUserByUsername(user);
        return optionalUser;


    }


}
