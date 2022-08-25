package br.com.mobusapp.mobus.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.mobusapp.mobus.dao.GenericDao;
import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public abstract class GenericDaoImpl<T, PK> extends MobusDaoImpl implements GenericDao<T, PK> {

    private static final int LOCK_WAIT_TIMEOUT = 20000;
    private Class<T> clazz = (Class)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    public GenericDaoImpl() {
    }

    public void save(Session session, T entity) {
        session.saveOrUpdate(entity);
    }

    public void delete(Session session, T entity) {
        session.delete(entity);
    }

    public T findById(Session session, PK id) {
        return (T) session.createCriteria(this.clazz).add(Restrictions.eq("id", id)).uniqueResult();
    }

    public List<T> findAll(Session session) {
        Criteria criteria = session.createCriteria(this.clazz);
        return criteria.list();
    }

    public long count(Session session) {
        Criteria criteria = session.createCriteria(this.clazz);
        criteria.setProjection(Projections.rowCount());
        return Long.valueOf(criteria.uniqueResult().toString());
    }

    public List<T> findAll(Session session, Order order) {
        Criteria criteria = session.createCriteria(this.clazz);
        criteria.addOrder(order);
        return criteria.list();
    }

    public void deleteAll(Session session) {
        Query query = session.createQuery("DELETE FROM " + this.clazz.getSimpleName());
        query.executeUpdate();
    }

    public List<T> select(Session session, String hql, Map<String, Object> params, int startRow, int maxResults) {
        StringBuilder hqlBuilder = new StringBuilder();
        hqlBuilder.append(hql);
        Query query = session.createQuery(hqlBuilder.toString());
        this.setQueryParameters(params, query);
        if (startRow > 0) {
            query.setFirstResult(startRow);
        }

        if (maxResults > 0) {
            query.setMaxResults(maxResults);
        }

        return query.list();
    }

    public void lock(Session session, T entity) {
        session.buildLockRequest(LockOptions.UPGRADE).setTimeOut(20000).lock(entity);
    }

    public void flush(Session session) {
        session.flush();
    }

    protected List<T> findByCriteria(Session session, Criterion criterion) {
        Criteria criteria = session.createCriteria(this.clazz);
        if (criterion == null) {
            return null;
        } else {
            criteria.add(criterion);
            return criteria.list();
        }
    }

    protected List<T> selectWithHQL(Session session, String hql, Map<String, Object> params) {
        return this.selectGenericWithHQL(session, hql, params);
    }

    protected List selectGenericWithHQL(Session session, String hql, Map<String, Object> params) {
        Query query = session.createQuery(hql);
        this.setQueryParameters(params, query);
        return query.list();
    }

    protected T selectFirstWithHQL(Session session, String hql, Map<String, Object> params) {
        Query query = session.createQuery(hql);
        this.setQueryParameters(params, query);
        T result = null;
        List<T> resultList = query.list();
        if (resultList != null && !resultList.isEmpty()) {
            result = resultList.get(0);
        }

        return result;
    }

    protected List<T> findByCriteriaWithOrder(Session session, List<Criterion> criterion, Order order) {
        Criteria criteria = session.createCriteria(this.clazz);
        if (criterion == null) {
            return null;
        } else {
            Iterator i$ = criterion.iterator();

            while(i$.hasNext()) {
                Criterion c = (Criterion)i$.next();
                criteria.add(c);
            }

            if (order != null) {
                criteria.addOrder(order);
            }

            return criteria.list();
        }
    }

    protected List<T> findByCriteriaWithOrder(Session session, Criterion criterion, Order order) {
        Criteria criteria = session.createCriteria(this.clazz);
        if (criterion == null) {
            return null;
        } else {
            criteria.add(criterion);
            if (order != null) {
                criteria.addOrder(order);
            }

            return criteria.list();
        }
    }

    protected T findByCriteriaFirstResult(Session session, Criterion criterion) {
        Criteria criteria = session.createCriteria(this.clazz);
        if (criterion == null) {
            return null;
        } else {
            criteria.add(criterion);
            return (T) criteria.uniqueResult();
        }
    }

    private void setQueryParameters(Map<String, Object> params, Query query) {
        if (params != null && !params.isEmpty()) {
            Set<String> str = params.keySet();
            Iterator i$ = str.iterator();

            while(i$.hasNext()) {
                String string = (String)i$.next();
                Object value = params.get(string);
                if (value instanceof Collection) {
                    query.setParameterList(string, (Collection)value);
                } else if (value instanceof Object[]) {
                    query.setParameterList(string, (Object[])((Object[])value));
                } else {
                    query.setParameter(string, value);
                }
            }

        }
    }
}

