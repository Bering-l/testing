package ru.techno.testing.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.techno.testing.dto.AuthorDTO;
import ru.techno.testing.model.Author;

import java.util.Objects;


@Component
public class AuthorMapper  {
    private final ModelMapper mapper;
    @Autowired
    public AuthorMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Author toEntity(AuthorDTO dto) {
        return Objects.isNull(dto)
                ? null
                : mapper.map(dto, Author.class);
    }

    public AuthorDTO toDto(Author entity) {
        return Objects.isNull(entity)
                ? null
                : mapper.map(entity, AuthorDTO.class);
    }
}
