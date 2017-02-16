package com.vettyo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by pravin on 2/15/2017.
 */
@Entity
public class Ad {
    private int ad_id;
    private String adName;

    public Ad() {
    }

    public Ad(int ad_id, String adName) {
        this.ad_id = ad_id;
        this.adName = adName;
    }

    @Id
    @GeneratedValue
    public int getAd_id() {
        return ad_id;
    }

    public void setAd_id(int ad_id) {
        this.ad_id = ad_id;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }
}

