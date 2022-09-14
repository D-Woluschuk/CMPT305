package org.example;

public class Record {

    public int accountID,
            neighbourhoodID;


    public String address,
            postalCode,
            neighbourhood,
            ward,
            assessedClass1,
            assessedClass2,
            assessedClass3;
    public double assessmentValue,
            latitude,
            longitude,
            assessmentClass1,
            assessmentClass2,
            assessmentClass3;


    public boolean garage;

    public Record(int accID, String address
                  ){


        this.accountID = accID;
        this.address = address;
        /*this.garage = garageStatus;
        this.neighbourhoodID = neighID;
        this.neighbourhood = neighbourhoodName;
        this.ward = wardName;
        this.assessmentValue = assessedValue;
        this.latitude = geoLat;
        this.longitude = geoLong;
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

    public static double assessedValue(String Value){
        double assessedValue;

        assessedValue = Double.parseDouble(Value);

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
