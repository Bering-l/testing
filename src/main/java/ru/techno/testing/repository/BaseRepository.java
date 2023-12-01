package ru.techno.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.techno.testing.model.Author;

@RepositoryRestResource(path = "test")
public interface BaseRepository extends JpaRepository<Author, Integer> {
}
