package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.models.User;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void saveUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<User> getListUsers() {
        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Transactional
    public void removeUserById(long id) {
        User user = sessionFactory.getCurrentSession().find(User.class, id);
        sessionFactory.getCurrentSession().remove(user);
    }

    @Transactional(readOnly = true)
    public User getUserById(long id) {
        return sessionFactory.getCurrentSession().find(User.class, id);
    }

    @Transactional
    public void updateUser(long id, User updetedUser) {
        User userToBeUpdated = sessionFactory.getCurrentSession().find(User.class, id);
        userToBeUpdated.setFirstName(updetedUser.getFirstName());
        userToBeUpdated.setLastName(updetedUser.getLastName());
        userToBeUpdated.setEmail(updetedUser.getEmail());
    }

}
