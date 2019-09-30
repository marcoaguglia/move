package com.unisalento.move.controller;

import com.unisalento.move.exeption.TruckNotFoundException;
import com.unisalento.move.model.Truck;
import com.unisalento.move.service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class TruckController {

    private final TruckService truckService;

    @Autowired
    public TruckController(TruckService truckService) {
        this.truckService = truckService;
    }

    @GetMapping("/api/protected/trucks")
    public List<Truck> getAllDevices() {
        return truckService.getAllTrucks();
    }

    @GetMapping("/api/protected/trucks/{id}")
    public Truck getDeviceById(@PathVariable String id) {
        Truck truck = truckService.getTruckById(id);

        if (truck == null)
            throw new TruckNotFoundException("id-" + id);

        return truck;
    }


    @PostMapping("/api/trucks")
    public ResponseEntity<Object> addTruck(@RequestBody Truck truck) {
        Truck createdTruck = truckService.saveTruck(truck);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdTruck.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    @DeleteMapping("/api/trucks/{id}")
    public Truck deleteTruckById(@PathVariable String id) {
        Truck truck = truckService.deleteTruck(id);

        if (truck == null)
            throw new TruckNotFoundException("id-" + id);
        return truck;
    }

    @PutMapping("/api/trucks/{id}")
    public void updateTruckById(@PathVariable String id, @RequestBody Truck truck) {
        Truck foundTruck = truckService.getTruckById(id);

        if (foundTruck == null)
            throw new TruckNotFoundException("id-" + id);

        truckService.saveTruck(truck);
    }
}
