package com.fsoft.intern.courseplan.controller;


import com.fsoft.intern.courseplan.ApiResponseBuider;
import com.fsoft.intern.courseplan.model.LogisticDTO;
import com.fsoft.intern.courseplan.service.LogisticServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@RestController
public class LogisticController {
    // Call class LogisticServiceImpl to use function in method
    @Autowired
    LogisticServiceImpl logisticService;
    //Call class ApiResponseBuider to use function in method
    ApiResponseBuider apiResponseBuider;
    private static final Log log = LogFactory.getLog( LogisticController.class.getName() );

    /*API get logistic
     * return apiResponseBuider
     */
    @GetMapping("/course/{id}/logistic")
    public Map<String, Object> getAllLogisticCourse(@PathVariable int id) {
        log.info(String.format("getAllLogisticCourse in class: %s", getClass()));
        try {
            //export log if get data success when debug project
            log.debug("return apiResponseBuider for request");
            log.debug("getAllLogisticCourse successfully");
            //return on API with message "Get Logistic Successfully" if get data success
            return apiResponseBuider.buildContainsData("Get Logistic Successfully", logisticService.getLogisticById(id));
        }catch (Exception e){
            //export log with message error if get data fail
            log.error(String.format("getAllLogisticCourse in class %s has error: %s", getClass(), e.getMessage()));
            throw e;
        }
    }


    /*API add new logistic
     * @param logistic
     * return apiResponseBuider
     */
    @PostMapping("/course/{id}/logistic")
    public Map<String, Object> insertLogistic(@PathVariable int id, @RequestBody LogisticDTO logisticDTO) {
        log.info(String.format("insertLogistic with param 'logistic' in class: %s", getClass()));
        try{
            //export log if insert data success when debug project
            log.debug("return apiResponseBuider for request");
            log.debug("insertLogistic successfully");
            //insert data into database
            logisticService.addLogistic(id, logisticDTO);
            //return on API with message "Insert Logistic Successfully" if insert data success
            return apiResponseBuider.buildSuccess("Insert Logistic Successfully");
        }catch (Exception e){
            //export log with message error if insert data fail
            log.error(String.format("insertLogistic with param 'logistic' in class %s has error: %s", getClass(), e.getMessage()));
            throw e;
        }
    }

    /*API update logistic
     * @param idlogistic
     * return apiResponseBuider
     */
    @PutMapping("/course/{id}/logistic/{idlogistic}")
    public Map<String, Object> updateLogistic(@PathVariable("idlogistic") int id, @RequestBody LogisticDTO logisticDTO) {
        log.info(String.format("updateLogistic with param 'idlogistic' in class: %s", getClass()));
        try{
            //export log if update data success when debug project
            log.debug("return apiResponseBuider for request");
            log.debug("updateLogistic successfully");
            //update data base on param idlogistic
            logisticService.updateLogistic(id, logisticDTO);
            //return on API with message "Update Logistic Successfully" if update data success
            return apiResponseBuider.buildSuccess("Update Logistic Successfully");
        }catch (Exception e){
            //export log with message error if update data fail
            log.error(String.format("updateLogistic with param 'idlogistic' in class %s has error: %s", getClass(), e.getMessage()));
            throw e;
        }
    }

    /*API delete logistic
     * @param idlogistic
     * return apiResponseBuider
     */
    @DeleteMapping("/course/{id}/logistic/{idlogistic}")
    public Map<String, Object> deleteLogistic(@PathVariable("idlogistic") int id) {
        log.info(String.format("deleteLogistic with param 'idlogistic' in class: %s", getClass()));
        try{
            //export log if insert data success when debug project
            log.debug("return apiResponseBuider for request");
            log.debug("deleteLogistic successfully");
            //delete data base on param idlogistic
            logisticService.deleteLogistic(id);
            //return on API with message "Delete Logistic Successfully" if delete data success
            return apiResponseBuider.buildSuccess("Delete Logistic Successfully");
        }catch (Exception e){
            //export log with message error if delete data fail
            log.error(String.format("deleteLogistic with param 'idlogistic' in class %s has error: %s", getClass(), e.getMessage()));
            throw e;
        }

    }

}
