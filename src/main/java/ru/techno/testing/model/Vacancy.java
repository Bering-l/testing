package ru.techno.testing.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "vacancy", schema = "test_system")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Vacancy extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    Test test;

    @Column(name = "vacancy_name")
    String vacancyName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "candidate_choose_vacancy", joinColumns = @JoinColumn(name = "vacancy_id"),
            inverseJoinColumns = @JoinColumn(name = "candidate_id"))
    Set<Candidate> candidateSet = new HashSet<>();

}
