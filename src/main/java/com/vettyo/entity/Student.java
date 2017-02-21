package com.vettyo.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by pravin on 2/21/2017.
 */
@Entity
public class Student {

    @Id
    @GeneratedValue
    private int sid;
    private String sname;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    List<Address> addresses;

    public Student(String sname) {
        this.sname = sname;
    }

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

    public Student() {
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
