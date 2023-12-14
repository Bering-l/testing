package ru.techno.testing.mapper;

import org.springframework.stereotype.Component;
import ru.techno.testing.dto.TestDTO;
import ru.techno.testing.model.Test;
@Component
public class TestMapper extends BaseMapper<Test, TestDTO> {
    public TestMapper() {
        super(Test.class, TestDTO.class);
    }
}
