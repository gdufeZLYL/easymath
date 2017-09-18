package com.gdufe.easymath.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "class_info")
public class ClassInfo {
    @Id
    @GeneratedValue
    private int guid;

    @Column(name = "uid")
    private int uid;

    @Column(name = "student_set")
    private String student_set;

    @Column(name = "class_name")
    private String class_name;

    @Column(name = "create_time", nullable = false)
    @DateTimeFormat(pattern = "YYYY-MM-DD HH:MM:SS")
    private Date create_time;

    public int getGuid() {
        return guid;
    }

    public void setGuid(int guid) {
        this.guid = guid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getStudent_set() {
        return student_set;
    }

    public void setStudent_set(String student_set) {
        this.student_set = student_set;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
