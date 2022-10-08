package org.CMPT305Project;

import java.util.Objects;

/**
 * This class creates a Neighbourhood object that is to be stored within a Record object that represents a
 * property assessment entry from a csv file.
 */
public class Neighbourhood {
    private final int neighbourhoodId;
    private final String neighbourhoodName;

    /**
     * The constructor for a Neighbourhood object.
     * @param neighId: The neighbourhood id.
     * @param neighName: The corresponding name of a neighbourhood.
     */
    public Neighbourhood(int neighId, String neighName){

        this.neighbourhoodId = neighId;
        this.neighbourhoodName = neighName;
    }

    /**
     * Creates a string representation of a neighbourhood object.
     * It has the following format: "(neighbourhoodId) neighbourhoodName"
     * @return The string representation of the neighbourhood object.
     * An example: "(2450) Matt Berry"
     */
    @Override
    public String toString() {
        return "(" + this.neighbourhoodId + ") " + this.neighbourhoodName;
    }

    /**
     * An accessor method to retrieve the neighbourhood ID from the current object.
     * @return The neighbourhood ID.
     */
    public int getNeighbourhoodId(){
        return this.neighbourhoodId;
    }

    /**
     * An accessor method to retrieve the neighbourhood name from the current object.
     * @return The neighbourhood Name.
     */
    public String getNeighbourhoodName(){
        return this.neighbourhoodName;
    }


    /**
     * Determines if the current neighbourhood object equals another object.
     * @param obj: The other object to be compared against.
     * @return True: If the obj parameter and the current object point to the same memory location.
     *         True: If the neighbourhoodId field of each object are the same.
     *         False: If the obj parameter is not an instance of Neighbourhood.
     *         False: If the neighbourhoodId's of each object is not the same.
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
     * Creates an integer hash value of the neighbourhoodId field.
     * @return The integer value that the Objects.Hash method makes of the neighbourhoodId.
     */
    @Override
    public int hashCode() {
        return Objects.hash(neighbourhoodId);
    }
}
