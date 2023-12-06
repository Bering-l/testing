package ru.techno.testing.dto;


import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.techno.testing.model.enums.DepartmentEnum;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentDTO {

    @NotNull
    Short id;

    DepartmentEnum departmentEnum;

}
