package ru.techno.testing.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "test", schema = "test")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Test extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "author_id")
    Author author;

    @Column(name = "last_update", columnDefinition = "timestamp DEFAULT CURRENT_TIMESTAMP")
    @UpdateTimestamp
    LocalDateTime lastUpdate;
}
