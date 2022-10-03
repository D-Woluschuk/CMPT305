package org.CMPT305Project;

import java.util.Objects;

/**
 * This class creates a House object that represents the Suite Number, House Number, Street, and Garage Status of
 * a record. Each house can be compared to another house, in addition to displaying the information that makes up
 * a house.
 */
public class House {

    private String houseNumber;
    private String streetName;
    private String garageStatus;
    private String suiteNumber;


    /**
     * The constructor for a house object.
     * @param suiteNumber: The suite number for a particular address.
     * @param houseNum: The house number.
     * @param street: The street name and/or number.
     * @param garage: Can be "Y" if a house has a garage, or "N" if there is no garage.
     */
    public House(String suiteNumber, String houseNum, String street, String garage){
        this.suiteNumber = suiteNumber;
        this.houseNumber = houseNum;
        this.streetName = street;
        this.garageStatus = garage;
    }

    /**
     * Is an accessor for a house object that retrieves the house number.
     * @return houseNumber: The houseNumber field of a House object.
     */
    public String getHouseNumber(){
        return this.houseNumber;
    }

    /**
     * Is an accessor for a house object that retrieves the street name. A street name can be a numerical value
     * or a combination of numbers and letters. Ex: 106Street, Clareview Road, etc..
     * @return streetName: The streetName field of a House object.
     */
    public String getStreetName(){
        return this.streetName;
    }

    /**
     * Is an accessor for a house object that retrieves the garage status of a house.
     * @return garageStatus: This can be "Y" if a house has a garage. Or "N" if a house does not have a garage.
     */
    public String getGarageStatus() {
        return this.garageStatus;
    }

    /**
     * Is an accessor for a house object that retrieves the suite number. Not ever address has a suite number.
     * @return suiteNumber: This retrieves the suiteNumber field of a House object.
     */
    public String getSuiteNumber() {
        return this.suiteNumber;
    }

    /**
     * Allows for a House object to be represented as a string to Stdout.
     * @return aHouse: A string that contains all information about a House object. (Suite Number, House Number, Street Name, Garage Status)
     */
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
            aHouse += this.streetName + " ";
        }
        if (this.garageStatus.length() != 0){
            aHouse += this.garageStatus;
        }
        return aHouse;
    }

    /**
     * Creates a hash code of each field of a House object that can be used to determine if two house objects are equal.
     * @return An integer that is returned by the Objects. Hash method.
     */
    @Override
    public int hashCode() {
        return Objects.hash(suiteNumber, houseNumber, streetName, garageStatus);
    }

    /**
     *
     * @param obj: The other house object that is being compared to this house object.
     * @return True: If each field of the typecast house object equals this house object.
     *         False: If one or more field of the typecast house object does not equal this house object.
     */
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
