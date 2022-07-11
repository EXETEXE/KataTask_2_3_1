package ru.exetexe.kata.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.exetexe.kata.models.User;
import ru.exetexe.kata.repositories.UsersRepository;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<User> findAll() {
        return usersRepository.findAll();
    }

    public User findOne(Long id) {
        Optional<User> optional = usersRepository.findById(id);

        return optional.orElse(null);
    }

    @Transactional
    public void save(User user) {
        usersRepository.save(user);
    }

    @Transactional
    public void update(Long id, User updatedUser) {

        updatedUser.setId(id);
        usersRepository.save(updatedUser);
    }

    @Transactional
    public void delete(Long id) {

        usersRepository.deleteById(id);
    }
}
