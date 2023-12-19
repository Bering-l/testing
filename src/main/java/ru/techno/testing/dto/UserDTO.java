package ru.techno.testing.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO extends BaseDTO {

    @Email
    String email;

    @NotNull
    @NotEmpty
    String password;

    public UserDTO(Integer id, String email, String password) {
        super(id);
        this.email = email;
        this.password = password;
    }
// Collection<Role> roles;

}
