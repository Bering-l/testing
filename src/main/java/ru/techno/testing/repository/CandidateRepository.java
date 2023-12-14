package ru.techno.testing.repository;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import ru.techno.testing.model.Candidate;


import org.springframework.data.domain.Pageable;
import java.time.LocalDateTime;

@Repository
public interface CandidateRepository extends BaseRepository<Candidate> {
    Page<Candidate> findCandidateByLastName(String lastName, Pageable pageable);
    Page<Candidate> findCandidateByEmail(String email, Pageable pageable);
    Page<Candidate> findCandidateByCreateDateAndLastSession(LocalDateTime createdDate, LocalDateTime lastSession,
                                                               Pageable pageable);
}
