package com.deepthink.scdata.model;

/**
 * @author luoyong
 * @date 2018/7/26-11:06
 */
public class Teacher {
    private Long id;
    private String tname;

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

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", tname='" + tname + '\'' +
                '}';
    }
}
