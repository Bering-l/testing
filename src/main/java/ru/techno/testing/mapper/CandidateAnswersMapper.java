package ru.techno.testing.mapper;

import org.springframework.stereotype.Component;
import ru.techno.testing.dto.CandidateAnswersDTO;
import ru.techno.testing.model.CandidateAnswers;
@Component
public class CandidateAnswersMapper extends BaseMapper<CandidateAnswers, CandidateAnswersDTO> {
    public CandidateAnswersMapper() {
        super(CandidateAnswers.class, CandidateAnswersDTO.class);
    }
}
