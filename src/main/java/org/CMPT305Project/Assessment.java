package org.CMPT305Project;

import java.util.Objects;

public class Assessment {
    private double percent1, percent2, percent3;

    private String class1, class2, class3;

    public Assessment(String class1, String class2, String class3, double percent1, double percent2, double percent3){
        this.class1 = class1;
        this.class2 = class2;
        this.class3 = class3;
        this.percent1 = percent1;
        this.percent2 = percent2;
        this.percent3 = percent3;
    }

    @Override
    public int hashCode() {
        return Objects.hash(class1, class2, class3, percent1, percent2, percent3);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Assessment assessment))
            return false;

        return assessment.class1.equals(this.class1) &&
                assessment.class2.equals(this.class2) &&
                assessment.class3.equals(this.class3) &&
                assessment.percent1 == this.percent1 &&
                assessment.percent2 == this.percent2 &&
                assessment.percent3 == this.percent3;
    }

    @Override
    public String toString() {
        return "[" + this.class1 + ": " + this.percent1 + "%, " +
                this.class2 + ": " + this.percent2 + "%, " +
                this.class3 + ": " + this.percent3 + "%]";
    }


}
