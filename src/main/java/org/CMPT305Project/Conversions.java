package org.CMPT305Project;

public class Conversions {

    public static int convertAccNum(String accountNumber) {
        int accNum;
        accNum = Integer.parseInt(accountNumber);
        return accNum;
    }


    public static double convertAssessedValue(String value) {

        return Double.parseDouble(value);
    }

    public static double convertLatitude(String aLatitude) {
        double latitude;

        latitude = Double.parseDouble(aLatitude);

        return latitude;
    }

    public static double convertLongitude(String aLongitude) {
        double longitude;

        longitude = Double.parseDouble(aLongitude);

        return longitude;
    }
}
