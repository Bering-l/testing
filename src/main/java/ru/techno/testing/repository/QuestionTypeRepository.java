package ru.techno.testing.repository;

import org.springframework.stereotype.Repository;
import ru.techno.testing.model.QuestionType;
import ru.techno.testing.model.enums.Type;

@Repository
public interface QuestionTypeRepository extends BaseRepository<QuestionType> {
    Short countQuestionTypeByType(Type type);
}
