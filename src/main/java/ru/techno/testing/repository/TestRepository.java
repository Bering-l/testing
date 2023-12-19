package ru.techno.testing.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import ru.techno.testing.model.Author;
import ru.techno.testing.model.Test;

import java.time.LocalDateTime;

@Repository
public interface TestRepository extends BaseRepository<Test> {

    Page<Test> findTestByAuthorLastName(String lastName, Pageable pageable);

    Page<Test> findTestByAuthorFirstName(String firstName, Pageable pageable);

    Page<Test> findTestByAuthorFirstNameAndAuthorLastName(String firstName, String lastName, Pageable pageable);

    Page<Test> findTestByLastUpdate(Test test, LocalDateTime lastUpdate, Pageable page);

}
