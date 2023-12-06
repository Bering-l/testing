package ru.techno.testing.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.techno.testing.model.Candidate;
import ru.techno.testing.model.Test;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VacancyDTO extends BaseDTO {

    Test test;

    @NotBlank(message = "Поле не может быть пустым")
    String vacancyName;

    Set<Candidate> candidateSet = new HashSet<>();

}
