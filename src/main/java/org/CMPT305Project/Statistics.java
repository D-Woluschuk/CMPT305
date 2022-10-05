package org.CMPT305Project;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Provides methods to calculate statistical data about a list of Record objects.
 */
public class Statistics {

    /**
     * Determines the number of Record objects within the list.
     * @param fileContents: The list of record objects.
     * @return entryCount: The number of Record objects within the fileContents list.
     */
    public static int getNumberOfEntries(List<Record> fileContents){
        int entryCount;

        entryCount = fileContents.size();

        return entryCount;
    }


    /**
     * Determines the highest assessed value from a list of Record objects.
     * @param data: The list of record objects.
     * @return maxValue: The highest assessed property value found in the list of Record objects.
     */
    public static double highestAssessedValue(List<Record> data){

        if (data.size() == 0){
            return 0;
        }
        Record firstLine = data.get(0);
        double maxValue = firstLine.getAssessedValue();

        //This loop finds the largest of two assessment values and assigns the larger value to maxValue.
        for (Record line: data) {
            double aValue = line.getAssessedValue();

            if (aValue > maxValue){
                maxValue = aValue;
            }
        }
        return maxValue;
    }

    /**
     * Finds the lowest assessed property value from a list of Record objects.
     * @param data: The list of record objects.
     * @return minValue: The smallest assessed property value that was found in the list of record objects.
     */
    public static double lowestAssessedValue(List<Record> data){

        if (data.size() == 0){
            return 0;
        }
        Record firstLine = data.get(0);
        double minValue = firstLine.getAssessedValue();

        //This loop finds which value is smaller, and assigns the smaller value to minValue.
        for (Record line : data){
            double aValue = line.getAssessedValue();
            if (aValue < minValue){
                minValue = aValue;
            }
        }
        return minValue;

    }

    /**
     * Finds the range of property assessment values within a list of Record objects.
     * @param data: The list of record objects.
     * @return The highest assessed value minus the lowest assessed value found.
     */
    public static double assessedValueRange(List<Record> data){

        double highestValue = highestAssessedValue(data);
        double lowestValue = lowestAssessedValue(data);

        return highestValue - lowestValue;
    }

    /**
     * Finds the mean of the property assessment values using a list of Record objects.
     * @param recordsList: The list of record objects.
     * @return The sum of all property assessment values divided by the total number of entries.
     */
    public static double assessedValueMean(List<Record> recordsList){
        int size = recordsList.size();

        if (size == 0){
            return 0;
        }
        double assessedSum = 0;

        //This loop sums each records property assessment values.
        for (Record record: recordsList) {
            assessedSum += (record.getAssessedValue());
        }

        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        double result = assessedSum / size;
        result = Double.parseDouble(decimalFormat.format(result));

        return result;
    }

    /**
     * Determines the median of a list of Record objects by first ordering them by property assessment
     * values.
     * @param recordsList: The unordered list of record objects.
     * @return median: The median property assessment value from a list of ordered Record objects.
     */
    public static double assessedValueMedian(List<Record> recordsList){
        List <Double> valueList = new ArrayList<>();
        if (recordsList.size() == 0){
            return 0;
        }
        //Creating a list of assessment values.
        for (Record record: recordsList) {
            valueList.add(record.getAssessedValue());
        }

        //Sorting the list of Record objects
        valueList.sort(Comparator.naturalOrder());
        int size = valueList.size();
        double median;

        //If the number of records is an even number, we have to average the two middle values.
        if ((size % 2) == 0){
            double value1 = valueList.get((size/2) - 1);
            double value2 = valueList.get(size/2);

            median = (value1 + value2) / 2;
        }

        //The number of entries is odd, so we can just find the middle item and return that.
        else {
            median = valueList.get(size/2);
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return Double.parseDouble(decimalFormat.format(median));
    }
}
