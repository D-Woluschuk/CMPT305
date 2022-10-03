package org.CMPT305Project;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 */
public class Statistics {

    /**
     *
     * @param fileContents
     * @return
     */
    public static int getNumberOfEntries(List<Record> fileContents){
        int entryCount;

        entryCount = fileContents.size();

        return entryCount;
    }


    /**
     *
     * @param data
     * @return
     */
    public static double highestAssessedValue(List<Record> data){

        Record firstLine = data.get(0);
        double maxValue = firstLine.getAssessedValue();

        for (Record line: data) {
            double aValue = line.getAssessedValue();

            if (aValue > maxValue){
                maxValue = aValue;

            }

        }
        return maxValue;
    }

    /**
     *
     * @param data
     * @return
     */
    public static double lowestAssessedValue(List<Record> data){


        Record firstLine = data.get(0);
        double minValue = firstLine.getAssessedValue();
        for (Record line : data){
            double aValue = line.getAssessedValue();
            if (aValue < minValue){
                minValue = aValue;
            }
        }
        return minValue;

    }

    /**
     *
     * @param data
     * @return
     */
    public static double assessedValueRange(List<Record> data){

        double highestValue = highestAssessedValue(data);
        double lowestValue = lowestAssessedValue(data);

        return highestValue - lowestValue;
    }

    /**
     *
     * @param recordsList
     * @return
     */
    public static double assessedValueMean(List<Record> recordsList){
        int size = recordsList.size();
        double assessedSum = 0;
        for (Record record: recordsList) {
            assessedSum += (record.getAssessedValue());

        }

        return assessedSum / size;
    }

    /**
     *
     * @param recordsList
     * @return
     */
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
