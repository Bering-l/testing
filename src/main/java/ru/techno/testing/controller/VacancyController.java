package ru.techno.testing.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.techno.testing.dto.VacancyDTO;
import ru.techno.testing.exception.DtoValidationException;
import ru.techno.testing.mapper.VacancyMapper;
import ru.techno.testing.model.Vacancy;
import ru.techno.testing.service.impl.VacancyServiceImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/vacancies")
public class VacancyController {

    private final VacancyServiceImpl vacancyService;
    private final VacancyMapper mapper;

    @GetMapping
    public Page<VacancyDTO> getAll(@RequestParam final int pageNumber, @RequestParam final int pageSize) {
        return vacancyService.getAllVacancy(pageNumber, pageSize);
    }

    @PostMapping
    public void saveVacancy(@Valid @RequestBody final VacancyDTO vacancyDTO,
                                                              final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new DtoValidationException(bindingResult);
        }
        Vacancy vacancy = mapper.toEntity(vacancyDTO);
        vacancyService.save(vacancy);
    }

    @PostMapping("/{id}")
    public VacancyDTO updateVacancy(@PathVariable final Integer id, @Valid @RequestBody final VacancyDTO vacancyDTO,
                                    final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new DtoValidationException(bindingResult);
        }
        Vacancy vacancy = mapper.toEntity(vacancyDTO);
        vacancyService.update(id, vacancy);
        return mapper.toDto(vacancy);
    }

}
