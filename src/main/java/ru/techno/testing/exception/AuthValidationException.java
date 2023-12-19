package ru.techno.testing.exception;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthValidationException {

    Integer status;
    String message;
    LocalDateTime timestamp;

    public AuthValidationException(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
}
