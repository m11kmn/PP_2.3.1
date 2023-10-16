package web.service;

import web.models.User;

import java.util.List;

public interface UserService {

    public void saveUser(User user);

    public List<User> getListUsers();

    public void removeUserById(long id);

    public User getUserById(long id);

    public void updateUser(long id, User updetedUser);
}
