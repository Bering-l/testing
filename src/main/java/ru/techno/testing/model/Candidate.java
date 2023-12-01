package ru.techno.testing.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "candidate", schema = "test")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Candidate extends BaseEntity {
    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "create_date")
    @CreationTimestamp
    LocalDateTime createDate;

    @Column(name = "last_session", columnDefinition = "timestamp DEFAULT CURRENT_TIMESTAMP")
    @UpdateTimestamp
    LocalDateTime lastSession;

    String email;

    @ManyToMany(mappedBy = "candidateSet")
    Set<Vacancy> vacancySet = new HashSet<>();

}
