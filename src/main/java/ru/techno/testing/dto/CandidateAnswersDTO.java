package ru.techno.testing.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
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

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    LocalDateTime answerDate;

    String answer;

    public CandidateAnswersDTO(Integer id, Question question, Short point, Candidate candidate, LocalDateTime answerDate, String answer) {
        super(id);
        this.question = question;
        this.point = point;
        this.candidate = candidate;
        this.answerDate = answerDate;
        this.answer = answer;
    }
}
