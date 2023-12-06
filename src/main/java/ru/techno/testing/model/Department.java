package ru.techno.testing.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.techno.testing.model.enums.DepartmentEnum;


@Entity
@Data
@Table(name = "department", schema = "test")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Department {

    @Id
    @Column(name = "department_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Short id;

    @Enumerated(EnumType.STRING)
    @Column(name = "department_enum", columnDefinition = "enum('ADMINISTRATION', " +
            "'ACCOUNTING_DEPARTMENT', 'HR', 'IT', 'FINANCIAL_DEPARTMENT', 'SERVICE_DEPARTMENT')")
    DepartmentEnum departmentEnum;

}
