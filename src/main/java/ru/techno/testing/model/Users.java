package ru.techno.testing.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import java.util.Collection;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "users", schema = "test")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Users extends BaseEntity {

    String email;

    String password;

    @ManyToMany
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    Collection<Role> roles;
}
