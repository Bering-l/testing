package ru.techno.testing.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
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
