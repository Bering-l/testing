package ru.techno.testing.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.techno.testing.model.Department;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorDTO {
    @NotNull
    Short id;

    @Size(min = 2, message = "Поле \"Имя\" должно содержать более двух символов")
    String firstName;

    @Size(min = 2, message = "Поле \"Фамилия\" должно содержать более двух символов")
    String lastName;

    @NotBlank(message = "Выберите отдел")
    DepartmentDTO department;

    @Email(message = "Не корректный email")
    String email;

    @NotBlank(message = "Укажите пароль")
    String password;

    public AuthorDTO(Short id, String firstName, String lastName, DepartmentDTO department, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.email = email;
        this.password = password;
    }
}
