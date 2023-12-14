package ru.techno.testing.mapper;

import org.springframework.stereotype.Component;
import ru.techno.testing.dto.CorrectAnswerDTO;
import ru.techno.testing.model.CorrectAnswer;
@Component
public class CorrectAnswerMapper extends BaseMapper<CorrectAnswer, CorrectAnswerDTO> {
    public CorrectAnswerMapper() {
        super(CorrectAnswer.class, CorrectAnswerDTO.class);
    }
}
