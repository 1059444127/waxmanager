package com.lm.waxmanager.domain;

/**
 * 蜡块入库临时表实体
 */
public class WaxInTmp {

    private int waxinid;
    private String pathnum;
    private String imgurl;
    private String location;

    public int getWaxinid() {
        return waxinid;
    }

    public void setWaxinid(int waxinid) {
        this.waxinid = waxinid;
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
}
