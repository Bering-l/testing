package ru.techno.testing.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "vacancy", schema = "test")
public class Vacancy extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "test_id")
    Test test;

    @Column(name = "vacancy_name")
    String vacancyName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "candidate_choose_vacancy", joinColumns = @JoinColumn(name = "vacancy_id"),
            inverseJoinColumns = @JoinColumn(name = "candidate_id"))
    Set<Candidate> candidateSet = new HashSet<>();
}
