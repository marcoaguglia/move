package com.unisalento.move.controller;

import com.unisalento.move.exeption.ShippingNotFoundException;
import com.unisalento.move.model.Shipping;
import com.unisalento.move.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ShippingController {
    private final ShippingService shippingService;


    @Autowired
    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @GetMapping("/api/shippings")
    public List<Shipping> getAllDevices() {
        return shippingService.getAllShippings();
    }

    @GetMapping("/api/shippings/{id}")
    public Shipping getDeviceById(@PathVariable String id) {
        Shipping shipping = shippingService.getShippingById(id);

        if (shipping == null)
            throw new ShippingNotFoundException("id-" + id);

        return shipping;
    }


    @PostMapping(value = "/api/shippings", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addShipping(@RequestBody Shipping shipping) {
        Shipping test = new Shipping();
        test.setId(shipping.getId());
        test.setTruck(shipping.getTruck());
        Shipping createdShipping = shippingService.saveShipping(test);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdShipping.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    @DeleteMapping("/api/shippings/{id}")
    public Shipping deleteShippingById(@PathVariable String id) {
        Shipping shipping = shippingService.deleteShipping(id);

        if (shipping == null)
            throw new ShippingNotFoundException("id-" + id);
        return shipping;
    }

    @PutMapping("/api/shippings/{id}")
    public void updateShippingById(@PathVariable String id, @RequestBody Shipping shipping) {
        Shipping foundShipping = shippingService.getShippingById(id);

        if (foundShipping == null)
            throw new ShippingNotFoundException("id-" + id);

        shippingService.saveShipping(shipping);
    }

    
}
