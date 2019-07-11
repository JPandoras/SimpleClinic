package app.springboot.simpleclinic.repositories.impl;

import app.springboot.simpleclinic.models.UserLogin;
import app.springboot.simpleclinic.repositories.UserLoginRepository;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public class UserLoginRepositoryImpl implements UserLoginRepository {

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public UserLogin getUserByUsername(String username) {
        Query<UserLogin> query = sessionFactory.getCurrentSession().createQuery("FROM UserLogin WHERE username = :username", UserLogin.class);
        query.setParameter("username", username);
        return query.uniqueResult();
    }

    @Override
    public <S extends UserLogin> S save(S s) {
        return null;
    }

    @Override
    public <S extends UserLogin> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<UserLogin> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public Iterable<UserLogin> findAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM UserLogin", UserLogin.class).list();
    }

    @Override
    public Iterable<UserLogin> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(UserLogin userLogin) {

    }

    @Override
    public void deleteAll(Iterable<? extends UserLogin> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
