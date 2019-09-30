package com.unisalento.move.repository;

import com.unisalento.move.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);

    void deleteUserByUsername(String username);

}