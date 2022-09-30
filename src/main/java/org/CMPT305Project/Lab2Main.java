package org.CMPT305Project;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;


public class Lab2Main {
    public static void main(String[] args) throws IOException {

        String filePath = UserInput.getFileName();
        boolean fileCheck = CSV.checkFile(filePath);

        if (fileCheck){
            List<Record> fileContents = CSV.readCSV(filePath);
            allAssessmentsInfo(fileContents);
            accountStatistics(fileContents);
            neighStatistics(fileContents);
        }

        else {
            System.out.println("Could not find the file!\n Please try again!");
        }

    }




    public static void allAssessmentsInfo(List<Record> fileContents){
        int size;

        System.out.println("Descriptive statistics of all property assessments");

        size = Statistics.getNumberOfEntries(fileContents);
        System.out.println("Number of entries: " + size);

        double maxValue = Statistics.highestAssessedValue(fileContents);
        System.out.println("The highest assessed value is: $" + BigDecimal.valueOf(maxValue).setScale(2, RoundingMode.HALF_UP));

        double minValue = Statistics.lowestAssessedValue(fileContents);
        System.out.println("The lowest assessed value is: $" + BigDecimal.valueOf(minValue).setScale(2, RoundingMode.HALF_UP));

        double rangeValue = Statistics.assessedValueRange(fileContents);
        System.out.println("The range of assessed values is: $" + BigDecimal.valueOf(rangeValue).setScale(2, RoundingMode.HALF_UP));

        double meanValue = Statistics.assessedValueMean(fileContents);

        System.out.println("The mean of assessed values is: $" + BigDecimal.valueOf(meanValue).setScale(2, RoundingMode.HALF_UP));
        double medianValue = Statistics.assessedValueMedian(fileContents);
        System.out.println("The median of the assessed values is: $" + BigDecimal.valueOf(medianValue).setScale(2, RoundingMode.HALF_UP));
    }

    public static void accountStatistics(List<Record> fileContents){
        String input;
        System.out.print("Find a property assessment by account number: ");
        input = UserInput.getUserInput();
        Record aRecord = AccountSearch.accountSearch(input, fileContents);
        if (aRecord != null){
            System.out.println(aRecord);
        }
        else {
            System.out.println("Error: invalid account number...\nSorry, account number not found");
        }

    }

    public static void neighStatistics(List<Record> fileContents){
        System.out.print("Neighbourhood: ");
        String input = UserInput.getUserInput();
        List<Record> neighSearch = NeighbourhoodSearch.neighbourhoodSearch(input, fileContents);
        if (neighSearch != null){
            System.out.println("Count = " + neighSearch.size());
            System.out.println("min = " + Statistics.lowestAssessedValue(neighSearch));
            System.out.println("max = " + Statistics.highestAssessedValue(neighSearch));
            System.out.println("range = " + Statistics.assessedValueRange(neighSearch));
            System.out.println("mean = " + Statistics.assessedValueMean(neighSearch));
            System.out.println("median = " + Statistics.assessedValueMedian(neighSearch));

        }
        else {
            System.out.println("Data not found");
        }
    }


}