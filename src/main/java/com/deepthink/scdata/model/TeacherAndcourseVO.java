package com.deepthink.scdata.model;

/**
 * @author luoyong
 * @date 2018/7/26-14:18
 */
public class TeacherAndcourseVO {
   private Long id;
    /**
     * 教师名称
     */
   private String tname;

   //添加字段状态，将结果返回前端
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    /*
       课程名称

        */
   private String cname;

    @Override
    public String toString() {
        return "TeacherAndcourseVO{" +
                "id=" + id +
                ", tname='" + tname + '\'' +
                ", cname='" + cname + '\'' +
                '}';
    }
}
