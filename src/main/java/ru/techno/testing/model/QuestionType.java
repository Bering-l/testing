package ru.techno.testing.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.techno.testing.model.enums.Type;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "question_type", schema = "test")
public class QuestionType extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    Type type;
}
