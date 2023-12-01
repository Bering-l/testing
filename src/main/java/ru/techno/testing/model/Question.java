package ru.techno.testing.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "question", schema = "test")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Question extends BaseEntity {

    @Column(name = "max_point")
    Short maxPoint;

    String description;

    String file;

    @Column(name = "last_update", columnDefinition = "timestamp DEFAULT CURRENT_TIMESTAMP")
    @UpdateTimestamp
    LocalDateTime lastUpdate;

    @OneToOne
    @JoinColumn(name = "correct_answer_id")
    CorrectAnswer correctAnswer;
}