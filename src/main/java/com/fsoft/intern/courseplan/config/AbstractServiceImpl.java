package com.fsoft.intern.courseplan.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
@Service
public abstract class AbstractServiceImpl<T extends Serializable> implements AbstractService<T> {

    @Autowired
    private AbstractHibernateDao<T> tAbstractHibernateDao;

    protected final Log log = LogFactory.getLog(getClass());

    @Override
    public T findOne(int id) {
        log.info("getByID Service");
        try {
            log.debug(String.format("getting %s instance with id: %d",
                    getClass(), id));
            T t = tAbstractHibernateDao.findOne(id);
            log.debug("get successful");
            return t;

        } catch (Exception e) {
            log.error("get failed", e);
            throw e;
        }
    }

    @Override
    public List<T> findAll() {
        log.info("get List Service");
        try {
            log.debug(String.format("getting all %s instance ", getClass()));
            List<T> t = tAbstractHibernateDao.findAll();
            log.debug("get Service successful");
            return t;
        } catch (Exception e) {
            log.error("get list Service failed", e);
            throw e;
        }

    }

    @Override
    public void create(T entity) {
        log.info("save");
        try {
            log.debug(String.format("persisting %s instance", getClass()));
            tAbstractHibernateDao.create(entity);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }

    }

    @Override
    public void update(T entity) {
        log.info("update Service");
        try {
            log.debug(String.format("updating %s instance", getClass()));
            tAbstractHibernateDao.update(entity);
            log.debug("update successful");
        } catch (RuntimeException e) {
            log.error("udpate failed", e);
            throw e;
        }

    }

    @Override
    public void delete(T entity) {

        log.info("delete Service");
        try {
            log.debug(String.format("removing %s instance", getClass()));
            tAbstractHibernateDao.delete(entity);
            log.debug("remove successful");
        } catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }

    @Override
    public void deleteById(int entityId) {
        log.info("deleteById Service");
        try {
            tAbstractHibernateDao.deleteById(entityId);
        } catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }

    }
}
