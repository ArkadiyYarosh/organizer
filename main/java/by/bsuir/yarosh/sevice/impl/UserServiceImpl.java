package by.bsuir.yarosh.sevice.impl;

import by.bsuir.yarosh.dao.*;
import by.bsuir.yarosh.domain.*;
import by.bsuir.yarosh.sevice.*;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.authentication.encoding.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private BasicDAO<User, Integer> dao;
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Collection<User> getUsers(Map<String, Object> params, int amount, int skip, HashMap<String, String> orderBy) {
        String query = "from User";

        if(params!=null && params.size() > 0) {
            query += " where ";

            for(String key: params.keySet()) {
                if(params.get(key) instanceof String) {
                    if(((String) params.get(key)).length()>0) {
                        query += key + " like :" + key.toLowerCase();
                        query += " and ";
                    }
                } else {
                    query += key + " = :" + key.toLowerCase();
                    query += " and ";
                }
            }
            query = query.substring(0, query.length()-5);
        }

        if(orderBy !=null && orderBy.size() > 0) {
            query += " order by ";

            for(String key: orderBy.keySet()) {
                query += key + " " + orderBy.get(key) + ",";
            }

            query = query.substring(0, query.length()-1);
        }

        return dao.read(query, amount, skip, params);
    }

    @Override
    public User getUser(int id) {
        return dao.read("from User where UserId=:pk", id, User.class);
    }

    @Override
    public User getUser(String login) {
        return (User) sessionFactory.getCurrentSession().createQuery("from User where login=:log").setParameter("log", login).uniqueResult();
    }

    @Override
    public User createUser(User user) {
        PasswordEncoder encoder = new ShaPasswordEncoder();
        user.setPassword(encoder.encodePassword(user.getPassword(), null));

        if(user.getRights()==null) {
            user.setRights(2);
        }

        return dao.create(user);
    }

    @Override
    public User updateUser(User user) {
        return dao.update(user);
    }

    @Override
    public User deactivateUser(User user) {
        user.setRights(user.getRights()!=0?0:2);
        return dao.update(user);
    }
}
