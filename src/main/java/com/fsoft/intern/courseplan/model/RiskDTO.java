package com.fsoft.intern.courseplan.model;

import java.io.Serializable;

public class RiskDTO implements Serializable {

    private int courseId;
    private String name;
    private String status;
    private String description;
    private String solution;

    public RiskDTO() {
    }

    public RiskDTO(String name, String status, String description, String solution, int courseId) {
        this.name = name;
        this.status = status;
        this.description = description;
        this.solution = solution;
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
