package com.unisalento.move.repository;

import com.unisalento.move.model.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional

public interface ShippingRepository extends JpaRepository<Shipping, Long> {
    Optional<Shipping> findById(String shippingId);

    void deleteById(String shippingId);


}