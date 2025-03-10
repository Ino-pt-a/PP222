package web.service;

import java.util.List;
import web.model.User;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    void delete(long id);
    void update(User user);
    User getUserById(long id);
}
