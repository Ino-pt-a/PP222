package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void add(User user) {
        em.persist(user);
    }


    @Override
    @Transactional(readOnly = true)
    public List<User> listUsers() {
        String sql = "select u from User u";
        List<User> users = em.createQuery(sql, User.class).getResultList();
        return users;
    }


    @Override
    @Transactional
    public void delete(long id) {
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }
    }

    @Override
    @Transactional
    public void update(User user) {
        em.merge(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(long id) {
        return em.find(User.class, id);
    }
}