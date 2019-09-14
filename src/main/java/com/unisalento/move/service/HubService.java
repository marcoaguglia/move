package com.unisalento.move.service;

import com.unisalento.move.model.Hub;
import com.unisalento.move.repository.HubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HubService {
    private final HubRepository hubRepository;

    @Autowired
    public HubService(HubRepository hubRepository) {
        this.hubRepository = hubRepository;
    }

    public List<Hub> getAllHubs() {
        return hubRepository.findAll();
    }

    public Hub getHubById(String hubId) {

        Optional<Hub> foundHub = hubRepository.findById(hubId);

        return foundHub.orElse(null);

    }

    public Hub saveHub(Hub hub) {
        return hubRepository.save(hub);
    }

    public Hub deleteHub(String hubId) {

        Optional<Hub> optionalHub = hubRepository.findById(hubId);

        if (optionalHub.isPresent()) {
            hubRepository.deleteById(hubId);
            return optionalHub.get();
        }

        return null;
    }

}
