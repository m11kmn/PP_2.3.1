package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.models.User;
import org.springframework.stereotype.Service;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<User> getListUsers() {
        return userDao.getListUsers();
    }

    @Transactional
    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    @Transactional(readOnly = true)
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Transactional
    public void updateUser(long id, User updetedUser) {
        userDao.updateUser(id, updetedUser);
    }
}
