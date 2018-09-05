package com.fsoft.intern.courseplan.controller;

import com.fsoft.intern.courseplan.entity.Course;
import com.fsoft.intern.courseplan.entity.Item;
import com.fsoft.intern.courseplan.model.CourseDTO;
import com.fsoft.intern.courseplan.model.TimeFrameDTO;
import com.fsoft.intern.courseplan.service.CourseServiceImpl;
import com.fsoft.intern.courseplan.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemServiceImpl itemService;
    @Autowired
    CourseServiceImpl courseService;

    @GetMapping("/course/item")
    public List<Item> itemList() {
        return itemService.findAll();
    }

    @GetMapping("/course/{id}/item")
    public List<Item> itemListByID(@PathVariable("id") int id) {
        return itemService.getItemById(id);
    }

    @PostMapping("/course/{id}/item")
    public void createItem(@RequestBody Item item, @PathVariable("id") int id) {
        Course currentCourse = courseService.findOne(id);
//        System.out.println(currentCourse.getIdCourse());
        if (currentCourse != null) {
            itemService.create(item);
        }
    }

    @DeleteMapping("/course/{id}/item/{iditem}")
    public void deletecourseList(@PathVariable("iditem") int iditem,@PathVariable("id") int id) {
        if (courseService.findOne(id)!=null)
        {
            if(itemService.findOne(iditem)!=null) {
                itemService.deleteById(iditem);
            }
        }

    }


    @PutMapping("/course/{id}/item")
    public void updateCustomer(@PathVariable("id") int id, @RequestBody Item item) {

        Item currentItem = itemService.findOne(id);
        currentItem.setIdItem(item.getIdItem());
        if (currentItem != null) {
            itemService.update(item);
        }
    }


}
