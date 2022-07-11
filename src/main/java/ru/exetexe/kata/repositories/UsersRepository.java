package ru.exetexe.kata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.exetexe.kata.models.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
}
