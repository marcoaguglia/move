package com.unisalento.move.controller;

import com.unisalento.move.exeption.ContainerNotFoundException;
import com.unisalento.move.model.Container;
import com.unisalento.move.service.ContainerService;
import io.swagger.annotations.ApiOperation;
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


    @ApiOperation(value = "Get all containers")
    @GetMapping("/api/containers")
    public List<Container> getAllDevices() {
        return containerService.getAllContainers();
    }

    @GetMapping("/api/containers/{id}")
    public Container getDeviceById(@PathVariable String id) {
        Container container = containerService.getContainerById(id);


        if (container == null)
            throw new ContainerNotFoundException("id-"+id);

        return container;
    }


    @PostMapping("/api/containers")
    public ResponseEntity<Object> addContainer(@RequestBody Container container) {
        Container createdContainer = containerService.saveContainer(container);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdContainer.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    @DeleteMapping("/api/containers/{id}")
    public Container deleteContainerById(@PathVariable String id) {
        Container container = containerService.deleteContainer(id);

        if (container == null)
            throw new ContainerNotFoundException("id-"+id);
        return container;
    }

    @PutMapping("/api/containers/{id}")
    public void updateContainerById(@PathVariable String id, @RequestBody Container container) {
        Container foundContainer = containerService.getContainerById(id);

        if (foundContainer == null)
            throw new ContainerNotFoundException("id-"+id);

        containerService.saveContainer(container);
    }

}
