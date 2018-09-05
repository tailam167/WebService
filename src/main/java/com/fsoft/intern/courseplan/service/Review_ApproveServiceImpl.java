package com.fsoft.intern.courseplan.service;

import com.fsoft.intern.courseplan.config.Mapper;
import com.fsoft.intern.courseplan.dao.ItemDaoIpml;
import com.fsoft.intern.courseplan.entity.Course;
import com.fsoft.intern.courseplan.entity.DATA_TYPE;
import com.fsoft.intern.courseplan.entity.Item;
import com.fsoft.intern.courseplan.model.Review_ApproveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class Review_ApproveServiceImpl {


    @Autowired
    private ItemDaoIpml review_approveDao;

    @Autowired
    private CourseServiceImpl courseService;

    public List<Review_ApproveDTO> getReview_ApproveById(int id) {
        return review_approveDao.getItemById(id, DATA_TYPE.REVIEWAPPROVE).stream()
                .map(Mapper::mapReview_Approve)
                .collect(Collectors.toList());
    }

    public void addReview_Approve(int courseId, Review_ApproveDTO review_approveDTO) {
        Course course = courseService.findOne(courseId);
        if (course == null) return;

        Item item = Mapper.mapToReview_Approve(review_approveDTO);
        item.setCourse(course);
        review_approveDao.create(item);
    }

    public void updateReview_Approve(int review_approveId, Review_ApproveDTO review_approveDTO){
        Item item = review_approveDao.findOne(review_approveId);
        if(item == null) return;
        item.setName(review_approveDTO.getName());
        item.setDate(review_approveDTO.getDate());
        item.setDescription(review_approveDTO.getDescription());
        item.setValue(review_approveDTO.getValue());
        review_approveDao.update(item);
    }

    public void deleteReview_Approve(int review_approveId){

        review_approveDao.deleteById(review_approveId);
    }

}
