package org.CMPT305Project;

import java.util.Objects;

public class Ward {
    private String wardName;
    private Neighbourhood aNeighbourhood;

    public Ward(String wardName, Neighbourhood aNeighbourhood){
        this.wardName = wardName;
        this.aNeighbourhood = aNeighbourhood;
    }


    public String getWardName(){
        return this.wardName;
    }

    public Neighbourhood getaNeighbourhood(){
        return this.aNeighbourhood;
    }

    @Override
    public String toString() {
        return "(" + this.wardName + "), " + aNeighbourhood;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Ward ward))
            return false;

        return ward.wardName.equals(this.wardName) && ward.aNeighbourhood.equals(this.aNeighbourhood);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wardName, aNeighbourhood);
    }
}
