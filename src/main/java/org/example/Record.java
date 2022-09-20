package org.example;

import java.math.BigDecimal;

public class Record implements Comparable<Record> {

    private int accountID,
            neighbourhoodID;


    private House aHouse;
    private Ward aWard;

    private Geography geography;

    private String address,
            assessedClass1,
            assessedClass2,
            assessedClass3;

    private BigDecimal assessmentValue,
            assessmentClass1,
            assessmentClass2,
            assessmentClass3;




    public Record(int accID, House aHouse, Ward aWard, BigDecimal assessmentValue, Geography geography
                  ){


        this.accountID = accID;
        this.aHouse = aHouse;
        this.aWard = aWard;
        this.assessmentValue = assessmentValue;
        this.geography = geography;

        /*
        this.assessmentClass1 = assessmentClass1;
        this.assessmentClass2 = assessmentClass2;
        this.assessmentClass3 = assessmentClass3;
        this.assessedClass1 = assessedClass1;
        this.assessedClass2 = assessedClass2;
        this.assessedClass3 = assessedClass3;*/

    }


    public static int getAccNum(String accountNumber){
        int accNum;
        accNum = Integer.parseInt(accountNumber);
        return accNum;
    }

    public BigDecimal getAssessedValue(){
        return this.assessmentValue;
    }

    public static String getFullAddress(String suite, String houseNum, String streetName){
        return suite + " " + houseNum + " " + streetName;
    }

    public static boolean garageStatus(String garage){
        if (garage.equals("N"))
            return false;
        else
            return true;
    }

    public static int neighID (String aNeighID){
        int neighbourhoodID;

        neighbourhoodID = Integer.parseInt(aNeighID);

        return neighbourhoodID;
    }

    public static BigDecimal assessedValue(String value){
        BigDecimal assessedValue;
        double aValue = Double.parseDouble(value);

        assessedValue = BigDecimal.valueOf(aValue);

        return assessedValue;
    }

    public static double getLatitude(String aLatitude){
        double latitude;

        latitude = Double.parseDouble(aLatitude);

        return latitude;
    }

    public static double getLongitude(String aLongitude){
        double longitude;

        longitude = Double.parseDouble(aLongitude);

        return longitude;
    }

    @Override
    public int compareTo(Record other) {
        return 0;
    }

    @Override
    public String toString() {
        return "A Record:" +
                "\nAccount Number = " + this.accountID +
                "\nHouse Address = " + this.aHouse +
                "\nAssessed Value = $" + this.assessmentValue +
                "\nNeighbourhood = " + this.aWard +
                "\nLocation = " + geography;
    }
}

    /*public Record(int accID,
                  String address,
                  boolean garageStatus,
                  int neighID,
                  String neighbourhoodName,
                  String wardName,
                  double assessedValue,
                  double geoLat,
                  double geoLong,
                  double assessmentClass1,
                  double assessmentClass2,
                  double assessmentClass3,
                  String assessedClass1,
                  String assessedClass2,
                  String assessedClass3){*/
