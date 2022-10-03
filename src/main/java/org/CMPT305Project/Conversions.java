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
     *
     * @param value
     * @return
     */
    public static double convertAssessedValue(String value) {
        double assessedValue;

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
     *
     * @param aLatitude
     * @return
     */
    public static double convertLatitude(String aLatitude) {
        double latitude;

        if (!(aLatitude.contains("."))){
            latitude = 0;
            return latitude;
        }
        try {
            latitude = Double.parseDouble(aLatitude);
        } catch (NullPointerException | NumberFormatException exception) {
            latitude = 0;
        }
        return latitude;
    }

    /**
     *
     * @param aLongitude
     * @return
     */
    public static double convertLongitude(String aLongitude) {
        double longitude;

        if (!(aLongitude.contains("."))){
            longitude = 0;
            return longitude;
        }
        try {
            longitude = Double.parseDouble(aLongitude);
        } catch (NullPointerException | NumberFormatException exception) {
            longitude = 0;
        }
        return longitude;
    }

    /**
     *
     * @param amount
     * @return
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
     *
     * @param anId
     * @return
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
