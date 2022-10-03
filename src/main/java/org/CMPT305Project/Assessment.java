package org.CMPT305Project;

import java.util.Objects;

/**
 *
 */
public class Assessment {
    private double assessmentPercent;

    private String assessmentClass;

    /**
     *
     * @param assessmentClass
     * @param assessmentPercent
     */
    public Assessment(String assessmentClass, double assessmentPercent){
        this.assessmentClass = assessmentClass;
        this.assessmentPercent = assessmentPercent;
    }

    /**
     *
     * @return
     */
    public String getAssessmentClass() {
        return this.assessmentClass;
    }

    /**
     *
     * @return
     */
    public double getAssessmentPercent() {
        return this.assessmentPercent;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(assessmentClass, assessmentPercent);
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

        if (!(obj instanceof Assessment assessment))
            return false;

        return assessment.assessmentClass.equals(this.assessmentClass) &&
                assessment.assessmentPercent == this.assessmentPercent;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return this.assessmentClass + ": " + this.assessmentPercent + "%";
    }


}
