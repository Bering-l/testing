package ru.techno.testing.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(schema = "test_system", name = "correct_answer")
public class CorrectAnswer extends Answer{
    @Column(name = "max_point")
    Short maxPoint;
}
