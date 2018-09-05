package com.fsoft.intern.courseplan.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

@Transactional
@SuppressWarnings("unchecked")
@Repository
public abstract class AbstractHibernateDao<T extends Serializable> {

    private Class<T> clazz;

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    SessionFactory sessionFactory;

    public AbstractHibernateDao() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class) pt.getActualTypeArguments()[0];
    }

    protected Class<? extends T> daoType;

    public final void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }
    //get Session Hibernate
    protected Session getSession() {
        logger.info("getSession");
        try {
            return sessionFactory.getCurrentSession();
        } catch (Exception e) {
            logger.fatal("System Error:" + e);
            throw e;
        }
    }

    public T findOne(int id) {
        logger.info("getByID Dao");
        try {
            return (T) getSession().get(daoType.getName(), id);
        } catch (RuntimeException e) {
            logger.error("get list failed", e);
            throw e;
        }
    }


    public List<T> findAll() {
        logger.info("get List Dao");
        try {
            logger.debug(String.format("getting all %s T ", getClass()));
            List<T> t = getSession().createQuery("from " + daoType.getName()).list();
            logger.debug("get list Dao successful");
            return t;
        } catch (RuntimeException re) {
            logger.error("get list Dao failed");
            throw re;
        }

    }

    public void create(T entity) {
        logger.info("save Dao");
        try {
            logger.debug(String.format("persisting %s T", getClass()));
            getSession().persist(entity);
            logger.debug("persist successful");
        } catch (RuntimeException e) {
            logger.error("persist failed");
            throw e;
        }
    }

    public void update(T entity) {
        logger.info("update Dao");
        try {
            logger.debug(String.format("updating %s T", getClass()));
            getSession().merge(entity);
            logger.debug("update successful");
        } catch (RuntimeException e) {
            logger.error("update failed");
            throw e;
        }

    }

    public void delete(T entity) {
        logger.info("delete Dao");
        try {

            getSession().delete(entity);
            logger.debug("delete  successful");
        } catch (RuntimeException e) {
            logger.error("delete failed");
            throw e;
        }

    }

    public void deleteById(int entityId) {
        logger.info("deleteByID Dao");
        try {
            T entity = findOne(entityId);
            if (entity != null) {
                logger.info(getClass() + " given by id:" + entityId + "did not found");
                delete(entity);
            }
        } catch (RuntimeException e) {
            logger.error("remove by id failed", e);
            throw e;
        }
    }

}
