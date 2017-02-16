package com.vettyo.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

/**
 * Created by pravin on 2/15/2017.
 */
@Entity
public class Speciification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sp_id;
    private String spec;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "sp_id")
    List<SpecificationValue> specificationValues;

    public Speciification() {
    }

    public Speciification(int sp_id, String spec) {
        this.sp_id = sp_id;
        this.spec = spec;
    }


    public int getSp_id() {
        return sp_id;
    }

    public void setSp_id(int sp_id) {
        this.sp_id = sp_id;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public List<SpecificationValue> getSpecificationValues() {
        return specificationValues;
    }

    public void setSpecificationValues(List<SpecificationValue> specificationValues) {
        this.specificationValues = specificationValues;
    }

    public Speciification(String spec, List<SpecificationValue> specificationValues) {
        this.spec = spec;
        this.specificationValues = specificationValues;
    }


}
