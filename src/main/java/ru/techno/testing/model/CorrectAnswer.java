package ru.techno.testing.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "correct_answer", schema = "test")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CorrectAnswer extends BaseEntity {

    String answer;
}
