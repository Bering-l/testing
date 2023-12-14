package ru.techno.testing.mapper;

import org.springframework.stereotype.Component;
import ru.techno.testing.dto.QuestionDTO;
import ru.techno.testing.model.Question;
@Component
public class QuestionMapper extends BaseMapper<Question, QuestionDTO> {
    public QuestionMapper() {
        super(Question.class, QuestionDTO.class);
    }
}
