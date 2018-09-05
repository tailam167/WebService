package com.fsoft.intern.courseplan.controller;

import com.fsoft.intern.courseplan.ApiResponseBuider;
import com.fsoft.intern.courseplan.model.HumanResourceDTO;
import com.fsoft.intern.courseplan.service.HumanResourceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class HumanResourceController {
    @Autowired
    HumanResourceServiceImpl humanResourceService;

    @GetMapping("/course/{id}/humanresource")
    public Map<String, Object> getAllHumanResourceCourse(@PathVariable int id) {
        return ApiResponseBuider.buildContainsData("List HumanResource Success", humanResourceService.getHumanResourceById(id));
    }

    @PostMapping("/course/{id}/humanresource")
    public Map<String, Object> insertHumanResource(@PathVariable int id, @RequestBody HumanResourceDTO humanResourceDTO) {
        humanResourceService.addHumanResource(id, humanResourceDTO);
        return ApiResponseBuider.buildSuccess("Insert HumanResource Success");
    }

    @PutMapping("/course/{id}/humanresource/{idHumanResource}")
    public Map<String, Object> updateHumanResource(@PathVariable("idHumanResource") int id, @RequestBody HumanResourceDTO idHumanResource) {
        humanResourceService.updateHumanResource(id, idHumanResource);
        return ApiResponseBuider.buildSuccess("Update HumanResource Success");
    }

    @DeleteMapping("course/{id}/humanresource/{idHumanResource}")
    public Map<String, Object> deleteHumanResource(@PathVariable("idHumanResource") int id){
        humanResourceService.deleteHumanResource(id);
        return ApiResponseBuider.buildSuccess("Delete HumanResource Success");
    }
}
