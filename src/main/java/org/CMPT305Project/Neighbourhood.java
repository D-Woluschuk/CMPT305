package org.CMPT305Project;

import java.util.Objects;

public class Neighbourhood {
    private int neighbourhoodId;
    private String neighbourhoodName;


    public Neighbourhood(int neighId, String neighName){

        this.neighbourhoodId = neighId;
        this.neighbourhoodName = neighName;
    }

    @Override
    public String toString() {
        return "(" + this.neighbourhoodId + ") " + this.neighbourhoodName;
    }

    public int getNeighbourhoodId(){
        return this.neighbourhoodId;
    }

    public String getNeighbourhoodName(){
        return this.neighbourhoodName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (!(obj instanceof Neighbourhood neigh))
            return false;

        return neigh.neighbourhoodId == (this.neighbourhoodId);

    }

    @Override
    public int hashCode() {
        return Objects.hash(neighbourhoodId);
    }
}
