package ru.techno.testing.exception.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExceptionDTO {

    String error;
    String message;
    HttpStatus status;
    LocalDateTime timestamp;

}
