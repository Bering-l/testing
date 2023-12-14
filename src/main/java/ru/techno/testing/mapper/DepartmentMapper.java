package ru.techno.testing.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.techno.testing.dto.DepartmentDTO;
import ru.techno.testing.model.Department;

import java.util.Objects;

@Component
public class DepartmentMapper {
    private final ModelMapper mapper;

    @Autowired
    public DepartmentMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Department toEntity(DepartmentDTO dto) {
        return Objects.isNull(dto)
                ? null
                : mapper.map(dto, Department.class);
    }

    public DepartmentDTO toDto(Department entity) {
        return Objects.isNull(entity)
                ? null
                : mapper.map(entity, DepartmentDTO.class);
    }
}
