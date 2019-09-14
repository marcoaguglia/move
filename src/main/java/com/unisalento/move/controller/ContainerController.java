package com.unisalento.move.controller;

import com.unisalento.move.model.Container;
import com.unisalento.move.exeption.ContainerNotFoundException;
import com.unisalento.move.service.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ContainerController {

    private final ContainerService containerService;

    @Autowired
    public ContainerController(ContainerService containerService) {
        this.containerService = containerService;
    }

    @GetMapping("/protected/containers")
    public List<Container> getAllDevices() {
        return containerService.getAllContainers();
    }

    @GetMapping("/protected/containers/{id}")
    public Container getDeviceById(@PathVariable String id) {
        Container container = containerService.getContainerById(id);

        if (container == null)
            throw new ContainerNotFoundException("id-"+id);

        return container;
    }


    @PostMapping("protected/containers")
    public ResponseEntity<Object> addContainer(@RequestBody Container container) {
        Container createdContainer = containerService.saveContainer(container);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdContainer.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }



    @DeleteMapping("/containers/{id}")
    public Container deleteContainerById(@PathVariable String id) {
        Container container = containerService.deleteContainer(id);

        if (container == null)
            throw new ContainerNotFoundException("id-"+id);

        return container;
    }

    @PutMapping("/containers/{id}")
    public void deleteContainerById(@PathVariable String id, @RequestBody Container container) {
        Container foundContainer = containerService.getContainerById(id);

        if (foundContainer == null)
            throw new ContainerNotFoundException("id-"+id);

        containerService.saveContainer(container);
    }

}
