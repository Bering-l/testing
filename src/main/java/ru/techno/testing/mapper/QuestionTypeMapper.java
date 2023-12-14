package ru.techno.testing.mapper;

import org.springframework.stereotype.Component;
import ru.techno.testing.dto.QuestionTypeDTO;
import ru.techno.testing.model.QuestionType;
@Component
public class QuestionTypeMapper extends BaseMapper<QuestionType, QuestionTypeDTO> {
    public QuestionTypeMapper() {
        super(QuestionType.class, QuestionTypeDTO.class);
    }
}
