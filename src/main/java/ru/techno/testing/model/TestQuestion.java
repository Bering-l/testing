package ru.techno.testing.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "test_question", schema = "test")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestQuestion extends BaseEntity {

    @ManyToMany
    @JoinTable
    List<Question> questionList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "test_id")
    Test test;
}
