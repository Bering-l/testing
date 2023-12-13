package ru.techno.testing.mapper;

import org.modelmapper.Converter;
import ru.techno.testing.dto.BaseDTO;
import ru.techno.testing.model.BaseEntity;
import org.modelmapper.ModelMapper;

import java.util.Objects;

public abstract class BaseMapper<E extends BaseEntity, D extends BaseDTO> implements Mapper<E, D> {

    ModelMapper mapper;

    private final Class<E> entity;
    private final Class<D> dto;

    public BaseMapper(Class<E> entity, Class<D> dto) {
        this.entity = entity;
        this.dto = dto;
    }

    @Override
    public E toEntity(D dto) {
        return Objects.isNull(dto)
                ? null
                : mapper.map(dto, entity);
    }

    @Override
    public D toDto(E entity) {
        return Objects.isNull(entity)
                ? null
                : mapper.map(entity, dto);
    }

    Converter<E, D> toDtoConverter() {
        return context -> {
            E source = context.getSource();
            D destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    Converter<D,E> toEntityConverter() {
        return context -> {
            D sourse = context.getSource();
            E destination = context.getDestination();
            mapSpecificFields(sourse, destination);
            return context.getDestination();
        };
    }

    void mapSpecificFields(E source, D destination) {
    }

    void mapSpecificFields(D source, E destination) {
    }
}
