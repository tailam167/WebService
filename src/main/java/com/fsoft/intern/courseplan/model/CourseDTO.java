package com.fsoft.intern.courseplan.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CourseDTO {
    private int idCourse;
    private String courseName;
    private String courseCode;
    private Integer programCustomization;
    private String targetAudience;
    private Integer noOfParticipant;

    public CourseDTO() {
    }

    public CourseDTO(int idCourse, String courseName, String courseCode, Integer programCustomization, String targetAudience, Integer noOfParticipant) {
        this.idCourse = idCourse;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.programCustomization = programCustomization;
        this.targetAudience = targetAudience;
        this.noOfParticipant = noOfParticipant;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Integer getProgramCustomization() {
        return programCustomization;
    }

    public void setProgramCustomization(Integer programCustomization) {
        this.programCustomization = programCustomization;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public Integer getNoOfParticipant() {
        return noOfParticipant;
    }

    public void setNoOfParticipant(Integer noOfParticipant) {
        this.noOfParticipant = noOfParticipant;
    }

}
