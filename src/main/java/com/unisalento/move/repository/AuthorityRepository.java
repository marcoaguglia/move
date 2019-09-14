package com.unisalento.move.repository;


import com.unisalento.move.model.Authority;
import com.unisalento.move.model.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByName(AuthorityName name);

}