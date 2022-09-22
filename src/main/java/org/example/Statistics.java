package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Statistics {

    public static int getNumberOfEntries(List<Record> fileContents){
        int entryCount;

        entryCount = fileContents.size();

        return entryCount;
    }


    public static double highestAssessedValue(List<Record> data){

        Record firstLine = data.get(0);
        double maxValue = firstLine.getAssessedValue();

        for (Record line: data) {
            double aValue = line.getAssessedValue();

            if (aValue > maxValue){
                maxValue = aValue;

            }

        }
        //System.out.println("The ID of highest is: " + ID);
        return maxValue;
    }

    public static double lowestAssessedValue(List<Record> data){


        Record firstLine = data.get(0);
        double minValue = firstLine.getAssessedValue();
        for (Record line : data){
            double aValue = line.getAssessedValue();
            if (aValue < minValue){
                minValue = aValue;
                //ID = line[0];
            }
        }
        //System.out.println("The ID of the lowest valued is: " + ID);
        return minValue;

    }

    public static double assessedValueRange(double highestValue, double lowestValue){

        return highestValue - lowestValue;
    }

    public static double assessedValueMean(List<Record> recordsList){
        int size = recordsList.size();
        double assessedSum = 0;
        for (Record record: recordsList) {
            assessedSum += (record.getAssessedValue());

        }

        return assessedSum / size;
    }

    public static double assessedValueMedian(List<Record> recordsList){
        List <Double> valueList = new ArrayList<>();

        for (Record record: recordsList) {
            valueList.add(record.getAssessedValue());
        }

        valueList.sort(Comparator.naturalOrder());
        int size = valueList.size();
        double median;
        if ((size % 2) == 0){
            double value1 = valueList.get((size/2) - 1);
            double value2 = valueList.get(size/2);

            median = (value1 + value2) / 2;
        }

        else {
            median = valueList.get(size/2);
        }

        return median;
    }
}
