package ru.techno.testing.model.enums;

import lombok.Getter;

@Getter
public enum Type {
    MULTIPLE_CHOICE,
    MULTIPLE_RESPONSE,
    TRUE_OR_FALSE,
    LIKERT_SCALE,
    TASK,
    SEQUENCE,
    SHORT_ANSWER
}
