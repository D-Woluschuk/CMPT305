package org.CMPT305ProjectM2;

import java.util.Objects;

/**
 * This class creates an Assessment object that contains the Assessment Class name, and
 * the percentage that the Assessment Class makes up out of 100% of the total assessment value.
 */
public class Assessment {
    private double assessmentPercent;

    private String assessmentClass;

    /**
     * The Assessment constructor that creates an Assessment object with an Assessment Class name,
     * and an Assessment Class percentage.
     * @param assessmentClass: The name of the Assessment Class, Ex: "Residential, Commercial"
     * @param assessmentPercent: The percentage that an Assessment Class name makes up out of 100%
     */
    public Assessment(String assessmentClass, double assessmentPercent){
        this.assessmentClass = assessmentClass;
        this.assessmentPercent = assessmentPercent;
    }

    /**
     * An accessor method that retrieves the Assessment Class name for an Assessment object.
     * @return The name of an assessment class.
     */
    public String getAssessmentClass() {
        return this.assessmentClass;
    }

    /**
     * An accessor method that retrieves the Assessment Percentage for an Assessment object.
     * @return The percentage of an assessment class.
     */
    public double getAssessmentPercent() {
        return this.assessmentPercent;
    }

    /**
     * Creates an integer hash value of the assessmentClass, and assessmentPercent fields.
     * @return The integer value that the Objects.Hash method makes of the assessmentClass and
     * assessmentPercent fields of an Assessment object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(assessmentClass, assessmentPercent);
    }

    /**
     * Determines if two Assessment objects are equal.
     * @param obj: The other object that is to be compared against to determine if two Assessment
     *           objects are equal.
     * @return True: If the two Assessment objects point to the same memory location.
     *          True: If the assessmentClass and assessmentPercent fields of the two
     *          Assessment objects have the same value.
     *          False: If the obj parameter is not an Assessment object.
     *          False: If either the assessmentClass or assessmentPercent fields of the
     *          Assessment objects are not equal.
     */
    @Override
    public boolean equals(Object obj) {
        //If both assessment objects point to the same memory location.
        if (this == obj)
            return true;

        //If obj is not an Assessment object.
        if (!(obj instanceof Assessment assessment))
            return false;

        return assessment.assessmentClass.equals(this.assessmentClass) &&
                assessment.assessmentPercent == this.assessmentPercent;
    }

    /**
     * Creates a string representation of an Assessment object of the format: "assessmentClass: assessmentPercent%"
     * so it can be displayed to stdout.
     * An example: "Residential: 100%
     * @return The string representation of an Assessment object.
     */
    @Override
    public String toString() {
        return this.assessmentClass + ": " + this.assessmentPercent + "%";
    }


}
