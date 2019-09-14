package com.unisalento.move.controller;

import com.unisalento.move.model.Spedizione;
import com.unisalento.move.exeption.SpedizioneNotFoundException;
import com.unisalento.move.service.SpedizioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpedizioneController {

    private final SpedizioneService spedizioneService;

    @Autowired
    public SpedizioneController(SpedizioneService spedizioneService) {
        this.spedizioneService = spedizioneService;
    }

    @GetMapping("/protected/spediziones")
    public List<Spedizione> getAllDevices() {
        return spedizioneService.getAllSpediziones();
    }

    @GetMapping("/protected/spediziones/{id}")
    public Spedizione getDeviceById(@PathVariable String id) {
        Spedizione spedizione = spedizioneService.getSpedizioneById(id);

        if (spedizione == null)
            throw new SpedizioneNotFoundException("id-"+id);

        return spedizione;
    }


    
}
