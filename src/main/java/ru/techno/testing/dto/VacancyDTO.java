package ru.techno.testing.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VacancyDTO extends BaseDTO {

    @NotBlank(message = "Поле не может быть пустым")
    String vacancyName;

    public VacancyDTO() {
    }
    public VacancyDTO(Integer id, String vacancyName) {
        super(id);
        this.vacancyName = vacancyName;
    }
}
