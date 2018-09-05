package com.fsoft.intern.courseplan.service;

import com.fsoft.intern.courseplan.config.Mapper;
import com.fsoft.intern.courseplan.dao.ItemDaoIpml;
import com.fsoft.intern.courseplan.entity.Course;
import com.fsoft.intern.courseplan.entity.DATA_TYPE;
import com.fsoft.intern.courseplan.entity.Item;
import com.fsoft.intern.courseplan.model.TimeFrameDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TimeFrameServiceImpl {

    @Autowired
    private ItemDaoIpml timeFrameDao;

    @Autowired
    private CourseServiceImpl courseService;

    protected final Log logger = LogFactory.getLog(TimeFrameServiceImpl.class);
    /*function getTimeFrameById get list TimeFrame
     * extend ItemDaoIpml
     * param @id
     * @return list TimeFrame
     */
    public List<TimeFrameDTO> getTimeFrameById(int id) {
        return timeFrameDao.getItemById(id, DATA_TYPE.TIMEFRAMES).stream()
                .map(Mapper::mapTimeFrame)
                .collect(Collectors.toList());
    }
    /*function insertTimeFrame use add TimeFrame with id
     * extend ItemDaoIpml
     * find id course
     * check timeframe with name
     * param @id,@timeFrameDTO
     * @return boolean
     */
    public boolean insertTimeFrame(int courseId, TimeFrameDTO timeFrameDTO) {
        logger.info("Timeframe Service");
        Course course = courseService.findOne(courseId);
        try {
            if (course != null) {
                if (!timeFrameDao.ItemExists(timeFrameDTO.getName())) {
                    Item item = Mapper.mapToItem(timeFrameDTO);
                    item.setCourse(course);
                    timeFrameDao.create(item);
                    logger.debug("Insert TimeFrame success");
                    return true;
                }
            }
            return false;
        }
        catch (Exception e)
        {
            logger.error("Loi TimeFrame with name "+timeFrameDTO.getName());
            throw e;
        }
    }
    /*function updateTimeFrame use update TimeFrame with timeFrameId
     * extend ItemDaoIpml
     * find id course
     * check timeframe with name
     * param @id,@timeFrameDTO
     * @return boolean
     */
    public boolean updateTimeFrame(int timeFrameId, TimeFrameDTO timeFrameDTO){
        logger.info("Timeframe Service");
        try {
            Item item = timeFrameDao.findOne(timeFrameId);
            // kiểm tra id timeframe đã có hay chưa
            if (item != null) {
                // kiểm tra timeframe có trùng nhau không
                    item.setDate(timeFrameDTO.getDate());
                    item.setDescription(timeFrameDTO.getDescription());
                    timeFrameDao.update(item);
                    logger.debug("update TimeFrame success");
                    return true;
            }
            return false;
        }
        catch (Exception e)
        {
            logger.error("Loi TimeFrame with id "+timeFrameId);
            throw e;
        }
    }
    /*function deleteTimeFrame use delete one TimeFrame with timeFrameId
     * extend ItemDaoIpml
     * find id course
     * check timeframe with name
     * param @id,@timeFrameDTO
     * @return boolean
     */
    public boolean deleteTimeFrame(int timeFrameId){
        try {
            logger.info("Timeframe Service");
            Item item = timeFrameDao.findOne(timeFrameId);
            if(item!=null) {
                if (item.getDataType().toString().equals("TIMEFRAMES")) {
                    timeFrameDao.deleteById(timeFrameId);
                    logger.debug("delete TimeFrame success");
                    return true;
                }
            }
            return false;
        }
        catch (Exception e)
        {

            logger.error("Loi TimeFrame with id "+timeFrameId);
            throw e;
        }
    }
    /*function getByItem use show data after insert,update timeframe with name
     * extend ItemDaoIpml
     * param @id,@timeFrameDTO
     * @return Item
     */
    public Item getByItem(String name)
    {
        try {
            Item item = timeFrameDao.getByItem(name);
            return item;
        }
        catch (Exception e)
        {
            throw  e;
        }
    }
    /*function getByItem use show data after insert,update timeframe with id
     * extend ItemDaoIpml
     * param @id,@timeFrameDTO
     * @return Item
     */
    public Item getItemByIdItem(int  id)
    {
        try {
            Item item = timeFrameDao.getItemByIdItem(id,DATA_TYPE.TIMEFRAMES);
            return item;
        }
        catch (Exception e)
        {
            throw  e;
        }
    }


}
