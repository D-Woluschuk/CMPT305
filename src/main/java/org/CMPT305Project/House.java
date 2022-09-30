package org.CMPT305Project;

import java.util.Objects;

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

    public String getSuiteNumber() {
        return this.suiteNumber;
    }

    @Override
    public String toString() {
        String aHouse = "";
        if (this.suiteNumber.length() != 0) {
            aHouse += this.suiteNumber + "-";
        }
        if (this.houseNumber.length() != 0){
            aHouse += this.houseNumber + " ";
        }
        if (this.streetName.length() != 0){
            aHouse += this.streetName;
        }
        return aHouse;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suiteNumber, houseNumber, streetName, garageStatus);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof House aHouse))
            return false;

        return aHouse.suiteNumber.equals(this.suiteNumber) &&
                aHouse.houseNumber.equals(this.houseNumber) &&
                aHouse.streetName.equals(this.streetName) &&
                aHouse.garageStatus.equals(this.garageStatus);
    }
}
