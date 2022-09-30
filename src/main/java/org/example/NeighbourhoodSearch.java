package org.example;

import java.util.ArrayList;
import java.util.List;

public class NeighbourhoodSearch {


    public static List<Record> neighbourhoodSearch(String aNeighbourhood, List<Record> recordList){

        List<Record> neighRecords = new ArrayList<>();

        for (Record aRecord : recordList){
            if ((aNeighbourhood.toUpperCase()).equals(aRecord.getNeighbourhood().getNeighbourhoodName())){
                neighRecords.add(aRecord);

            }
        }
        if (neighRecords.size() == 0){
            return null;
        }
        return neighRecords;
    }

}
