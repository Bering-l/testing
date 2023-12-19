package ru.techno.testing.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.BindingResult;
@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DtoValidationException extends RuntimeException {

    final BindingResult bindingResult;

}
