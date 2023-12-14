package ru.techno.testing.mapper;

import org.springframework.stereotype.Component;
import ru.techno.testing.dto.CandidateDTO;
import ru.techno.testing.model.Candidate;
@Component
public class CandidateMapper extends BaseMapper<Candidate, CandidateDTO> {
    public CandidateMapper() {
        super(Candidate.class, CandidateDTO.class);
    }
}
