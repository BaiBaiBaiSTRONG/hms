package com.max.slw.dao;
import java.security.PublicKey;

public class Building {
    public int buildingid;
    public String buildingname;
    public int floor;
    public String loc;
    public String status;

    public Building(){}
    public Building(int buildingid, String buildingname, int floor, String loc, String status) {
        this.buildingid = buildingid;
        this.buildingname = buildingname;
        this.floor = floor;
        this.loc = loc;
        this.status = status;
    }

    public int getBuildingid() {
        return buildingid;
    }

    public void setBuildingid(int buildingid) {
        this.buildingid = buildingid;
    }

    public String getBuildingname() {
        return buildingname;
    }

    public void setBuildingname(String buildingname) {
        this.buildingname = buildingname;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
