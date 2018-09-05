package com.fsoft.intern.courseplan.dao;

import com.fsoft.intern.courseplan.config.AbstractHibernateDao;
import com.fsoft.intern.courseplan.entity.Course;
import com.fsoft.intern.courseplan.model.CourseDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository(value = "courseDAO")
@Transactional(rollbackFor = Exception.class)
public class CourseDaoImpl extends AbstractHibernateDao<Course> implements Serializable {

    @Autowired
    SessionFactory sessionFactory;
    /*function CoursExists check CoursExists of course
     * connect database
     * query select hsql hibernate
     * show course with CourseCode
     * param @CourseCode
     * @return boolean
     */
    public boolean CoursExists(String CourseCode) {
        try {
            Query q = sessionFactory
                    .getCurrentSession()
                    .createQuery("from Course where course_code='"+CourseCode+"'" );
            if (q.getResultList().size()>0)
                return true;
            return false;
        }
        catch (Exception e)
        {
            throw  e;
        }
    }
    /*function getByCourseCode get one course with CourseCode
     * connect database
     * query select hsql hibernate
     * show course with CourseCode
     * param @CourseCode
     * @return boolean
     */
    public Course getByCourseCode(String CourseCode)
    {
        try {
            Course course = (Course) sessionFactory
                    .getCurrentSession()
                    .createQuery("from Course where course_code='" + CourseCode + "'").uniqueResult();
            return course;
        }
        catch (Exception e)
        {
            throw  e;
        }

    }
}
