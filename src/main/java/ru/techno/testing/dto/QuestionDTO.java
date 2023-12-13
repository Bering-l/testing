package ru.techno.testing.dto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.techno.testing.model.CorrectAnswer;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuestionDTO extends BaseDTO {

    Short maxPoint;

    String description;

    String file;

    CorrectAnswer correctAnswer;

    Set<TestDTO> testSet = new HashSet<>();

}
