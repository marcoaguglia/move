package com.unisalento.move.repository;

import com.unisalento.move.model.Container;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ContainerRepository extends JpaRepository<Container, Long> {
    Optional<Container> findById(String containerId);

    void deleteById(String containerId);

}
