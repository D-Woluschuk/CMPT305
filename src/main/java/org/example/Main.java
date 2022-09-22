package org.example;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        String filePath;
        boolean fileCheck;
        List<Record> fileContents;
        int size;

        filePath = CSV.getFilePath();
        fileCheck = CSV.checkFile(filePath);

        if (fileCheck){
            fileContents = CSV.readCSV(filePath);

            //System.out.println(fileContents.get(2));
            System.out.println("Descriptive statistics of all property assessments");
            size = Statistics.getNumberOfEntries(fileContents);
            System.out.println("Number of entries: " + size);
            double maxValue = Statistics.highestAssessedValue(fileContents);
            System.out.println("The highest assessed value is: $" + BigDecimal.valueOf(maxValue).setScale(2, RoundingMode.HALF_UP));
            double minValue = Statistics.lowestAssessedValue(fileContents);
            System.out.println("The lowest assessed value is: $" + BigDecimal.valueOf(minValue).setScale(2, RoundingMode.HALF_UP));
            double rangeValue = Statistics.assessedValueRange(maxValue, minValue);
            System.out.println("The range of assessed values is: $" + BigDecimal.valueOf(rangeValue).setScale(2, RoundingMode.HALF_UP));

            double meanValue = Statistics.assessedValueMean(fileContents);
            System.out.println("The mean of assessed values is: $" + BigDecimal.valueOf(meanValue).setScale(2, RoundingMode.HALF_UP));
            double medianValue = Statistics.assessedValueMedian(fileContents);
            System.out.println("The median of the assessed values is: $" + BigDecimal.valueOf(medianValue).setScale(2, RoundingMode.HALF_UP));
            System.out.print("Find a property assessment by account number: ");
            String input = UserInput.getUserInput();
            Record aRecord = AccountSearch.accountSearch(input, fileContents);
            if (aRecord != null){
                System.out.println(aRecord);
            }
            else {
                System.out.println("Sorry, the account number not found.");
            }
            //CSV.printData(fileContents);
        }

        else {
            System.out.println("Could not find the file!\n Please try again!");
        }

    }


}