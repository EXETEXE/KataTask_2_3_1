package ru.exetexe.kata.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.exetexe.kata.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Transactional(readOnly = true)
public class UserDaoImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findAll() {

        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User findOne(Long id) {

        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void save(User user) {

        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {

        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    @Transactional
    public void update(Long id, User user) {

        entityManager.merge(user);
    }
}
