package com.unisalento.move.controller;

import com.unisalento.move.model.Hub;
import com.unisalento.move.exeption.HubNotFoundException;
import com.unisalento.move.service.HubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class HubController {

    private final HubService hubService;

    @Autowired
    public HubController(HubService hubService) {
        this.hubService = hubService;
    }

    @GetMapping("/protected/hubs")
    public List<Hub> getAllDevices() {
        return hubService.getAllHubs();
    }

    @GetMapping("/protected/hubs/{id}")
    public Hub getDeviceById(@PathVariable String id) {
        Hub hub = hubService.getHubById(id);

        if (hub == null)
            throw new HubNotFoundException("id-"+id);

        return hub;
    }

    @PostMapping("/protected/hubs")
    public ResponseEntity<Object> addHub(@RequestBody Hub hub) {
        Hub createdHub = hubService.saveHub(hub);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdHub.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }





    @DeleteMapping("/hubs/{id}")
    public Hub deleteHubById(@PathVariable String id) {
        Hub hub = hubService.deleteHub(id);

        if (hub == null)
            throw new HubNotFoundException("id-"+id);

        return hub;
    }

    @PutMapping("/hubs/{id}")
    public void deleteHubById(@PathVariable String id, @RequestBody Hub hub) {
        Hub foundHub = hubService.getHubById(id);

        if (foundHub == null)
            throw new HubNotFoundException("id-"+id);

        hubService.saveHub(hub);
    }
    
}
