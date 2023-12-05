package ru.techno.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.techno.testing.model.Department;

public interface DepartmentRepository<T extends Department> extends JpaRepository<T, Byte> {
}
