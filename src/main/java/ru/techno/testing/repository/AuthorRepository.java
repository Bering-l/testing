package ru.techno.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.techno.testing.model.Author;

public interface AuthorRepository <T extends Author> extends JpaRepository<T, Short> {
}
