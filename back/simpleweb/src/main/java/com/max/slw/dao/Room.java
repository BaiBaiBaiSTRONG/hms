package com.max.slw.dao;

import java.security.PublicKey;

public class Room {
    public int roomid;
    public String roomname;
    public int buildingid;
    public int ownerid;
    public int area;
    public String tenement;
    public String status;

    public Room(int roomid, String roomname, int buildingid, int ownerid, int area, String tenement, String status) {
        this.roomid = roomid;
        this.roomname = roomname;
        this.buildingid = buildingid;
        this.ownerid = ownerid;
        this.area = area;
        this.tenement = tenement;
        this.status = status;
    }

    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public int getBuildingid() {
        return buildingid;
    }

    public void setBuildingid(int buildingid) {
        this.buildingid = buildingid;
    }

    public int getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(int ownerid) {
        this.ownerid = ownerid;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getTenement() {
        return tenement;
    }

    public void setTenement(String tenement) {
        this.tenement = tenement;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
