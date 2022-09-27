package org.example;

import java.util.Objects;

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

    public String getNeighbourhoodId(){
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

        return neigh.neighbourhoodId.equals(this.neighbourhoodId) && neigh.neighbourhoodName.equals(this.neighbourhoodName);

    }

    @Override
    public int hashCode() {
        return Objects.hash(neighbourhoodId, neighbourhoodName);
    }
}
