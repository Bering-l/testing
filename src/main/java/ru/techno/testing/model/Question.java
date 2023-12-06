package ru.techno.testing.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "question", schema = "test")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Question extends BaseEntity {

    @Column(name = "max_point")
    Short maxPoint;

    String description;

    String file;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "correct_answer_id")
    CorrectAnswer correctAnswer;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "test_question", joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "test_id"))
    Set<Test> testSet = new HashSet<>();
}
