package org.CMPT305Project;

import java.util.List;
import java.util.Objects;

/**
 * This class creates a Record object that represents a line read from a property assessment
 * file. It also implements the Comparable interface to compare the assessment value of each record.
 */
public class Record implements Comparable<Record> {

    private int accountID;

    private House aHouse;
    private Ward aWard;

    private Geography geography;

    private List<Assessment> assessmentClass;

    private double assessmentValue;


    /**
     * The constructor for a Record object.
     * @param accID: The account ID. This is a unique value.
     * @param aHouse: A House object that represents the address of a property and if a location has a garage.
     * @param aWard: A ward object that consists of a Ward Name and a Neighbourhood Object.
     * @param assessmentValue: The Property Assessment Value that was assigned to this property ID.
     * @param geography: A Geography Object that consists of the property's Latitude and Longitude coordinates.
     * @param assessmentClass: An Assessment Object that consists of the categories the property falls under,
     *                       along with the percentage value for that category.
     */
    public Record(int accID, House aHouse, Ward aWard, double assessmentValue, Geography geography, List<Assessment> assessmentClass) {

        this.accountID = accID;
        this.aHouse = aHouse;
        this.aWard = aWard;
        this.assessmentValue = assessmentValue;
        this.geography = geography;
        this.assessmentClass = assessmentClass;
    }



    /**
     * An accessor method that retrieves the accountID for a Record object.
     * @return The Records accountID value.
     */
    public int getAccountID() {
        return this.accountID;
    }



    /**
     * An accessor method that retrieves the assessment value for a Record object.
     * @return The Records assessmentValue field.
     */
    public double getAssessedValue() {
        return this.assessmentValue;
    }



    /**
     * An accessor method that retrieves the Wards Neighbourhood Object for a Record object.
     * @return The neighbourhood object from the Ward object.
     */
    public Neighbourhood getNeighbourhood(){
        return this.aWard.getNeighbourhood();
    }



    /**
     * An accessor method that retrieves the assessment object for a Record object.
     * @return The assessment object that contains the assessment classes and percentages
     */
    public List<Assessment> getAssessment(){
        return this.assessmentClass;
    }



    /**
     * An accessor method that retrieves the House object for a Record object.
     * @return The house object that contains the address and garage status for a property
     */
    public House getaHouse() {
        return this.aHouse;
    }



    /**
     * Compares two Record objects and determines which one has a greater property assessment value.
     * @param other the object to be compared.
     * @return 0: If both assessment values are equal.
     *         >0: If the current assessment value is greater than the other.
     *         <0: If the current assessment value is less than the other.
     */
    @Override
    public int compareTo(Record other) {
        return Double.compare(this.assessmentValue, other.assessmentValue);
    }



    /**
     * Creates a string representation of a Record object.
     * @return The string representation of a Record object.
     */
    @Override
    public String toString() {
        return  "\nAccount Number = " + this.accountID +
                "\nHouse Address = " + this.aHouse +
                "\nAssessed Value = " + Conversions.convertToDollarValue(this.assessmentValue) +
                "\nAssessment Class = " + this.assessmentClass +
                "\nNeighbourhood = " + this.aWard +
                "\nLocation = " + geography;
    }



    /**
     * Determines if a Record object is equal to another object.
     * @param obj: The other object to be compared against.
     * @return True: If both the current Record object and the obj parameter point to the same memory location
     *         True: If the accountID fields of the current Record object and the typecast to
     *               Record obj are equal.
     *         False: If the obj parameter is not an instance of the Record class.
     *         False: If the accountID field of the current Record object and the typecast to
     *                Record obj are not equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Record record)) {
            return false;
        }

        return (this.accountID == record.accountID);
    }



    /**
     * Creates an integer hash value of the unique accountID value.
     * @return The integer value that the Objects.Hash method makes of the accountID.
     */
    @Override
    public int hashCode() {
        return Objects.hash(accountID);
    }
}
