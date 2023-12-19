package ru.techno.testing.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.techno.testing.dto.VacancyDTO;

import ru.techno.testing.model.Vacancy;
import ru.techno.testing.repository.VacancyRepository;
import ru.techno.testing.service.VacancyService;


@Service
public class VacancyServiceImpl extends CrudServiceImpl<Vacancy, VacancyRepository> implements VacancyService {
    protected VacancyServiceImpl(VacancyRepository repository) {
        super(repository, Vacancy.class);
    }
    @Override
    public Page<VacancyDTO> getAllVacancy(int pageNumber, int pageSize) {
        Pageable request = PageRequest.of(pageNumber, pageSize);
        return repository
                .findAll(request).map(vacancy -> new VacancyDTO(vacancy.getId(), vacancy.getVacancyName()));
    }
}
