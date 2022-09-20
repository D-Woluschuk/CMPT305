package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Statistics {

    public static int getNumberOfEntries(ArrayList<String[]> fileContents){
        int entryCount;

        entryCount = fileContents.size();

        return entryCount;
    }


    public static BigDecimal highestAssessedValue(List<Record> data){

        Record firstLine = data.get(0);
        int Id;
        BigDecimal maxValue = firstLine.getAssessedValue();

        for (Record line: data) {
            BigDecimal aValue = line.getAssessedValue();

            if (aValue.compareTo(maxValue) > 0){
                maxValue = aValue;

            }

        }
        //System.out.println("The ID of highest is: " + ID);
        return maxValue;
    }

    public static BigDecimal lowestAssessedValue(ArrayList<String[]> data){


        String [] firstLine = data.get(0);
        BigDecimal minValue = new BigDecimal(firstLine[8]);
        String ID = "";
        for (String[] line : data){
            BigDecimal aValue = new BigDecimal(line[8]);
            if (aValue.compareTo(minValue) < 0){
                minValue = aValue;
                ID = line[0];
            }
        }
        System.out.println("The ID of the lowest valued is: " + ID);
        return minValue;

    }
}
