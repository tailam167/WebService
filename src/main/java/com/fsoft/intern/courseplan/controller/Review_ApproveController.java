package com.fsoft.intern.courseplan.controller;

import com.fsoft.intern.courseplan.ApiResponseBuider;
import com.fsoft.intern.courseplan.model.Review_ApproveDTO;
import com.fsoft.intern.courseplan.service.Review_ApproveServiceImpl;
import org.hibernate.internal.CoreLogging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@RestController
public class Review_ApproveController {
    private final Logger log = LoggerFactory.getLogger(Review_ApproveController.class);
    // Create a variable about Review_ApproveServiceImpl
    @Autowired
    Review_ApproveServiceImpl review_approveService;
    ApiResponseBuider apiResponseBuider;
    // Url of this method

    // this method  is select  data in database with a id.
    // input is a id or  nothing
    /* output :True : if id is determined -> select an item with that id ( if dont has id , display all item in database)
                False: export a log is Message is Error at Param :
*/
    @GetMapping("/course/{id}/review_approve")
    public Map<String, Object> getAllReview_ApproveCourse(@PathVariable int id) {
        //show log info of  function getAllReview_ApproveCourse
        log.info("getAllReview_ApproveCourse");
        try {
            log.debug("return apiResponseBuider for request");
            log.debug("getAllReview_ApproveCourse successfully");
            // use api  to get data(Method  at ApiResponseBuilder) return a Map Objects
           return apiResponseBuider.buildContainsData("Get Review_Approve Successfully!", review_approveService.getReview_ApproveById(id));
        }catch (Exception e) {
            // show log when this function has error
            log.error("getAllReview_ApproveCourse in Class has Error: %s" + e.getMessage());
            throw e;
        }
    }
    // this method  is add data to  Database.
    // input is a id and a model  Review_ApproveDTO
    /* output : True -> insert data to database with a id.
                False ->  False: export a log is Message is Error at Param :
    */
    @PostMapping("/course/{id}/review_approve")
    public Map<String, Object> insertReview_Approve(@PathVariable int id, @RequestBody Review_ApproveDTO review_approveDTO) {
        // show log info of this function.
        log.info("insertReview_Approve");
        try {
            log.debug("return apiResponseBuider for request");
            log.debug("insertReview_Approve successfully");
            review_approveService.addReview_Approve(id, review_approveDTO);
            return ApiResponseBuider.buildSuccess("Insert Review_Approve Successfully!");
        }catch (Exception e){
            // show log when this function has error
            log.error("Error at this function at"+"Param "+id+"and"+review_approveDTO+"Messages is :"+e.getMessage());
            throw  e;
        }
    }
    // this method  is add data to  Database.
    // input is a id and a model  Review_ApproveDTO
    /* output : True -> insert data to database with a id.
                False ->  False: export a log is Message is Error at Param :
    */
    @PutMapping("/course/{id}/review_approve/{idreview_approve}")
    public Map<String, Object> updateReview_Approve(@PathVariable("idreview_approve") int id, @RequestBody Review_ApproveDTO review_approveDTO) {
        //show log info of  function updateReview_Approve
        log.info("updateReview_Approve");
        try {
            log.debug("return apiResponseBuider for request");
            log.debug("updateReview_Approve successfully");
            //  use api to update data
            review_approveService.updateReview_Approve(id, review_approveDTO);
            return ApiResponseBuider.buildSuccess("Update Review_Approve Successfully!");
        }
        catch (Exception e){
            // show log when this function has error
            log.error("Error at this function"+"Param is :"+id+"--and--"+review_approveDTO+" --Message is : "+e.getMessage());
            throw  e;
        }

    }
    // this method  is Delete a record.
    // input is a id
    /* output : True -> delete record to database with a id.
                False ->  False: export a log is Message is Error at Param :
    */
    @DeleteMapping("/course/{id}/review_approve/{idreview_approve}")
    public Map<String, Object> deleteReview_Approve(@PathVariable("idreview_approve") int id) {
        //show log info of  function deleteReview_Approve
        log.info("deleteReview_Approve");
        try {
            log.debug("return apiResponseBuider for request");
            log.debug(" deleteReview_Approve successfully");
            review_approveService.deleteReview_Approve(id);
            return ApiResponseBuider.buildSuccess("Delete Review_Approve Successful");
        } catch (Exception e){
            // show log when this function has error
            log.error("Error at this function "+"Param is:"+id);
            throw  e;
        }


    }

}
