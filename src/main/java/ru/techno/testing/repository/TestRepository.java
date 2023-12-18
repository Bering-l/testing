package ru.techno.testing.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import ru.techno.testing.model.Author;
import ru.techno.testing.model.Test;

import java.time.LocalDateTime;

@Repository
public interface TestRepository extends BaseRepository<Test> {

    Page<Test> findTestByAuthorFirstName(String firstName, Pageable page);

    Page<Test> findTestByLastUpdate(Test test, LocalDateTime lastUpdate, Pageable page);

}
