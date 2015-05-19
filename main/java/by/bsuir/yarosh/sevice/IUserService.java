package by.bsuir.yarosh.sevice;

import by.bsuir.yarosh.domain.*;

import java.util.*;

public interface IUserService {
    Collection<User> getUsers(Map<String, Object> params, int amount, int skip, HashMap<String, String> orderBy);
    User getUser(int id);
    User getUser(String login);
    User createUser(User user);
    User updateUser(User user);
    User deactivateUser(User user);
}
