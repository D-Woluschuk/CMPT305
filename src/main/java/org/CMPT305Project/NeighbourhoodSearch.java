package org.CMPT305Project;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by a client program to find all Record objects where each Record has the same name as a
 * user inputted value.
 */
public class NeighbourhoodSearch {

    /**
     * Finds all Record objects where each Record has the same neighbourhood name as a user inputted value.
     * @param aNeighbourhood: The user inputted neighbourhood name to be searched for.
     * @param recordList: The list of all Record objects collected from reading the csv file.
     * @return A list of Record objects where each element contains the same neighbourhood name as the
     *         user inputted value.
     */
    public static List<Record> neighbourhoodSearch(String aNeighbourhood, List<Record> recordList){

        List<Record> neighRecords = new ArrayList<>();

        //This loop finds a neighbourhood name from each record and compares it to the user inputted name.
        for (Record aRecord : recordList){

            //If they match, we add the record with that neighbourhood name to neighRecords.
            if ((aNeighbourhood.equalsIgnoreCase(aRecord.getNeighbourhood().getNeighbourhoodName()))){
                neighRecords.add(aRecord);

            }
        }
        return neighRecords;
    }

}
