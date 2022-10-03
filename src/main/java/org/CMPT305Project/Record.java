package org.CMPT305Project;

import java.util.List;
import java.util.Objects;

/**
 *
 */
public class Record implements Comparable<Record> {

    private final int accountID;

    private final House aHouse;
    private final Ward aWard;

    private final Geography geography;

    private final List<Assessment> assessmentClass;

    private final double assessmentValue;


    /**
     *
     * @param accID
     * @param aHouse
     * @param aWard
     * @param assessmentValue
     * @param geography
     * @param assessmentClass
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
     *
     * @return
     */
    public int getAccountID() {
        return this.accountID;
    }

    /**
     *
     * @return
     */
    public double getAssessedValue() {
        return this.assessmentValue;
    }

    /**
     *
     * @return
     */
    public Neighbourhood getNeighbourhood(){
        return this.aWard.getaNeighbourhood();
    }

    /**
     *
     * @return
     */
    public List<Assessment> getAssessment(){
        return this.assessmentClass;
    }

    /**
     *
     * @return
     */
    public House getaHouse() {
        return this.aHouse;
    }

    /**
     *
     * @param other the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Record other) {
        return Double.compare(this.assessmentValue, other.assessmentValue);
    }

    /**
     *
     * @return
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
     *
     * @param obj
     * @return
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
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(accountID);
    }
}
