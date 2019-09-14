package com.unisalento.move.repository;

import com.unisalento.move.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {
    Optional<Track> findById(String trackId);

    void deleteById(String trackId);


}
