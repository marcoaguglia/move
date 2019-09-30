package com.unisalento.move.service;

import com.unisalento.move.model.Truck;
import com.unisalento.move.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TruckService {

    private final TruckRepository truckRepository;

    @Autowired
    public TruckService(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }

    public List<Truck> getAllTrucks() {
        return truckRepository.findAll();
    }

    public Truck getTruckById(String truckId) {

        Optional<Truck> foundTruck = truckRepository.findById(truckId);

        return foundTruck.orElse(null);

    }

    public Truck saveTruck(Truck truck) {
        return truckRepository.save(truck);
    }

    public Truck deleteTruck(String truckId) {

        Optional<Truck> optionalTruck = truckRepository.findById(truckId);

        if (optionalTruck.isPresent()) {
            truckRepository.deleteById(truckId);
            return optionalTruck.get();
        }

        return null;
    }
}
