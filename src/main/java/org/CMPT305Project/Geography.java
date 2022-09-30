package org.CMPT305Project;

import java.util.Objects;

public class Geography {

    private double latitude;
    private double longitude;

    public Geography(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "(" + latitude + ", " + longitude + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Geography geography))
            return false;

        return (latitude == geography.latitude) && (longitude == geography.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }
}
