package ru.techno.testing.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Entity
@Getter
@Setter
@Table(name = "author", schema = "test")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Author {

    @Id
    @Column(name = "author_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Byte id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @OneToOne
    @JoinColumn(name = "department_id")
    Department department;

    String email;

    String description;
}
