package ru.techno.testing.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.techno.testing.model.Vacancy;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CandidateDTO extends BaseDTO {

    @NotBlank
    @Size(min = 2, message = "Поле \"Имя\" должно содержать более двух символов")
    String firstName;

    @NotBlank
    @Size(min = 2, message = "Поле \"Фамилия\" должно содержать более двух символов")
    String lastName;

    @Email(message = "Не корректный email")
    String email;

    @NotBlank(message = "Укажите пароль")
    String password;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    LocalDateTime createDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    LocalDateTime lastSession;

    Set<Vacancy> vacancySet = new HashSet<>();

}
