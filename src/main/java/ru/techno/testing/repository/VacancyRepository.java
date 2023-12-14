package ru.techno.testing.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import ru.techno.testing.model.Candidate;
import ru.techno.testing.model.Vacancy;
@Repository
public interface VacancyRepository extends BaseRepository<Vacancy> {
    Page<Vacancy> findAllByVacancyName(String vacancyName, Pageable page);

}
