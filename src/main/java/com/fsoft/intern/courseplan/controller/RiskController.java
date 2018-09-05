package com.fsoft.intern.courseplan.controller;

import com.fsoft.intern.courseplan.ApiResponseBuider;
import com.fsoft.intern.courseplan.model.RiskDTO;
import com.fsoft.intern.courseplan.service.RiskServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class RiskController {
    private static final Log log = LogFactory.getLog(RiskController.class);
    /**
     * Validator for riskService
     */
    @Autowired
    RiskServiceImpl riskService;
    /**
     * This method is used to get all risk/issues in database and
     * return a list risk/issues in json format
     *
     * @return Map<String, Object>
     */
    @GetMapping("/course/{id}/risk")
    public Map<String, Object> getAllRisk(@PathVariable int id) {
        log.info(String.format("getAllRisk in class: %s", getClass()));
        try {
            log.debug("return ApiResponseBuider for request");
            log.debug("getAllRisk successfully");
            return ApiResponseBuider.buildContainsData("show all Risk/Issues", riskService.getRiskById(id));
        } catch (Exception e) {
            log.error(String.format("getAllRisk in class %s has error: %s", getClass(), e.getMessage()));
            throw e;
        }
    }
    /**
     * This method is used to add one risk/issues
     * @param id
     * @return Map<String, Object>
     */
    @PostMapping("/course/{id}/risk")
    public Map<String, Object> insertRisk(@PathVariable int id, @RequestBody RiskDTO riskDTO) {
        log.info(String.format("insertRisk in class: %s", getClass()));
        try {
            log.debug("return ApiResponseBuider for request");
            log.debug("insertRisk successfully");
            riskService.addRisk(id, riskDTO);
            return ApiResponseBuider.buildSuccess( "add Risk/Issues success",riskService.getRiskById(riskDTO.getCourseId()));
        } catch (Exception e) {
            log.error(String.format("insertRisk with param 'id' in class %s has error: %s", getClass(), e.getMessage()));
            throw e;
        }
    }
    /**
     * This method is used to update one risk/issues in database
     * @param id
     * @return Map<String, Object>
     */
    @PutMapping("/course/{id}/risk/{idrisk}")
    public Map<String, Object> updateRisk(@PathVariable("idrisk") int id, @RequestBody RiskDTO riskDTO) {
        log.info(String.format("updateRisk in class: %s", getClass()));
        try {
            log.debug("return ApiResponseBuider for request");
            log.debug("updateRisk successfully");
            riskService.updateRisk(id, riskDTO);
            return ApiResponseBuider.buildSuccess("update Risk/Issues success");
        } catch (Exception e) {
            log.error(String.format("updateRisk with param 'id' in class %s has error: %s", getClass(), e.getMessage()));
            throw e;
        }
    }
    /**
     * This method is used to delete one risk/issues in database
     *
     * @return Map<String, Object>
     */
    @DeleteMapping("/course/{id}/risk/{idrisk}")
    public Map<String, Object> deleteRisk(@PathVariable("idrisk") int id) {
        log.info(String.format("deleteRisk in class: %s", getClass()));
        try {
            log.debug("return ApiResponseBuider for request");
            log.debug("deleteRisk successfully");
            riskService.deleteRisk(id);
            return ApiResponseBuider.buildSuccess("deleted Risk/Issues");
        } catch (Exception e) {
            log.error(String.format("updateRisk with param 'id' in class %s has error: %s", getClass(), e.getMessage()));
            throw e;
        }
    }
}
