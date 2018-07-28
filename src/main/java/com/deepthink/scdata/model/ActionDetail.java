package com.deepthink.scdata.model;

public class ActionDetail {
    private Long id;
    private Integer class_id;
    private Integer student_id;
    private Integer teacher_id;
    private Integer course_id;
    private Integer state;
    private Integer year;
    private Integer month;
    private Integer day;
    private Integer second;

    private TeacherAndcourseVO teachVo;

    @Override
    public String toString() {
        return "ActionDetail{" +
                "id=" + id +
                ", class_id=" + class_id +
                ", student_id=" + student_id +
                ", teacher_id=" + teacher_id +
                ", course_id=" + course_id +
                ", state=" + state +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", second=" + second +
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

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
}
