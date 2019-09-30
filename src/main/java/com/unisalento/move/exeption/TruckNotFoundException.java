package com.unisalento.move.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TruckNotFoundException extends RuntimeException {

    public TruckNotFoundException(String message) {
        super(message);
    }
}
