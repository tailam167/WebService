package com.fsoft.intern.courseplan.entity;



import javax.persistence.*;
import java.io.Serializable;

@Entity(name="Course")
@Table(name="Course")
public class Course implements Serializable {
    @Id
    @Column(name="id_course ")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCourse;
    @Column(name="course_name")
    private String courseName;
    @Column(name="course_code")
    private String courseCode;
    @Column(name="program_customization")
    private Integer programCustomization;
    @Column(name="target_audience")
    private String targetAudience;
    @Column(name="no_of_participant")
    private Integer noOfParticipant;

    public Course() {
    }

    public Course(String courseName, String courseCode, Integer programCustomization, String targetAudience, Integer noOfParticipant) {
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
