package org.CMPT305Project;

import java.util.List;
import java.util.Objects;

public class Record implements Comparable<Record> {

    private int accountID;

    private House aHouse;
    private Ward aWard;

    private Geography geography;

    private List<Assessment> assessmentClass;

    private double assessmentValue;


    public Record(int accID, House aHouse, Ward aWard, double assessmentValue, Geography geography, List<Assessment> assessmentClass) {


        this.accountID = accID;
        this.aHouse = aHouse;
        this.aWard = aWard;
        this.assessmentValue = assessmentValue;
        this.geography = geography;
        this.assessmentClass = assessmentClass;


    }


    public int getAccountID() {
        return this.accountID;
    }


    public double getAssessedValue() {
        return this.assessmentValue;
    }

    public Neighbourhood getNeighbourhood(){
        return this.aWard.getaNeighbourhood();
    }

    public List<Assessment> getAssessment(){
        return this.assessmentClass;
    }

    public House getaHouse() {
        return this.aHouse;
    }

    @Override
    public int compareTo(Record other) {
        return Double.compare(this.assessmentValue, other.assessmentValue);
    }

    @Override
    public String toString() {
        return  "\nAccount Number = " + this.accountID +
                "\nHouse Address = " + this.aHouse +
                "\nAssessed Value = " + Conversions.convertToDollarValue(this.assessmentValue) +
                "\nAssessment Class = " + this.assessmentClass +
                "\nNeighbourhood = " + this.aWard +
                "\nLocation = " + geography;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Record record)) {
            return false;
        }

        return (this.accountID == record.accountID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountID);
    }
}
