package ru.techno.testing.repository;

import org.springframework.stereotype.Repository;
import ru.techno.testing.model.Role;

import java.util.Optional;
@Repository
public interface RoleRepository extends BaseRepository<Role> {
    Optional<Role> findByName(String name);
}
