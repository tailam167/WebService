package com.fsoft.intern.courseplan.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="Item")
@Table(name="Item")
public class Item implements Serializable {
    @Id
    @Column(name="id_item")
    private int idItem;

    @Column(name="name")
    private String name;

    @Column(name="value")
    private String value;

    @Column(name="data_type")
    @Enumerated(EnumType.STRING)
    private DATA_TYPE dataType;

    @Column(name="ddescription")
    private String description;

    @Column(name="date")
    private String date;


  //  @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ManyToOne
    @JoinColumn(name = "id_course")
//    @JoinColumn(name = "id_course", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
//    @JsonIdentityReference(alwaysAsId=true)
//    @JsonProperty("id_course")
    private Course course;

    public Item() {
    }

    public Item(String name, DATA_TYPE dataType, String description, Course course) {

        this.name = name;
        this.dataType = dataType;
        this.description = description;
        this.course = course;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
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

    public DATA_TYPE getDataType() {
        return dataType;
    }

    public void setDataType(DATA_TYPE dataType) {
        this.dataType = dataType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
