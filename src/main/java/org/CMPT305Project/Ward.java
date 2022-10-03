package org.CMPT305Project;

import java.util.Objects;

/**
 *
 */
public class Ward {
    private final String wardName;
    private final Neighbourhood aNeighbourhood;

    /**
     *
     * @param wardName
     * @param aNeighbourhood
     */
    public Ward(String wardName, Neighbourhood aNeighbourhood){
        this.wardName = wardName;
        this.aNeighbourhood = aNeighbourhood;
    }


    /**
     *
     * @return
     */
    public String getWardName(){
        return this.wardName;
    }

    /**
     *
     * @return
     */
    public Neighbourhood getaNeighbourhood(){
        return this.aNeighbourhood;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "(" + this.wardName + "), " + aNeighbourhood;
    }

    /**
     *
     * @param obj
     * @return
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
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(wardName, aNeighbourhood);
    }
}
