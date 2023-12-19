package ru.techno.testing.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateTestDTO extends BaseDTO {

    AuthorDTO author;

    Set<QuestionDTO> questionSet = new HashSet<>();

    public CreateTestDTO(Integer id, AuthorDTO author, Set<QuestionDTO> questionSet) {
        super(id);
        this.author = author;
        this.questionSet = questionSet;
    }
}
