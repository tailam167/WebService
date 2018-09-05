package com.fsoft.intern.courseplan.model;

import java.io.Serializable;

public class LogisticDTO implements Serializable {

    private int courseId;
    private String name;
    private String value;
    private String description;

    public LogisticDTO() {
    }

    public LogisticDTO(int courseId, String name, String value, String description) {
        this.courseId = courseId;
        this.name = name;
        this.value = value;
        this.description = description;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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
}
