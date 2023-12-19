package ru.techno.testing.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "question", schema = "test_system")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Question extends BaseEntity {

    String description;

    String file;

    @OneToMany(fetch = FetchType.EAGER)
    Set <Answer> answers = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_type_id")
    QuestionType questionType;

    @ManyToOne
    @JoinColumn(name = "test_id", nullable = false)
    Test test;

    @Column(name = "last_update", columnDefinition = "timestamp DEFAULT CURRENT_TIMESTAMP")
    @UpdateTimestamp
    LocalDateTime lastUpdate;
}
