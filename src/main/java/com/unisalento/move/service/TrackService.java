package com.unisalento.move.service;

import com.unisalento.move.model.Track;
import com.unisalento.move.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackService {

    private final TrackRepository trackRepository;

    @Autowired
    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    public Track getTrackById(String trackId) {

        Optional<Track> foundTrack = trackRepository.findById(trackId);

        return foundTrack.orElse(null);

    }

    public Track saveTrack(Track track) {
        return trackRepository.save(track);
    }

    public Track deleteTrack(String trackId) {

      Optional<Track> optionalTrack = trackRepository.findById(trackId);

        if (optionalTrack.isPresent()) {
            trackRepository.deleteById(trackId);
            return optionalTrack.get();
        }

        return null;
    }
}
