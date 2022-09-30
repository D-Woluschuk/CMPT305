package org.CMPT305Project;


import java.text.NumberFormat;
import java.util.Locale;

public class Conversions {

    public static int convertAccNum(String accountNumber) {
        int accNum;
        try{
            accNum = Integer.parseInt(accountNumber);
        } catch (NumberFormatException n1){
            accNum = 0;
        }

        return accNum;
    }


    public static double convertAssessedValue(String value) {
        double assessedValue;

        try {
            assessedValue = Double.parseDouble(value);
        } catch (NullPointerException | NumberFormatException exception){
            assessedValue = 0;
        }
        return assessedValue;
    }

    public static double convertLatitude(String aLatitude) {
        double latitude;

        try {
            latitude = Double.parseDouble(aLatitude);
        } catch (NullPointerException | NumberFormatException exception) {
            latitude = 0;
        }
        return latitude;
    }

    public static double convertLongitude(String aLongitude) {
        double longitude;

        try {
            longitude = Double.parseDouble(aLongitude);
        } catch (NullPointerException | NumberFormatException exception) {
            longitude = 0;
        }
        return longitude;
    }

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
