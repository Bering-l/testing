package ru.techno.testing.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "correct_answer", schema = "test")
public class CorrectAnswer extends BaseEntity {

    String answer;
}
