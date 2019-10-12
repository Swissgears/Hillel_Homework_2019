package http.homework_22_H2;

import java.util.List;

public interface Storage {

    void addUser(User user);

    void updateUser(User user);

    User getUser(int id);

    List<User> getAllUsers();

    void removeUser(int id);

    void removeUserByName(String name);

    void removeAll();
}


