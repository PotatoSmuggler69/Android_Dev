package com.example.s04_binder_messenger;

public class Coordinates {
    private double longitude;
    private double latitude;

    Coordinates(double longitude,double latitude){
        this.longitude = longitude;
        this.latitude = latitude;
    }

    //getters
    public double get_longitude(){ return longitude; }
    public double get_latitude(){ return latitude; }

    // setters

    public void set_longitude(double l){ longitude=l; }
    public void set_latitude(double l){ latitude=l; }
}
