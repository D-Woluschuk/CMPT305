package org.CMPT305Project;

import java.util.Objects;

/**
 * This class creates a Ward object to be stored within a Record object. A ward consists of a ward name,
 * and a neighbourhood object.
 */
public class Ward {
    private String wardName;
    private Neighbourhood aNeighbourhood;

    /**
     * The constructor for a Ward object, where each ward object consists of a Ward Name and a Neighbourhood object.
     * @param wardName: A string that represents the Wards name in the csv file to be read.
     * @param aNeighbourhood: A neighbourhood object that is created before the Ward object creation.
     */
    public Ward(String wardName, Neighbourhood aNeighbourhood){
        this.wardName = wardName;
        this.aNeighbourhood = aNeighbourhood;
    }


    /**
     * An accessor method that retrieves the Ward name for a Ward object.
     * @return wardName: The wards name.
     */
    public String getWardName(){
        return this.wardName;
    }



    /**
     * An accessor method that retrieves the Neighbourhood object for a Ward object.
     * @return aNeighbourhood: The neighbourhood object that consists of a neighbourhood name, and neighbourhood id.
     */
    public Neighbourhood getaNeighbourhood(){
        return this.aNeighbourhood;
    }



    /**
     * Creates a string representation of a Ward object of the format: "(wardName), aNeighbourhood"
     * so that it can be displayed to stdout.
     * An example: "(Dene Ward), (2500) Matt Berry"
     * @return A string representation of a Ward object.
     */
    @Override
    public String toString() {
        return "(" + this.wardName + "), " + aNeighbourhood;
    }



    /**
     * Determines if two Ward objects are equal or not.
     * @param obj: The object that is used to determine if it equals the current Ward object.
     * @return True: If both the current Ward object and the obj parameter point to the same memory location
     *         True: If both the wardName and neighbourhood fields of the current Ward object and the typecast to
     *         Ward obj are equal.
     *         False: If the obj parameter is not an instance of the Ward class.
     *         False: If either the wardName or neighbourhood fields of the current Ward object and the typecast to
     *      *         Ward obj are not equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Ward ward))
            return false;

        return ward.wardName.equals(this.wardName) && ward.aNeighbourhood.equals(this.aNeighbourhood);
    }



    /**
     * Creates an integer hash value of the wardName, and aNeighbourhood fields.
     * @return The integer value that the Objects.Hash method makes of the wardName and
     * aNeighbourhood fields of a Ward object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(wardName, aNeighbourhood);
    }
}
