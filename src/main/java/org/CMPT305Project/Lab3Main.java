package org.CMPT305Project;

import java.io.IOException;
import java.util.List;

/**
 *
 */
public class Lab3Main {

    /**
     *
     * @param args: Command line arguments
     * @throws IOException: If there is an issue finding, opening, or reading the file
     *                      specified by the user.
     */
    public static void main(String[] args) throws IOException {

        String filePath = UserInput.getFileName();
        boolean fileCheck = CSV.checkFile(filePath);

        System.out.print("Assessment Class: ");
        String input = UserInput.getUserInput();
        System.out.println("Statistics (assessment class = " + input + ")");

        if (fileCheck){
            List<Record> fileContents = CSV.readCSV(filePath);
            List<Record> searchResults = AssessmentSearch.searchByAssessment(input, fileContents);
            assessmentClassInfo(searchResults);
        }
        else {
            System.out.println("Could not find the file!\n Please try again!");
        }
    }

    private static void assessmentClassInfo(List<Record> searchResults){
        if (searchResults.size() != 0) {
            System.out.println("Count = " + Statistics.getNumberOfEntries(searchResults));

            System.out.println("Min = " + Conversions.convertToDollarValue(Statistics.lowestAssessedValue(searchResults)));

            System.out.println("Max = " + Conversions.convertToDollarValue(Statistics.highestAssessedValue(searchResults)));

            System.out.println("Range = " + Conversions.convertToDollarValue(Statistics.assessedValueRange(searchResults)));

            System.out.println("Mean = " + Conversions.convertToDollarValue(Statistics.assessedValueMean(searchResults)));

            System.out.println("Median = " + Conversions.convertToDollarValue(Statistics.assessedValueMedian(searchResults)));
        }
        else{
            System.out.println("Data not found.");
        }
    }
}
