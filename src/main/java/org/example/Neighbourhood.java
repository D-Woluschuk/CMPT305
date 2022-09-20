package org.example;

public class Neighbourhood {
    private String neighbourhoodId;
    private String neighbourhoodName;


    public Neighbourhood(String neighId, String neighName){

        this.neighbourhoodId = neighId;
        this.neighbourhoodName = neighName;
    }

    @Override
    public String toString() {
        return "(" + this.neighbourhoodId + ") " + this.neighbourhoodName;
    }
}
