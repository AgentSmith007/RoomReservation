package com.booking.epam.service;

import com.booking.epam.exception.BookingException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ValidatorService {

    public void validateUUID(UUID id) {
        if (id == null) {
            throw new BookingException("Id must not be null", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

}
