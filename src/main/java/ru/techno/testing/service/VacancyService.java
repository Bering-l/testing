package ru.techno.testing.service;

import org.springframework.data.domain.Page;
import ru.techno.testing.dto.VacancyDTO;
import ru.techno.testing.model.Vacancy;

public interface VacancyService extends CrudService<Vacancy> {
    Page<VacancyDTO> getAllVacancy(int pageNumber, int pageSize);
}
