package com.unisalento.move.repository;

import com.unisalento.move.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    void deleteUserByUsername(String username);

}