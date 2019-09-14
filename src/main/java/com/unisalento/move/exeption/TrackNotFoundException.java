package com.unisalento.move.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TrackNotFoundException extends RuntimeException {

    public TrackNotFoundException(String message) {
        super(message);
    }
}
