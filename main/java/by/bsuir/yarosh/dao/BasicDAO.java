package by.bsuir.yarosh.dao;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.util.*;

@Repository
@Scope("prototype")
public class BasicDAO<T, PK extends Serializable> {
    @Autowired
    private SessionFactory sessionFactory;

    public T create(T object) {
        getSession().save(object);
        return object;
    }

    public Collection<T> read(String queryText, int amount, int skip, Map<String, Object> params) {
        Query query = getSession().createQuery(queryText).setFirstResult(skip).setMaxResults(amount);

        if(params!=null) {
            for(String key: params.keySet()) {
                if(params.get(key) instanceof String) {
                    if(((String) params.get(key)).length()>0) {
                        query.setParameter(key.toLowerCase(), "%" + params.get(key) + "%");
                    }
                } else {
                    query.setParameter(key.toLowerCase(), params.get(key));
                }
            }
        }

        return query.list();
    }

    public T read(String query, PK pk, Class aClass) {
        return (T) getSession().get(aClass, pk);
    }

    public T update(T object) {
        getSession().update(object);
        return object;
    }

    public T delete(T object) {
        getSession().delete(object);
        return object;
    }

    public long getCount(String queryText, Map<String, Object> params) {
        Query query = getSession().createQuery(queryText);

        if(params!=null) {
            for(String key: params.keySet()) {
                if(params.get(key) instanceof String) {
                    if(((String) params.get(key)).length()>0) {
                        query.setParameter(key.toLowerCase(), "%" + params.get(key) + "%");
                    }
                } else {
                    query.setParameter(key.toLowerCase(), params.get(key));
                }
            }
        }

        return (long) query.uniqueResult();
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
