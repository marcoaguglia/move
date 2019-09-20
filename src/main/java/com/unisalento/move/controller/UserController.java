package com.unisalento.move.controller;

import com.unisalento.move.model.User;
import com.unisalento.move.repository.UserRepository;
import com.unisalento.move.service.JwtUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    private JwtUserDetailsServiceImpl userService;

    @Autowired
    public UserController(JwtUserDetailsServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("api/users/addUsers")
    public String getAddUsers() {
        return "addUser";
    }

    @GetMapping("api/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("api//users/{username}")
    public User getUser(@PathVariable String username) {
        return userService.getUser(username);
    }

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("api/users")
    public ResponseEntity<Object> addUser(@RequestBody User user, UserRepository userRepository) {


        User createdUser = new User();
        createdUser.setAuthorities(user.getAuthorities());
        createdUser.setEnabled(true);
        createdUser.setUsername(user.getUsername());
        createdUser.setPassword(passwordEncoder.encode(user.getPassword()));

        userService.saveUser(createdUser);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{user}")
                .buildAndExpand(createdUser.getUsername())
                .toUri();

        return ResponseEntity.created(location).build();

    }

    @DeleteMapping("api/users/{username}")
    public User deleteUserById(@PathVariable String username) {
        User user = userService.deleteUser(username);

        if (user == null)
            throw new UsernameNotFoundException("user-"+username);

        return user;
    }


}
