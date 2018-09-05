package com.fsoft.intern.courseplan.controller;

import com.fsoft.intern.courseplan.ApiResponseBuider;
import com.fsoft.intern.courseplan.model.TimeFrameDTO;
import com.fsoft.intern.courseplan.service.TimeFrameServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TimeFrameController {

    @Autowired
    TimeFrameServiceImpl timeFrameService;

    private static final Log log = LogFactory.getLog(TimeFrameController.class);
    /**function getAllTimeFrameCourse get list TimeFrame show TimeFrame in course with id
     * @return json list corse
     */
    @GetMapping("/course/{id}/timeframe")
    public Map<String, Object> getAllTimeFrameCourse(@PathVariable int id) {
        log.info(String.format("getCourseList in class %s", getClass()));
        try {
            List<TimeFrameDTO> timeFrameDTOS = timeFrameService.getTimeFrameById(id);
            log.debug("get List TimeFrame OK");
            return ApiResponseBuider.buildContainsData("List TimeFrame Success", timeFrameDTOS);
        } catch (Exception e) {
            log.error(String.format(
                    "get List TimeFrame in class %s has error: %s", getClass(),
                    e.getMessage()));
            throw e;
        }
    }
    /*function  insertTimeFrame insert  TimeFrame in course
     * check course exists
     * check TimeFrame exists
     * save TimeFrame in database
     * @Param TimeFrameDTO
     * @return json new TimeFrame
     */
    @PostMapping("/course/{id}/timeframe")
    public Map<String, Object> insertTimeFrame(@PathVariable int id, @RequestBody TimeFrameDTO timeFrameDTO) {
        log.info(String.format("create TimeFrame in class %s", getClass()));
        try {
            if (timeFrameService.insertTimeFrame(id, timeFrameDTO)) {
                log.debug("create TimeFrame Success");
                return ApiResponseBuider.buildSuccess("Insert TimeFrame Success", timeFrameService.getByItem(timeFrameDTO.getName()));
            }
            return ApiResponseBuider.buildError("Miletone Trung nhau");
        } catch (Exception e) {
            log.error(String.format(
                    "create TimeFrame in class %s has error: %s", getClass(),
                    e.getMessage()));
            throw e;
        }
    }
    /*function updateTimeFrame update course in manager course
     * check TimeFrame exists
     * update TimeFrame in database
     * param @id,@timeFrameDTO
     * @return json edited timeFrame
     */
    @PutMapping("/course/{id}/timeframe/{idtimeframe}")
    public Map<String, Object> updateTimeFrame(@PathVariable("idtimeframe") int id, @RequestBody TimeFrameDTO timeFrameDTO) {
        log.info(String.format("update Course in class %s", getClass()));
        try {
            System.out.println(timeFrameDTO.getDescription());
            if (timeFrameService.updateTimeFrame(id, timeFrameDTO)) {
                log.debug("update TimeFrame Success");
                System.out.println("id" + id);
                System.out.println(timeFrameService.getItemByIdItem(id));
                return ApiResponseBuider.buildSuccess("Update TimeFrame Success", timeFrameService.getItemByIdItem(id));
            } else {
                return ApiResponseBuider.buildError("Update TimeFrame Fail");
            }

        } catch (Exception e) {
            log.error(String.format(
                    "update TimeFrame in class %s has error: %s", getClass(),
                    e.getMessage()));
            throw e;
        }
    }
    /* function deleteTimeFrame Delete course with id course
     * find TimeFrame exists
     * delete course in database
     * param @id
     * @return json list course
     */
    @DeleteMapping("/course/{id}/timeframe/{idtimeframe}")
    public Map<String, Object> deleteTimeFrame(@PathVariable("idtimeframe") int id) {
        try {
            if (timeFrameService.deleteTimeFrame(id)) {
                return ApiResponseBuider.buildSuccess("Delete TimeFrame Success");
            } else {
                return ApiResponseBuider.buildError("Delete TimeFrame Fail");
            }
        } catch (Exception e) {
            log.error(String.format(
                    "delete TimeFrame in class %s has error: %s", getClass(),
                    e.getMessage()));
            throw e;
        }

    }


}
