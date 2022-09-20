package org.example;

public class House {

    private String houseNumber;
    private String streetName;
    private String garageStatus;
    private String suiteNumber;


    public House(String suiteNumber, String houseNum, String street, String garage){
        this.suiteNumber = suiteNumber;
        this.houseNumber = houseNum;
        this.streetName = street;
        this.garageStatus = garage;
    }

    public String getHouseNumber(){
        return this.houseNumber;
    }

    public String getStreetName(){
        return this.streetName;
    }

    public String getGarageStatus() {
        return this.garageStatus;
    }

    @Override
    public String toString() {
        String aHouse = "";
        if (this.suiteNumber.length() != 0) {
            aHouse += " " + this.suiteNumber;
        }
        if (this.houseNumber.length() != 0){
            aHouse += " " + this.houseNumber;
        }
        if (this.streetName.length() != 0){
            aHouse += " " + this.streetName;
        }
        return aHouse;
    }


}
