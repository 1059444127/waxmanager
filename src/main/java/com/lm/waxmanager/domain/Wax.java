package com.lm.waxmanager.domain;

import java.sql.Timestamp;

/**
 * 蜡块入库实体
 */
public class Wax {

    private int waxid;
    private String pathnum;
    private String imgurl;
    private String location;
    private int state;
    private String iner;
    private Timestamp intime;
    private String ouer;
    private Timestamp outtime;
    private String outreason;

    public int getWaxid() {
        return waxid;
    }

    public void setWaxid(int waxid) {
        this.waxid = waxid;
    }

    public String getPathnum() {
        return pathnum;
    }

    public void setPathnum(String pathnum) {
        this.pathnum = pathnum;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Timestamp getIntime() {
        return intime;
    }

    public void setIntime(Timestamp intime) {
        this.intime = intime;
    }

    public Timestamp getOuttime() {
        return outtime;
    }

    public void setOuttime(Timestamp outtime) {
        this.outtime = outtime;
    }

    public String getOutreason() {
        return outreason;
    }

    public void setOutreason(String outreason) {
        this.outreason = outreason;
    }

    public String getIner() {
        return iner;
    }

    public void setIner(String iner) {
        this.iner = iner;
    }

    public String getOuer() {
        return ouer;
    }

    public void setOuer(String ouer) {
        this.ouer = ouer;
    }
}
