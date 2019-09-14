package com.unisalento.move.repository;

import com.unisalento.move.model.Hub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HubRepository extends JpaRepository<Hub, Long> {
    Optional<Hub> findById(String hubId);
    void deleteById(String hubId);



}
