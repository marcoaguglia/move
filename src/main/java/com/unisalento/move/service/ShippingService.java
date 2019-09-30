package com.unisalento.move.service;

import com.unisalento.move.model.Shipping;
import com.unisalento.move.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShippingService {
    private final ShippingRepository shippingRepository;

    @Autowired
    public ShippingService(ShippingRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }

    public List<Shipping> getAllShippings() {
        return shippingRepository.findAll();
    }

    public Shipping getShippingById(String shippingId) {

        Optional<Shipping> foundShipping = shippingRepository.findById(shippingId);

        return foundShipping.orElse(null);

    }

    public Shipping saveShipping(Shipping shipping) {
        return shippingRepository.save(shipping);
    }

    public Shipping deleteShipping(String shippingId) {

        Optional<Shipping> optionalShipping = shippingRepository.findById(shippingId);

        if (optionalShipping.isPresent()) {
            shippingRepository.deleteById(shippingId);
            return optionalShipping.get();
        }

        return null;
    }

}
