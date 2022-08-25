package br.com.mobusapp.mobus.dao;

import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

public interface GenericDao<T, PK> extends MobusDao{
    long count(Session var1);

    void save(Session var1, T var2);

    void delete(Session var1, T var2);

    void deleteAll(Session var1);

    T findById(Session var1, PK var2);

    List<T> findAll(Session var1);

    List<T> findAll(Session var1, Order var2);

    List<T> select(Session var1, String var2, Map<String, Object> var3, int var4, int var5);

    void lock(Session var1, T var2);

    void flush(Session var1);
}
