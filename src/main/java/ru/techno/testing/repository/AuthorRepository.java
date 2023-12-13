package ru.techno.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.techno.testing.model.Author;

@Repository
public interface AuthorRepository<T extends Author> extends JpaRepository<T, Short> {
}
