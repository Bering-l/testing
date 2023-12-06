package ru.techno.testing.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.techno.testing.model.Vacancy;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CandidateDTO extends BaseDTO {

    @Size(min = 2, message = "Поле \"Имя\" должно содержать более двух символов")
    String firstName;

    @Size(min = 2, message = "Поле \"Фамилия\" должно содержать более двух символов")
    String lastName;

    @Email(message = "Не корректный email")
    String email;

    @NotBlank(message = "Укажите пароль")
    String password;

    @NotNull
    LocalDateTime createDate;

    @NotNull
    LocalDateTime lastSession;

    Set<Vacancy> vacancySet = new HashSet<>();

}
