package ru.techno.testing.service;
/*
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.techno.testing.dto.RegistrationUserDto;
import ru.techno.testing.dto.UserDTO;
import ru.techno.testing.exception.AuthValidationException;
import ru.techno.testing.model.Users;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthService {
    private final UsersService userService;

    public ResponseEntity<?> createNewUser(@RequestBody RegistrationUserDto registrationUserDto) {
        if (!arePasswordsEqual(registrationUserDto)) {
            return new ResponseEntity<>(new AuthValidationException(HttpStatus.BAD_REQUEST.value(),
                    "Введеные данные не совпадают"), HttpStatus.BAD_REQUEST);
        }
        if (isUserExists(registrationUserDto)) {
            return new ResponseEntity<>(new AuthValidationException(HttpStatus.BAD_REQUEST.value(),
                    "Пользователь с указанным именем уже существует"), HttpStatus.BAD_REQUEST);
        }
        Users user = userService.createNewUser(registrationUserDto);
        return ResponseEntity.ok(new UserDTO(user.getId(), user.getEmail()));
    }

    private boolean arePasswordsEqual(RegistrationUserDto registrationUserDto) {
        return registrationUserDto.getPassword().equals(registrationUserDto.getConfirmPassword());
    }

    private boolean isUserExists(RegistrationUserDto registrationUserDto) {
        return userService.findByEmail(registrationUserDto.getEmail()).isPresent();
    }
}*/
