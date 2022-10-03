package org.CMPT305Project;

import java.util.Objects;

/**
 *
 */
public class Neighbourhood {
    private final int neighbourhoodId;
    private final String neighbourhoodName;

    /**
     *
     * @param neighId
     * @param neighName
     */
    public Neighbourhood(int neighId, String neighName){

        this.neighbourhoodId = neighId;
        this.neighbourhoodName = neighName;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "(" + this.neighbourhoodId + ") " + this.neighbourhoodName;
    }

    /**
     *
     * @return
     */
    public int getNeighbourhoodId(){
        return this.neighbourhoodId;
    }

    /**
     *
     * @return
     */
    public String getNeighbourhoodName(){
        return this.neighbourhoodName;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (!(obj instanceof Neighbourhood neigh))
            return false;

        return neigh.neighbourhoodId == (this.neighbourhoodId);

    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(neighbourhoodId);
    }
}
