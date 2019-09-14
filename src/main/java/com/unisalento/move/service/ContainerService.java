package com.unisalento.move.service;

import com.unisalento.move.model.Container;
import com.unisalento.move.repository.ContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContainerService {
    private final ContainerRepository containerRepository;

    @Autowired
    public ContainerService(ContainerRepository containerRepository) {
        this.containerRepository = containerRepository;
    }

    public List<Container> getAllContainers() {
        return containerRepository.findAll();
    }

    public Container getContainerById(String containerId) {

        Optional<Container> foundContainer = containerRepository.findById(containerId);

        return foundContainer.orElse(null);

    }

    public Container saveContainer(Container container) {
        return containerRepository.save(container);
    }

    public Container deleteContainer(String containerId) {

        Optional<Container> optionalContainer = containerRepository.findById(containerId);

        if (optionalContainer.isPresent()) {
            containerRepository.deleteById(containerId);
            return optionalContainer.get();
        }

        return null;
    }


}
