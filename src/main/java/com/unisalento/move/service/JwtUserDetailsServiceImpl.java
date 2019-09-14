package com.unisalento.move.service;

import com.unisalento.move.model.User;
import com.unisalento.move.repository.UserRepository;
import com.unisalento.move.security.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(String user) {
        return userRepository.findByUsername(user);
    }


    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User deleteUser(String username) {

        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByUsername(username));

        if (optionalUser.isPresent()) {
            userRepository.deleteUserByUsername(username);
            return optionalUser.get();
        }

        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}