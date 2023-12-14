package ru.techno.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import ru.techno.testing.model.Department;

@Repository
public interface DepartmentRepository<T extends Department> extends JpaRepository<T, Short> {

}
