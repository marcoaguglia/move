package com.unisalento.move.repository;

import com.unisalento.move.model.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional

public interface TruckRepository extends JpaRepository<Truck, Long> {
    Optional<Truck> findById(String trackId);

    void deleteById(String trackId);


}
