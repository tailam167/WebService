package com.fsoft.intern.courseplan.config;

import com.fsoft.intern.courseplan.controller.BudgetController;
import com.fsoft.intern.courseplan.entity.Course;
import com.fsoft.intern.courseplan.entity.DATA_TYPE;
import com.fsoft.intern.courseplan.entity.Item;
import com.fsoft.intern.courseplan.model.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader;

public class Mapper {

	private static final Log log = LogFactory.getLog(Mapper.class);
	
    public static HumanResourceDTO mapHumanResource(Item item) {
        return new HumanResourceDTO(item.getCourse().getIdCourse(), item.getName(), item.getValue(), item.getDescription());
    }

    public static Item mapToItem(HumanResourceDTO humanResourceDTO) {
        Item item = new Item();
        item.setDataType(DATA_TYPE.HUMANRESOURSE);
        item.setName(humanResourceDTO.getName());
        item.setValue(humanResourceDTO.getRole());
        item.setDescription(humanResourceDTO.getDescription());
        return item;
    }

    public static CourseDTO mapCourse(Course course) {
        CourseDTO courseDTO = new CourseDTO(course.getIdCourse(), course.getCourseName(),
                course.getCourseCode(), course.getProgramCustomization(), course.getTargetAudience(),
                course.getNoOfParticipant());

        courseDTO.setIdCourse(course.getIdCourse());
        return courseDTO;
    }

    public static TimeFrameDTO mapTimeFrame(Item item) {
        return new TimeFrameDTO(item.getName(), item.getDate(), item.getCourse().getIdCourse(), item.getDescription());
    }

    public static LogisticDTO mapLogistic(Item item) {
        return new LogisticDTO(item.getCourse().getIdCourse(), item.getValue(), item.getName() , item.getDescription());
    }

    public static Review_ApproveDTO mapReview_Approve(Item item){
        return new Review_ApproveDTO(item.getName(), item.getDate(), item.getDescription(), item.getValue(), item.getCourse().getIdCourse());
    }

//    public static Course mapToCourse(CourseDTO courseDTO) {
//        Course course = new Course(courseDTO.getCourseName(),
//                courseDTO.getCourseCode(), courseDTO.getProgramCustomization(), courseDTO.getTargetAudience(),
//                courseDTO.getNoOfParticipant());
//        course.setIdCourse(courseDTO.getIdCourse());
//        return course;
//    }
    
    //Map budget from item to model
    public static BudgetDTO mapBudget(Item item) {
    	log.info(String.format("mapBudget in class: %s", Mapper.class));
    	try {
    		log.debug("return BudgetDTO for request");
			log.debug("mapBudget successfully");
			return new BudgetDTO(item.getName(), item.getDate(), item.getCourse().getIdCourse(), item.getDescription());
    	} catch (Exception e) {
    		log.error(String.format("mapBudget in class %s has error: %s", Mapper.class, e.getMessage()));
			throw e;
    	}
    }

    public static Item mapToItem(TimeFrameDTO timeFrameDTO) {
        Item item = new Item();
        item.setDataType(DATA_TYPE.TIMEFRAMES);
        item.setName(timeFrameDTO.getName());
        item.setDescription(timeFrameDTO.getDescription());
        item.setDate(timeFrameDTO.getDate());
        return item;
    }

    public static RiskDTO mapRisk (Item item) {
        log.info(String.format("mapriskDTO in class: %s", Mapper.class));
        try {
            log.debug("return RiskDTO for request");
            log.debug("mapRisk successfully");
            return new RiskDTO(item.getName(), item.getDate(), item.getDescription(), item.getValue(), item.getIdItem());
        } catch (Exception e) {
            log.error(String.format("mapBudget in class %s has error: %s", Mapper.class, e.getMessage()));
            throw e;
        }
    }

    public static Item mapriskDTO(RiskDTO mapriskDTO) {
        log.info(String.format("mapriskDTO in class: %s", Mapper.class));
        try {
            log.debug("return item for request");
            log.debug("mapriskDTO successfully");
            Item item =  new Item();
            item.setDataType(DATA_TYPE.RISKISSUE);
            item.setName(mapriskDTO.getName());
            item.setDate(mapriskDTO.getStatus());
            item.setDescription(mapriskDTO.getDescription());
            item.setValue(mapriskDTO.getSolution());
            return item;
        } catch (Exception e) {
            log.error(String.format("mapriskDTO in class %s has error: %s", Mapper.class, e.getMessage()));
            throw e;
        }
    }
    
    //Map budget from model to item
    public static Item mapToItem(BudgetDTO budgetDTO) {
    	log.info(String.format("mapToItem in class: %s", Mapper.class));
    	try {
    		log.debug("return item for request");
			log.debug("mapToItem successfully");
			Item item =  new Item();
	        item.setDataType(DATA_TYPE.BUDGET);
	        item.setName(budgetDTO.getName());
	        item.setDescription(budgetDTO.getDescription());
	        item.setValue(budgetDTO.getValue());
	        return item;
    	} catch (Exception e) {
    		log.error(String.format("mapToItem in class %s has error: %s", Mapper.class, e.getMessage()));
			throw e;
    	}
    }
    public static Item mapToLogistic(LogisticDTO logisticDTO) {
        Item item =  new Item();
        item.setDataType(DATA_TYPE.LOGISTIC);
        item.setName(logisticDTO.getName());
        item.setValue(logisticDTO.getValue());
        item.setDescription(logisticDTO.getDescription());
        return item;
    }

    public static Item mapToReview_Approve(Review_ApproveDTO review_approveDTO){
        Item item = new Item();
        item.setDataType(DATA_TYPE.REVIEWAPPROVE);
        item.setName(review_approveDTO.getName());
        item.setDate(review_approveDTO.getDate());
        item.setDescription(review_approveDTO.getDescription());
        item.setValue(review_approveDTO.getValue());
        return item;
    }
    public static Course mapToCourse(CourseDTO CourseDTO){
        Course course = new Course();
        course.setIdCourse(CourseDTO.getIdCourse());
        course.setCourseCode(CourseDTO.getCourseCode());
        course.setCourseName(CourseDTO.getCourseName());
        course.setNoOfParticipant(CourseDTO.getNoOfParticipant());
        course.setProgramCustomization(CourseDTO.getProgramCustomization());
        course.setTargetAudience(CourseDTO.getTargetAudience());
        return course;
    }

}
