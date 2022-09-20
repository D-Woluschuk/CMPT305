package org.example;

public class Ward {
    private String wardName;
    private Neighbourhood aNeighbourhood;

    public Ward(String wardName, Neighbourhood aNeighbourhood){
        this.wardName = wardName;
        this.aNeighbourhood = aNeighbourhood;
    }

    @Override
    public String toString() {
        return "(" + this.wardName + "), " + aNeighbourhood;
    }
}
