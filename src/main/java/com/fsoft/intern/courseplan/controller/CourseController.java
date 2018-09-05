package com.fsoft.intern.courseplan.controller;

import com.fsoft.intern.courseplan.ApiResponseBuider;
import com.fsoft.intern.courseplan.config.AbstractHibernateDao;
import com.fsoft.intern.courseplan.config.Mapper;
import com.fsoft.intern.courseplan.dao.CourseDaoImpl;
import com.fsoft.intern.courseplan.entity.Course;
import com.fsoft.intern.courseplan.entity.Item;
import com.fsoft.intern.courseplan.model.CourseDTO;
import com.fsoft.intern.courseplan.model.TimeFrameDTO;
import com.fsoft.intern.courseplan.service.*;
import com.fsoft.intern.courseplan.service.CourseServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CourseController {
    @Autowired
    private CourseServiceImpl courseService;

    ApiResponseBuider apiResponseBuider;

    private static final Log log = LogFactory.getLog(CourseController.class);
    /**function getCourseList get list course show list in page manager course
     * @return json list corse
     */
    @GetMapping("/course")
    public Map<String, Object> getCourseList() {
        log.info(String.format("getCourseList in class %s", getClass()));
        try {
            log.debug("getting list of all course and return json");
            Map<String, Object> result = new HashMap<String, Object>();
            // show data
            List<Course> ls = courseService.findAll();
            log.debug("getCourseList successful");
            return apiResponseBuider.buildContainsData("get list ok",ls);
        } catch (Exception e) {
            log.error(String.format(
                    "getCourseList in class %s has error: %s", getClass(),
                    e.getMessage()));
            throw e;
        }

    }
    /*function  createCourse creat new course in page courseplan
     * check course exists
     * save course in database
     * @Param CourseDTO
     * @return json new corse
     */
    @PostMapping("/course")
    public Map<String, Object> createCourse(@RequestBody CourseDTO courseDTO) {
        log.info(String
                .format("createCourse with param 'course' in class: %s",
                        getClass()));
        try {
            log.debug("add 1 course and return json format");
            Map<String, Object> result = new HashMap<String, Object>();
            if (!courseService.CoursExists(courseDTO.getCourseCode())) {
                courseService.create(Mapper.mapToCourse(courseDTO));
                return apiResponseBuider.buildSuccess("ok", courseService.getByCourseCode(courseDTO.getCourseCode()));
            } else {
                result.put("status", "fail");
                return result;
            }
        } catch (Exception e) {
            log.error(String
                    .format("createCourse with param 'course' in class %s has error: %s",
                            getClass(), e.getMessage()));
            throw e;
        }

    }
    /* function deleteCourse Delete course with id course in manager course
     * find course exists
     * delete course in database
     * param @id
     * @return json list course
     */
    @DeleteMapping("/course/{id}")
    public Map<String, Object> deleteCourse(@PathVariable("id") int id) {
        log.info(String.format("deletecourseList in class %s", getClass()));
        try {
            Map<String, Object> result = new HashMap<String, Object>();
            if (courseService.findOne(id) != null) {
                courseService.deleteById(id);
                // show data
                List<Course> ls = courseService.findAll();
                return apiResponseBuider.buildSuccess("ok",ls);
            } else {
                result.put("status", "fail");
                return result;
            }
        } catch (Exception e) {
            log.error(String.format(
                    "deleteCourse in class %s has error: %s", getClass(),
                    e.getMessage()));
            throw e;
        }

    }
    /*function updateCourse update course in manager course
     * check course exists
     * update course in database
     * param @id,@course
     * @return json edited course
     */
    @PutMapping("/course/{id}")
    public Map<String, Object> updateCourse(@PathVariable("id") int id, @RequestBody CourseDTO courseDTO) {
        try {
            log.info(String.format("updateCourse in class %s", getClass()));
            //check course exists
            Course currentCourse = courseService.findOne(id);
            log.info("find ok");
            if (currentCourse != null) {
                if(!courseService.CoursExists(courseDTO.getCourseCode()))
                {
                    courseService.update(Mapper.mapToCourse(courseDTO));
                    // show data
                    Course data = courseService.findOne(id);
                    log.debug("Update Course Success");
                    return ApiResponseBuider.buildSuccess("Update Course Success", data);
                }
            }
            return ApiResponseBuider.buildError("Update Course Fail");
        }
        catch (Exception e)
        {
            log.error(String.format(
                    "updateCourse in class %s has error: %s", getClass(),
                    e.getMessage()));
            throw e;
        }
    }
}
