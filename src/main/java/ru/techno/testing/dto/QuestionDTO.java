package ru.techno.testing.dto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuestionDTO extends BaseDTO {

    Short maxPoint;

    String description;

    String file;

    AnswerDTO correctAnswer;

    Set<TestDTO> testSet = new HashSet<>();

    public QuestionDTO(Integer id, Short maxPoint, String description, String file, AnswerDTO correctAnswer, Set<TestDTO> testSet) {
        super(id);
        this.maxPoint = maxPoint;
        this.description = description;
        this.file = file;
        this.correctAnswer = correctAnswer;
        this.testSet = testSet;
    }
}
