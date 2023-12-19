package ru.techno.testing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class BaseDTO {

    private Integer id;

    protected BaseDTO() {
    }
}
