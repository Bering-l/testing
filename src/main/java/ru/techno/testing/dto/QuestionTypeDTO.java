package ru.techno.testing.dto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.techno.testing.model.enums.Type;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuestionTypeDTO extends BaseDTO {

    Type type;

    List<QuestionDTO> question = new ArrayList<>();

    public QuestionTypeDTO(Integer id, Type type, List<QuestionDTO> question) {
        super(id);
        this.type = type;
        this.question = question;
    }
}
