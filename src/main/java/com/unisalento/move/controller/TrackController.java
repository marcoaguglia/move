package com.unisalento.move.controller;

import com.unisalento.move.model.Track;
import com.unisalento.move.exeption.TrackNotFoundException;
import com.unisalento.move.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrackController {

    private final TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping("/protected/tracks")
    public List<Track> getAllDevices() {
        return trackService.getAllTracks();
    }

    @GetMapping("/protected/tracks/{id}")
    public Track getDeviceById(@PathVariable String id) {
        Track track = trackService.getTrackById(id);

        if (track == null)
            throw new TrackNotFoundException("id-"+id);

        return track;
    }
    
}
