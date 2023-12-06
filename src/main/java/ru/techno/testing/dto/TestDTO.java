package ru.techno.testing.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.techno.testing.model.Author;
import ru.techno.testing.model.Question;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestDTO extends BaseDTO {

    Author author;

    LocalDateTime lastUpdate;

    Set<Question> questionSet = new HashSet<>();
}
