package com.vettyo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by pravin on 2/15/2017.
 */
@Entity

public class SpecificationValue {

    @Id
    @GeneratedValue
    private int sv_id;
    private String sp_value;

    public SpecificationValue() {
    }

    public SpecificationValue(int sv_id, String sp_value) {
        this.sv_id = sv_id;
        this.sp_value = sp_value;
    }


    public int getSv_id() {
        return sv_id;
    }

    public void setSv_id(int sv_id) {
        this.sv_id = sv_id;
    }

    public String getSp_value() {
        return sp_value;
    }

    public void setSp_value(String sp_value) {
        this.sp_value = sp_value;
    }
}
