package com.unisalento.move.repository;

import com.unisalento.move.model.Spedizione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpedizioneRepository extends JpaRepository<Spedizione, Long> {
    Optional<Spedizione> findById(String spedizioneId);
    void deleteById(String spedizioneId);


}