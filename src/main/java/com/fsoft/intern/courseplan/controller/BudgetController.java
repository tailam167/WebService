package com.fsoft.intern.courseplan.controller;

import com.fsoft.intern.courseplan.ApiResponseBuider;
import com.fsoft.intern.courseplan.model.BudgetDTO;
import com.fsoft.intern.courseplan.service.BudgetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;
import java.util.Map;

@RestController
public class BudgetController {

    @Autowired
    BudgetServiceImpl budgetService;
    ApiResponseBuider apiResponseBuider;
    private static final Log log = LogFactory.getLog(BudgetController.class);
    /*API get budget
     * return apiResponseBuider
     */
    @GetMapping("/course/{id}/budget")
    public Map<String,Object> getAllBudgetCourse(@PathVariable int id) {
    	log.info(String.format("getAllBudgetCourse in class: %s", getClass()));
    	try {
    		log.debug("return apiResponseBuider for request");
			log.debug("getAllBudgetCourse successfully");
    		return apiResponseBuider.buildContainsData("Get Budget Successfully!", budgetService.getBudgetById(id));
    	} catch (Exception e) {
    		log.error(String.format("getAllBudgetCourse in class %s has error: %s", getClass(), e.getMessage()));
			throw e;
    	}
        
    }

    /*API add new budget
     * @param budget
     * return apiResponseBuider
     */
    @PostMapping("/course/{id}/budget")
    public Map<String,Object> insertBudget(@PathVariable int id, @RequestBody BudgetDTO budgetDTO) {
    	log.info(String.format("insertBudget with param 'budget' in class: %s", getClass()));
        try {
        	log.debug("return apiResponseBuider for request");
			log.debug("insertBudget successfully");
        	budgetService.addBudget(id, budgetDTO);
            return apiResponseBuider.buildSuccess("Insert Budget Successfully!", budgetService.getByItem(budgetDTO.getName()));
        } catch (Exception e) {
        	log.error(String.format("insertBudget with param 'budget' in class %s has error: %s", getClass(), e.getMessage()));
			throw e;
        }
    }

    /*API update budget
     * @param idbudget
     * return apiResponseBuider
     */
    @PutMapping("/course/{id}/budget/{idbudget}")
    public Map<String,Object> updateBudget(@PathVariable("idbudget") int id, @RequestBody BudgetDTO budgetDTO) {
    	log.info(String.format("updateBudget with param 'idbudget' in class: %s", getClass()));
        try {
        	log.debug("return apiResponseBuider for request");
			log.debug("updateBudget successfully");
        	budgetService.updateBudget(id, budgetDTO);
            return apiResponseBuider.buildSuccess("Update Budget Successfully!", budgetService.getByItem(budgetDTO.getName()));
        } catch (Exception e) {
        	log.error(String.format("updateBudget with param 'idbudget' in class %s has error: %s", getClass(), e.getMessage()));
			throw e;
        }
    	
    }
    
    /*API delete budget
     * @param idbudget
     * return apiResponseBuider
     */
    @DeleteMapping("/course/{id}/budget/{idbudget}")
    public Map<String,Object> deleteBudget(@PathVariable("idbudget") int id) {
    	log.info(String.format("deleteBudget with param 'idbudget' in class: %s", getClass()));
        try {
        	log.debug("return apiResponseBuider for request");
			log.debug("deleteBudget successfully");
        	budgetService.deleteBudget(id);
            return apiResponseBuider.buildSuccess("Delete Budget Successfully!");	
        } catch (Exception e) {
        	log.error(String.format("deleteBudget with param 'idbudget' in class %s has error: %s", getClass(), e.getMessage()));
			throw e;
        }
    }


}