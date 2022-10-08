package org.CMPT305Project;


import java.text.NumberFormat;
import java.util.Locale;

/**
 * This class converts various strings into their respective values needed by other classes within
 * the package to build the list of property assessment records. It is also used to convert user inputted
 * values, so they can be compared against Record objects.
 */
public class Conversions {

    /**
     * Converts a string that represents an account number into an integer, so it can be stored as an integer
     * @param accountNumber: A string that represents an account number
     * @return accNum: The converted string that represents an account number.
     */
    public static int convertAccNum(String accountNumber) {
        int accNum;

        try{
            accNum = Integer.parseInt(accountNumber);
        } catch (NumberFormatException n1){
            accNum = 0;
        }

        return accNum;
    }


    /**
     * Converts a string that represents a property assessment value into a double, so it can be stored as a double
     * in a Record object.
     * @param value: A string that represents a property assessment value.
     * @return assessedValue: The converted string that represents a property assessment value.
     */
    public static double convertAssessedValue(String value) {
        double assessedValue;

        //To avoid potential errors where e might be interpreted as exponent during the conversion.
        if (value.contains("e") || value.contains("E")){
            assessedValue = 0;
            return assessedValue;
        }


        try {

            assessedValue = Double.parseDouble(value);
        } catch (NullPointerException | NumberFormatException exception){
            assessedValue = 0;
        }
        return assessedValue;
    }

    /**
     * Converts a string that represents the Latitude of a property assessment into a double.
     * @param aLatitude: A string representation of a latitude value.
     * @return latitude: The latitude of a property assessment converted to a double.
     */
    public static double convertLatitude(String aLatitude) {
        double latitude;


        try {

            if (!(aLatitude.contains("."))){
                latitude = 0;
                return latitude;
            }

            latitude = Double.parseDouble(aLatitude);
        } catch (NullPointerException | NumberFormatException exception) {
            latitude = 0;
        }
        return latitude;
    }

    /**
     * Converts a string that represents the Longitude of a property assessment into a double.
     * @param aLongitude: A string representation of a longitude value.
     * @return longitude: The longitude of a property assessment converted to a double.
     */
    public static double convertLongitude(String aLongitude) {
        double longitude;

        try {
            if (!(aLongitude.contains("."))){
                longitude = 0;
                return longitude;
            }
            longitude = Double.parseDouble(aLongitude);
        } catch (NullPointerException | NumberFormatException exception) {
            longitude = 0;
        }
        return longitude;
    }

    /**
     * Converts a double value into a dollar value as a string.
     * Example: 1234.00 becomes "$1,234.00"
     * @param amount: The value that is to be converted to a dollar value.
     * @return convertedValue: The string that is constructed when converting the double to a dollar value.
     */
    public static String convertToDollarValue(double amount){

        Locale locale = Locale.getDefault();
        NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(locale);
        String convertedValue;

        try {
            convertedValue = dollarFormat.format(amount);
        } catch (ArithmeticException arithmeticException){
            return "0";
        }
        return convertedValue;

    }

    /**
     * Converts a string that represents a neighbourhood id into an integer.
     * @param anId: The string that represents a neighbourhood ID.
     * @return convertedValue: An integer that represents anId parameter as an integer.
     */
    public static int convertNeighbourhoodId(String anId){
        int convertedValue;

        try {
            convertedValue = Integer.parseInt(anId);
        } catch (NumberFormatException exception){
            convertedValue = 0;
        }
        return convertedValue;

    }
}
