package ru.techno.testing.mapper;

import org.springframework.stereotype.Component;
import ru.techno.testing.dto.AnswerDTO;
import ru.techno.testing.model.Answer;
@Component
public class AnswerMapper extends BaseMapper<Answer, AnswerDTO> {
    public AnswerMapper() {
        super(Answer.class, AnswerDTO.class);
    }

}
