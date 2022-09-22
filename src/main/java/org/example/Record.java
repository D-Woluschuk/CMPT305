package org.example;

import java.util.Objects;

public class Record implements Comparable<Record> {

    private int accountID;

    private House aHouse;
    private Ward aWard;

    private Geography geography;

    private Assessment assessmentClass;

    private double assessmentValue;





    public Record(int accID, House aHouse, Ward aWard, double assessmentValue, Geography geography, Assessment assessmentClass
                  ){


        this.accountID = accID;
        this.aHouse = aHouse;
        this.aWard = aWard;
        this.assessmentValue = assessmentValue;
        this.geography = geography;
        this.assessmentClass = assessmentClass;

        /*
        this.assessmentClass1 = assessmentClass1;
        this.assessmentClass2 = assessmentClass2;
        this.assessmentClass3 = assessmentClass3;
        this.assessedClass1 = assessedClass1;
        this.assessedClass2 = assessedClass2;
        this.assessedClass3 = assessedClass3;*/

    }


    public int getAccountID(){
        return this.accountID;
    }

    public static int convertAccNum(String accountNumber){
        int accNum;
        accNum = Integer.parseInt(accountNumber);
        return accNum;
    }

    public double getAssessedValue(){
        return this.assessmentValue;
    }



    public static double assessedValue(String value){
        double assessedValue= Double.parseDouble(value);
        //double aValue

        //assessedValue = BigDecimal.valueOf(aValue);
        //assessedValue = assessedValue.setScale(2);
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
                "\nAssessment Class = " + this.assessmentClass +
                "\nNeighbourhood = " + this.aWard +
                "\nLocation = " + geography;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Record record)){
            return false;
        }

        return (this.accountID == record.accountID) &&
                ((this.aHouse).equals(record.aHouse)) &&
                (this.assessmentValue == (record.assessmentValue)) &&
                (this.aWard.equals(record.aWard)) &&
                (this.geography.equals(record.geography));
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountID, aHouse, assessmentValue, aWard, geography);
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
