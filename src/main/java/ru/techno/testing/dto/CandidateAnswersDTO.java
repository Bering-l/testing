package ru.techno.testing.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.techno.testing.model.Candidate;
import ru.techno.testing.model.Question;

import java.time.LocalDateTime;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CandidateAnswersDTO extends BaseDTO {

    Question question;

    Short point;

    Candidate candidate;

    @NotNull
    LocalDateTime answerDate;

    String answer;
}
