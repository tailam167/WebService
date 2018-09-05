package com.fsoft.intern.courseplan.model;

import java.io.Serializable;

public class HumanResourceDTO implements Serializable {
    private int courseId;
    private String name;
    private String role;
    private String description;

    public HumanResourceDTO() {
    }

    public HumanResourceDTO(int courseId, String name, String role, String description) {
        this.courseId = courseId;
        this.name = name;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
