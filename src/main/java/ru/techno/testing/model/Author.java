package ru.techno.testing.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Entity
@Data
@Table(name = "author", schema = "test_system")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Author extends BaseEntity {

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    Department department;

}
