package com.fsoft.intern.courseplan.service;

import com.fsoft.intern.courseplan.config.AbstractServiceImpl;
import com.fsoft.intern.courseplan.dao.CourseDaoImpl;
import com.fsoft.intern.courseplan.entity.Course;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CourseServiceImpl extends AbstractServiceImpl<Course> {
    @Autowired
    CourseDaoImpl courseDao;
    protected final Log logger = LogFactory.getLog(CourseServiceImpl.class);
    /*function CoursExists check CoursExists of course
     * extend CourseDaoImpl
     * param @CourseCode
     * @return boolean
     */
    public boolean CoursExists(String CourseCode) {
        logger.info("Kiem Tra ton tai");
        try {
            if (courseDao.CoursExists(CourseCode)) {
                logger.debug("exists");
                return true;
            }
            logger.debug("no exists");
            return false;
        } catch (Exception e) {
            logger.error("kiem tra fail with CourseCode " + CourseCode);
            throw e;
        }
    }
    /*function getByCourseCode get one course with CourseCode
     * extend CourseDaoImpl
     * param @CourseCode
     * @return boolean
     */
    public Course getByCourseCode(String CourseCode) {
        logger.info("getByCourseCode Service");
        try {
            Course c = new Course();
            c = courseDao.getByCourseCode(CourseCode);
            logger.debug("success");
            return c;
        } catch (Exception e) {
            logger.error("getByCourseCode error wich CourseCode: " + CourseCode);
            throw e;
        }

    }
}
