package ru.techno.testing.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EntityNotFoundException extends RuntimeException {
    Integer entityId;
    String entityClass;
}
