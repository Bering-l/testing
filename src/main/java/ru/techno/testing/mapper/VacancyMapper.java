package ru.techno.testing.mapper;

import org.springframework.stereotype.Component;
import ru.techno.testing.dto.VacancyDTO;
import ru.techno.testing.model.Vacancy;

@Component
public class VacancyMapper extends BaseMapper<Vacancy, VacancyDTO> {
    public VacancyMapper() {
        super(Vacancy.class, VacancyDTO.class);
    }
}
