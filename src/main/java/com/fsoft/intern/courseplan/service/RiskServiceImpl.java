package com.fsoft.intern.courseplan.service;

import com.fsoft.intern.courseplan.config.Mapper;
import com.fsoft.intern.courseplan.dao.ItemDaoIpml;
import com.fsoft.intern.courseplan.entity.Course;
import com.fsoft.intern.courseplan.entity.DATA_TYPE;
import com.fsoft.intern.courseplan.entity.Item;
import com.fsoft.intern.courseplan.model.RiskDTO;
import com.fsoft.intern.courseplan.model.TimeFrameDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RiskServiceImpl {

    protected final Log logger = LogFactory.getLog(CourseServiceImpl.class);

    @Autowired
    private ItemDaoIpml riskDAO;

    @Autowired
    private CourseServiceImpl courseService;
    public Course getByRiskCode(Integer CourseCode) {
        logger.info("getByRiskCode Service");
        try {
            Course c = new Course();
            c = (Course) riskDAO.getByRiskCode(CourseCode,DATA_TYPE.RISKISSUE);
            logger.debug("success");
            return c;
        } catch (Exception e) {
            logger.error("getByCourseCode error wich CourseCode: " + CourseCode);
            throw e;
        }

    }
    /**
     * This function is used to show list risk/issues
     *
     * @param id
     * @return list
     */
    public List<RiskDTO> getRiskById(int id) {
        return riskDAO.getItemById(id, DATA_TYPE.RISKISSUE).stream()
                .map(Mapper::mapRisk)
                .collect(Collectors.toList());
    }
    /**
     * This function is used to add a risk/issues
     *
     * @param RiskId
     * @return item as Json format
     */
    public void addRisk(int RiskId, RiskDTO riskDTO) {
        Course course = courseService.findOne(RiskId);
        if (course == null) return;
        Item item = Mapper.mapriskDTO(riskDTO);
        item.setCourse(course);
        riskDAO.create(item);
    }
    /**
     * This function is used to update a risk/issues
     *
     * @param RiskId
     * @return item as Json format
     */
    public void updateRisk(int RiskId, RiskDTO riskDTO) {
        Item item = riskDAO.findOne(RiskId);
        if (item == null) return;
        item.setDate(riskDTO.getStatus());
        item.setName(riskDTO.getName());
        item.setDescription(riskDTO.getDescription());
        item.setValue(riskDTO.getSolution());
        riskDAO.update(item);
    }
    /**
     * This function is used to delete a risk/issues
     *
     * @param RiskId
     * @return item as Json format
     */
    public void deleteRisk(int RiskId) {
        Item item = riskDAO.findOne(RiskId);
        if (item.getDataType().toString().equals("RISKISSUE")) {
            riskDAO.deleteById(RiskId);
        }
    }
}
