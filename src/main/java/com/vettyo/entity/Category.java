package com.vettyo.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

/**
 * Created by pravin on 2/15/2017.
 */
@Entity

public class Category {
    @Id
    @GeneratedValue
    private int cid;
    private String cname;
    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "cid")
    List<Ad> ads;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "cid")
    List<Speciification> speciifications;

    public Category(int cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Category() {
    }

    public List<Ad> getAd() {
        return ads;
    }

    public void setAd(List<Ad> Ad) {
        this.ads = Ad;
    }

    public Category(int cid, String cname, List<Ad> Ad) {
        this.cid = cid;
        this.cname = cname;
        this.ads = Ad;
    }

    public Category(String cname, List<Ad> ads, List<Speciification> speciifications) {
        this.cname = cname;
        this.ads = ads;
        this.speciifications = speciifications;
    }

    public List<Ad> getAds() {
        return ads;
    }

    public void setAds(List<Ad> ads) {
        this.ads = ads;
    }

    public List<Speciification> getSpeciifications() {
        return speciifications;
    }

    public void setSpeciifications(List<Speciification> speciifications) {
        this.speciifications = speciifications;
    }
}
