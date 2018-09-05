package com.fsoft.intern.courseplan.model;

public class Review_ApproveDTO {
private String name;
private String date;
private String description;
private String value;
private  int courseId;

    public Review_ApproveDTO() {
    }

    public Review_ApproveDTO(String name, String date, String description, String value, int courseId) {
        this.name = name;
        this.date = date;
        this.description = description;
        this.value = value;
        this.courseId = courseId;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
