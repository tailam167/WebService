package com.fsoft.intern.courseplan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class BudgetDTO implements Serializable {

    private String name;
    private String value;
    private int courseId;
    private String description;

    public BudgetDTO() {
    }

    public BudgetDTO(String name, String value, int courseId, String description) {
        this.name = name;
        this.value = value;
        this.courseId = courseId;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
