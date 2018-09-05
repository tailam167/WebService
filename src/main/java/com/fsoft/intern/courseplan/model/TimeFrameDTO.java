package com.fsoft.intern.courseplan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class TimeFrameDTO implements Serializable {

    private String name;
    private String date;
    private int courseId;
    private String description;

    public TimeFrameDTO() {
    }

    public TimeFrameDTO(String name, String date, int courseId, String description) {
        this.name = name;
        this.date = date;
        this.courseId = courseId;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
