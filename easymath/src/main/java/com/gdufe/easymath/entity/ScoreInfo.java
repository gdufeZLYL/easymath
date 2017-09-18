package com.gdufe.easymath.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "score_info")
public class ScoreInfo {
    @Id
    @GeneratedValue
    private int testid;

    @Column(name = "uid")
    private int uid;

    @Column(name = "type", nullable = false)
    private int type;

    @Column(name = "level", nullable = false)
    private int level;

    @Column(name = "que_type", nullable = false)
    private int que_type;

    @Column(name = "score_right", nullable = false)
    private int score_right;

    @Column(name = "score_wrong", nullable = false)
    private int score_wrong;

    @Column(name = "finish_time", nullable = false)
    @DateTimeFormat(pattern = "YYYY-MM-DD HH:MM:SS")
    private Date finish_time;

    public int getTestid() {
        return testid;
    }

    public void setTestid(int testid) {
        this.testid = testid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getQue_type() {
        return que_type;
    }

    public void setQue_type(int que_type) {
        this.que_type = que_type;
    }

    public int getScore_right() {
        return score_right;
    }

    public void setScore_right(int score_right) {
        this.score_right = score_right;
    }

    public int getScore_wrong() {
        return score_wrong;
    }

    public void setScore_wrong(int score_wrong) {
        this.score_wrong = score_wrong;
    }

    public Date getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(Date finish_time) {
        this.finish_time = finish_time;
    }
}
