package org.example;

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
    public String toString() {
        return this.class1 + ": " + this.percent1 + "\n" + this.class2 + ": " + this.percent2 + "\n" + this.class3 + ": " + this.percent3;
    }
}
