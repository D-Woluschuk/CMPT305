package org.CMPT305ProjectM2;

import java.util.Objects;

/**
 * This class creates a Geography object that is used to store the Latitude and Longitude values for a property assessment record.
 * Each geography object can be used to determine if they equal another, or displayed to stdout.
 */
public class Geography {

    private double latitude;
    private double longitude;

    private static final double MAX_LONGITUDE = 80.0;
    private static final double MIN_LONGITUDE = -180.0;
    private static final double MAX_LATITUDE = 90.0;
    private static final double MIN_LATITUDE = -90.0;

    /**
     * A constructor of a Geography object.
     * @param latitude: The Latitude value.
     * @param longitude: The Longitude value.
     */
    public Geography(double latitude, double longitude){
        rangeCheck(latitude, longitude);

        this.latitude = latitude;
        this.longitude = longitude;
    }


    /**
     * An accessor method to return the latitude value of a geography object.
     * @return A Double that represents the latitude value.
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

    /**
     * Checks the range of the latitude and longitude values against the defined latitude
     * and longitude constant minimum and maximum values.
     * If it is outside that range, an IllegalArgumentException is thrown
     * @param latValue: The latitude value to be checked
     * @param longValue: The longitude value to be checked
     */
    private static void rangeCheck(double latValue, double longValue){
        if (latValue < MIN_LATITUDE || latValue > MAX_LATITUDE)
            throw new IllegalArgumentException("Latitude:" + latValue);
        else if (longValue < MIN_LONGITUDE || longValue > MAX_LONGITUDE) {
            throw new IllegalArgumentException("Longitude: " + longValue);
        }
    }

}
