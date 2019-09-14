package com.unisalento.move.service;

import com.unisalento.move.model.Spedizione;
import com.unisalento.move.repository.SpedizioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpedizioneService {
    private final SpedizioneRepository spedizioneRepository;

    @Autowired
    public SpedizioneService(SpedizioneRepository spedizioneRepository) {
        this.spedizioneRepository = spedizioneRepository;
    }

    public List<Spedizione> getAllSpediziones() {
        return spedizioneRepository.findAll();
    }

    public Spedizione getSpedizioneById(String spedizioneId) {

        Optional<Spedizione> foundSpedizione = spedizioneRepository.findById(spedizioneId);

        return foundSpedizione.orElse(null);

    }

    public Spedizione saveSpedizione(Spedizione spedizione) {
        return spedizioneRepository.save(spedizione);
    }

    public Spedizione deleteSpedizione(String spedizioneId) {

        Optional<Spedizione> optionalSpedizione = spedizioneRepository.findById(spedizioneId);

        if (optionalSpedizione.isPresent()) {
            spedizioneRepository.deleteById(spedizioneId);
            return optionalSpedizione.get();
        }

        return null;
    }

}
