package ru.techno.testing.repository;

import org.springframework.stereotype.Repository;
import ru.techno.testing.model.CorrectAnswer;
import ru.techno.testing.model.Question;
@Repository
public interface QuestionRepository extends BaseRepository<Question> {
    Integer countByCorrectAnswer(CorrectAnswer correctAnswer);
}
