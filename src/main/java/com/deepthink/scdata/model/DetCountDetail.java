package com.deepthink.scdata.model;


public class DetCountDetail {
    private Long id;
    private Integer class_id;
    private Integer course_id;
    private Integer year;
    private Integer month;
    private Integer day;
    private Integer second;
    private Integer det_count;


    @Override
    public String toString() {
        return "DetCountDetail{" +
                "id=" + id +
                ", class_id=" + class_id +
                ", course_id=" + course_id +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", second=" + second +
                ", det_count=" + det_count +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    public Integer getDet_count() {
        return det_count;
    }

    public void setDet_count(Integer det_count) {
        this.det_count = det_count;
    }
}
