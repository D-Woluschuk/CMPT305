package org.example;

public class Geography {

    private double latitude;
    private double longitude;

    public Geography(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "(" + longitude + ", " + latitude + ")";
    }
}
