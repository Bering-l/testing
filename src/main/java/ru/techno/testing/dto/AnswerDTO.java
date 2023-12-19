package ru.techno.testing.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AnswerDTO extends BaseDTO {

    String answer;

    public AnswerDTO(Integer id, String answer) {
        super(id);
        this.answer = answer;
    }
}
