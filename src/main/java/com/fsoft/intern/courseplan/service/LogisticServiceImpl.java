package com.fsoft.intern.courseplan.service;

import com.fsoft.intern.courseplan.ApiResponseBuider;
import com.fsoft.intern.courseplan.config.Mapper;
import com.fsoft.intern.courseplan.dao.ItemDaoIpml;
import com.fsoft.intern.courseplan.entity.Course;
import com.fsoft.intern.courseplan.entity.DATA_TYPE;
import com.fsoft.intern.courseplan.entity.Item;
import com.fsoft.intern.courseplan.model.LogisticDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class LogisticServiceImpl {
    ApiResponseBuider apiResponseBuider;
    private static final Log log = LogFactory.getLog(BudgetServiceImpl.class);
    @Autowired
    private ItemDaoIpml logisticDao;

    @Autowired
    private CourseServiceImpl courseService;

    /* Show list Logistic by ID
     * @param id
     * return list logistic
     */
    public List<LogisticDTO> getLogisticById(int id) {
        log.info(String.format("mapLogistic in class: %s", getClass()));
        try{
            //export log if get data success when debug project
            log.debug("return list logistic for request");
            log.debug("getLogisticById successfully");
            return logisticDao.getItemById(id, DATA_TYPE.LOGISTIC).stream()
                    .map(Mapper::mapLogistic)
                    .collect(Collectors.toList());
        }catch (Exception e){
            //export log with message error if get data fail
            log.error(String.format("getLogisticById with param 'id' in class %s has error: %s", getClass(), e.getMessage()));
            throw e;
        }
    }

    /* Add new Logistic
     * @param courseId
     */
    public Map<String,Object> addLogistic(int courseId, LogisticDTO logisticDTO) {
        try{
            //get course by courseid
            Course course = courseService.findOne(courseId);
            //if course null: return API with message Add Logistic Failed!
            if (course == null) return apiResponseBuider.buildError("Add Logistic Failed!");
            Item item = Mapper.mapToLogistic(logisticDTO);
            item.setCourse(course);
            logisticDao.create(item);
            return apiResponseBuider.buildSuccess("Add Logistic Successfully!");
        }catch (Exception e){
            //export log with message error if add data fail
            log.error(String.format("addLogistic with param 'courseId' in class %s has error: %s", getClass(), e.getMessage()));
            throw e;
        }

    }

    /* Update Logistic
     * @param logisticId
     */
    public Map<String,Object> updateLogistic(int logisticId, LogisticDTO logisticDTO){
        try{
            //get item by logisticId
            Item item = logisticDao.findOne(logisticId);
            //if item null return API with message Update Logistic Failed!
            if(item == null) return  apiResponseBuider.buildError("Update Logistic Failed!");
            item.setName(logisticDTO.getName());
            item.setValue(logisticDTO.getValue());
            item.setDescription(logisticDTO.getDescription());
            logisticDao.update(item);
            return apiResponseBuider.buildSuccess("Update Logistic Successfully!");
        }catch (Exception e){
            //export log with message error if update data fail
            log.error(String.format("updateLogistic with param 'logisticId' in class %s has error: %s", getClass(), e.getMessage()));
            throw e;
        }

    }

    /* Delete Logistic
     * @param logisticId
     */
    public void deleteLogistic(int logisticId){
        try{
            //get item by logisticId
            Item item = logisticDao.findOne(logisticId);
            //if DataType is LOGISTIC action delete data by logisticId
            if(item.getDataType().toString().equals("LOGISTIC")){
                logisticDao.deleteById(logisticId);
            }
        }catch (Exception e){
            //export log with message error if delete data fail
            log.error(String.format("deleteLogistic with param 'logisticId' in class %s has error: %s", getClass(), e.getMessage()));
            throw e;
        }
    }

}
