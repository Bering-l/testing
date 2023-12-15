package ru.techno.testing.repository;

import org.springframework.stereotype.Repository;
import ru.techno.testing.model.Users;

import java.util.Optional;

@Repository
public interface UsersRepository extends BaseRepository<Users> {
    Optional<Users> findByEmail(String email);
}
