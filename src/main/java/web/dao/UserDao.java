package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import javax.persistence.TypedQuery;
import java.util.List;

public interface UserDao {

    public void saveUser(User user);

    public List<User> getListUsers();

    public void removeUserById(long id);

    public User getUserById(long id);

    public void updateUser(long id, User updetedUser);
}
