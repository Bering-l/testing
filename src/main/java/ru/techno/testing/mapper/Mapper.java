package ru.techno.testing.mapper;

import ru.techno.testing.dto.BaseDTO;
import ru.techno.testing.model.BaseEntity;

public interface Mapper<E extends BaseEntity, D extends BaseDTO> {
    E toEntity(D dto);
    D toDto(E entity);
}
