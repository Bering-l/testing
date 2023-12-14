package ru.techno.testing.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Entity
@Data
@Table(name = "candidate_answers", schema = "test")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CandidateAnswers extends BaseEntity {

    @Id
    @Column(name = "candidate_answers_id")
    Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id")
    Question question;

    Short point;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    Candidate candidate;

    @Column(name = "answer_date")
    @CreationTimestamp
    LocalDateTime answerDate;

    String answer;
}
