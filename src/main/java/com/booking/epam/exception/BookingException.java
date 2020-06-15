package com.booking.epam.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@ToString
public class BookingException extends RuntimeException {
    private static final long serialVersionUID = -1872577686242540398L;

    private final String message;
    private final HttpStatus httpStatus;

    /**
     * Creates exception with default status 500
     *
     * @param message
     */
    public BookingException(String message) {
        this.message = message;
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
