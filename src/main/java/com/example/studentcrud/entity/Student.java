package com.example.studentcrud.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity

public class Student implements Serializable {
    @Id
    private int sid;
    private String sname;
    private String schoolname;
    private String address;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
