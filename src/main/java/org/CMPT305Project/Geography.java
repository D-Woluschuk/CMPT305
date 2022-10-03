package org.CMPT305Project;

import java.util.Objects;

/**
 * This class creates a Geography object that is used to store the Latitude and Longitude values for a property assessment record.
 * Each geography object can be used to determine if they equal another, or displayed to stdout.
 */
public class Geography {

    private double latitude;
    private double longitude;

    /**
     * A constructor of a Geography object.
     * @param latitude: The Latitude value.
     * @param longitude: The Longitude value.
     */
    public Geography(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }


    /**
     * An accessor method to return the latitude value of a geography object.
     * @returnA Double that represents the latitude value.
     */
    public double getLatitude() {
        return this.latitude;
    }

    /**
     * An accessor method to return the longitude value of a geography object.
     * @return A Double that represents the longitude value.
     */
    public double getLongitude() {
        return this.longitude;
    }


    /**
     * Creates a string representation of a Geography object, so it can be displayed to Stdout.
     * @return A string with the format: (Latitude, Longitude)
     */
    @Override
    public String toString() {
        return "(" + latitude + ", " + longitude + ")";
    }

    /**
     * Determines if two Geography objects have the same latitude and longitude values.
     * @param obj: The other object that is to be tested against "this" object.
     * @return True: If both this Geography object and the obj parameter typecast to geography have the same latitude and longitude values.
     *         False: If both this Geography object and the obj parameter typecast to geography do not have the same latitude and/or longitude values.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Geography geography))
            return false;

        return (latitude == geography.latitude) && (longitude == geography.longitude);
    }

    /**
     * Creates a hash code of the latitude and longitude values so that the hash value can be used to determine if two house objects are equal.
     * @return An integer that is returned by the Objects. Hash method.
     */
    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }
}
