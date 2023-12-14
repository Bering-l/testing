package ru.techno.testing.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.techno.testing.model.Author;
import ru.techno.testing.model.Department;

import org.springframework.data.domain.Pageable;

@Repository
public interface AuthorRepository<T extends Author> extends JpaRepository<T, Short> {
    Page<Author> findAuthorByLastName(String lastName, Pageable pageable);
    Page<Author> findAuthorByDepartment(Department department, Pageable pageable);
    Page<Author> findAuthorByEmail(String email, Pageable pageable);
}
