package com.vettyo.entity;

import javax.persistence.*;

/**
 * Created by pravin on 2/21/2017.
 */
@Entity
public class Address {
    @Id
    @GeneratedValue
    private int aid;

    @ManyToOne
    @JoinColumn(name = "sid")
    Student student;
    private String address;

    public Address(int aid, String address) {
        this.aid = aid;
        this.address = address;
    }

    public Address() {
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
