package com.fsoft.intern.courseplan.service;

import com.fsoft.intern.courseplan.config.Mapper;
import com.fsoft.intern.courseplan.dao.ItemDaoIpml;
import com.fsoft.intern.courseplan.entity.Course;
import com.fsoft.intern.courseplan.entity.DATA_TYPE;
import com.fsoft.intern.courseplan.entity.Item;
import com.fsoft.intern.courseplan.model.HumanResourceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class HumanResourceServiceImpl {

    @Autowired
    private ItemDaoIpml humanResourceDao;

    @Autowired
    private CourseServiceImpl courseService;

    public List<HumanResourceDTO> getHumanResourceById(int id) {
        return humanResourceDao.getItemById(id, DATA_TYPE.HUMANRESOURSE).stream()
                .map(Mapper::mapHumanResource)
                .collect(Collectors.toList());
    }

    public void addHumanResource(int courseId, HumanResourceDTO humanResourceDTO) {
        Course course = courseService.findOne(courseId);
        if (course == null) return;

        Item item = Mapper.mapToItem(humanResourceDTO);
        item.setCourse(course);
        humanResourceDao.create(item);
    }

    public void updateHumanResource(int humanResourceId, HumanResourceDTO humanResourceDTO) {
        Item item = humanResourceDao.findOne(humanResourceId);
        if(item == null) return;
        item.setName(humanResourceDTO.getName());
        item.setValue(humanResourceDTO.getRole());
        item.setDescription(humanResourceDTO.getDescription());

        humanResourceDao.update(item);
    }

    public void deleteHumanResource(int humanResourceId){
        Item item = humanResourceDao.findOne(humanResourceId);

        if(item.getDataType().toString().equals("HUMAN_RESOURSE")) {
            humanResourceDao.deleteById(humanResourceId);
        }
    }
}
