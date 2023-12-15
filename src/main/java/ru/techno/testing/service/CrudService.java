package ru.techno.testing.service;

import org.springframework.data.domain.Page;
import ru.techno.testing.model.BaseEntity;

public interface CrudService<E extends BaseEntity> {
    E getById(Integer id);
    void save(E e);
    void delete(Integer id);
    E update(Integer id, E e);
    Page<E> findAll(Integer pageNumber, String sortField, String sortDirection);
}
