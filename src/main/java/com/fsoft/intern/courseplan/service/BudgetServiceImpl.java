package com.fsoft.intern.courseplan.service;

import com.fsoft.intern.courseplan.ApiResponseBuider;
import com.fsoft.intern.courseplan.config.Mapper;
import com.fsoft.intern.courseplan.dao.ItemDaoIpml;
import com.fsoft.intern.courseplan.entity.Course;
import com.fsoft.intern.courseplan.entity.DATA_TYPE;
import com.fsoft.intern.courseplan.entity.Item;
import com.fsoft.intern.courseplan.model.BudgetDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
@Service
@Transactional
public class BudgetServiceImpl {

	ApiResponseBuider apiResponseBuider;
	private static final Log log = LogFactory.getLog(BudgetServiceImpl.class);
    @Autowired
    private ItemDaoIpml budgetDao;

    @Autowired
    private CourseServiceImpl courseService;
    
    /* Show list  Budget by ID
     * @param id
     * return list budget
     */
    public List<BudgetDTO> getBudgetById(int id) {
    	log.info(String.format("mapBudget in class: %s", getClass()));
    	try {
    		log.debug("return list budget for request");
			log.debug("getBudgetById successfully");
			return budgetDao.getItemById(id, DATA_TYPE.BUDGET).stream().map(Mapper::mapBudget).collect(Collectors.toList());
    	} catch (Exception e) {
    		log.error(String.format("getBudgetById with para 'id' in class %s has error: %s", getClass(), e.getMessage()));
			throw e;
    	}
    }

    //Add new Budget @param courseId, budget
    public Map<String,Object> addBudget(int courseId, BudgetDTO budgetDTO) {
		Course course = courseService.findOne(courseId);
		try {
			if (course != null){
			if (!budgetDao.ItemExists(budgetDTO.getName())) {
				Item item = Mapper.mapToItem(budgetDTO);
				item.setCourse(course);
				budgetDao.create(item);
				return apiResponseBuider.buildSuccess("Add Budget Successfully!");
			}}
			return apiResponseBuider.buildError("Add Budget Failed!");
		} catch (Exception e) {
			log.error(String.format("addBudget with para 'courseId' in class %s has error: %s", getClass(), e.getMessage()));
			throw e;
		}
	}
    
  //Update Budget @param courseId, budget
    public Map<String,Object> updateBudget(int budgetId, BudgetDTO budgetDTO){
    	try {
    		Item item = budgetDao.findOne(budgetId);
            if(item != null) {
				item.setValue(budgetDTO.getValue());
				item.setName(budgetDTO.getName());
				item.setDescription(budgetDTO.getDescription());
				budgetDao.update(item);
				return apiResponseBuider.buildSuccess("Update Budget Successfully!");
			}
            return apiResponseBuider.buildError("Update Budget Failed!");
    	} catch (Exception e) {
    		log.error(String.format("updateBudget with para 'courseId' in class %s has error: %s", getClass(), e.getMessage()));
			throw e;
		}
    }
    
  //Delete  Budget @param budgetId
    public void deleteBudget(int budgetId){
    	try {
    		Item item = budgetDao.findOne(budgetId);
            if(item.getDataType().toString().equals("BUDGET")) {
                budgetDao.deleteById(budgetId);
            }
    	} catch (Exception e) {
    		log.error(String.format("deleteBudget with para 'budgetId' in class %s has error: %s", getClass(), e.getMessage()));
			throw e;
    	}
    }

	public Item getByItem(String name)
	{
		try {
			Item item = budgetDao.getByItem(name);
			return item;
		}
		catch (Exception e)
		{
			throw  e;
		}
	}
}
