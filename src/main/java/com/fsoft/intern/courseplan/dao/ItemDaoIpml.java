package com.fsoft.intern.courseplan.dao;

import com.fsoft.intern.courseplan.config.AbstractHibernateDao;
import com.fsoft.intern.courseplan.entity.DATA_TYPE;
import com.fsoft.intern.courseplan.entity.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository(value = "ItemDAO")
@Transactional(rollbackFor = Exception.class)
public class ItemDaoIpml extends AbstractHibernateDao<Item> implements ItemDao {


    @Autowired
    SessionFactory sessionFactory;

    /*function getItemById get list Item with id
     * connect database
     * query select hsql hibernate
     * show Item
     * param @id
     * @return list item
     */
    @Override
    public List<Item> getItemById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Item where id_course=" + id).getResultList();
    }

    /*function getItemById get list Item
     * connect database
     * query select hsql hibernate
     * show Item
     * param @id,@data_type
     * @return list item
     */
    @Override
    public List<Item> getItemById(int id, DATA_TYPE data_type) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Item where id_course=" + id + " and data_type = '" + data_type + "'").getResultList();
    }

    /*function getItemById get one Item with id
     * connect database
     * query select hsql hibernate
     * show Item
     * param @id,@data_type
     * @return list item
     */
    public Item getItemByIdItem(int id, DATA_TYPE data_type) {
        Item item = (Item) sessionFactory
                .getCurrentSession()
                .createQuery("from Item where id_item=" + id + " and data_type = '" + data_type + "'").uniqueResult();
        return item;
    }

    /*function getByItem get one Item with name
     * connect database
     * query select hsql hibernate
     * show course with Item
     * param @name
     * @return one item
     */
    public Item getByItem(String name) {
        try {
            Item item = (Item) sessionFactory
                    .getCurrentSession()
                    .createQuery("from Item where name='" + name + "'").uniqueResult();
            return item;
        } catch (Exception e) {
            throw e;
        }

    }

    /*function ItemExists check Item
     * connect database
     * query select hsql hibernate
     * show course with CourseCode
     * param @name
     * @return boolean
     */
    public boolean ItemExists(String name) {
        try {
            Query q = sessionFactory
                    .getCurrentSession()
                    .createQuery("from Item where name='" + name + "'");
            if (q.getResultList().size() > 0)
                return true;
            return false;
        } catch (Exception e) {
            throw e;
        }
    }
    /*function ItemExists in Risk/Issues check Item
     * connect database
     * query select hsql hibernate
     * show course with CourseCode
     * param id, data_type
     * @return list
     */
    public List<Item> getByRiskCode(int id, DATA_TYPE data_type) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Item where id_course=" + id + " and data_type='" + data_type + "'").getResultList();
    }
}
