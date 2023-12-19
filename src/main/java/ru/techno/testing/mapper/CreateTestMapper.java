package ru.techno.testing.mapper;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.techno.testing.dto.CreateTestDTO;
import ru.techno.testing.model.Test;
import ru.techno.testing.repository.TestRepository;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateTestMapper extends BaseMapper<Test, CreateTestDTO>{

    final ModelMapper mapper;
    final TestRepository testRepository;
    @Autowired
    public CreateTestMapper(ModelMapper mapper, TestRepository testRepository) {
        super(Test.class, CreateTestDTO.class);
        this.mapper = mapper;
        this.testRepository = testRepository;
    }



}
