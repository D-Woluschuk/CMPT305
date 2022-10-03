package org.CMPT305Project;

import java.io.IOException;
import java.util.List;


public class Lab2Main {

    /**
     *
     * @param args
     * @throws IOException
     */
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
            System.out.println("Could not find the file!\nPlease try again!");
        }

    }


    /**
     *
     * @param fileContents
     */
    private static void allAssessmentsInfo(List<Record> fileContents){

        System.out.println("Descriptive statistics of all property assessments");

        System.out.println("Count = " + Statistics.getNumberOfEntries(fileContents));

        System.out.println("Min = " + Conversions.convertToDollarValue(Statistics.lowestAssessedValue(fileContents)));

        System.out.println("Max = " + Conversions.convertToDollarValue(Statistics.highestAssessedValue(fileContents)));

        System.out.println("Range = " + Conversions.convertToDollarValue(Statistics.assessedValueRange(fileContents)));

        System.out.println("Mean = " + Conversions.convertToDollarValue(Statistics.assessedValueMean(fileContents)));

        System.out.println("Median = " + Conversions.convertToDollarValue(Statistics.assessedValueMedian(fileContents)));
    }

    /**
     *
     * @param fileContents
     */
    private static void accountStatistics(List<Record> fileContents){
        String input;
        System.out.print("\nFind a property assessment by account number: ");
        input = UserInput.getUserInput();
        Record aRecord = AccountSearch.accountSearch(input, fileContents);
        if (aRecord != null){
            System.out.println(aRecord);
        }
        else {
            System.out.println("Error: invalid account number...\nSorry, account number not found");
        }

    }

    /**
     *
     * @param fileContents
     */
    private static void neighStatistics(List<Record> fileContents){
        System.out.print("\nNeighbourhood: ");
        String input = UserInput.getUserInput();
        List<Record> neighSearch = NeighbourhoodSearch.neighbourhoodSearch(input, fileContents);
        if (neighSearch != null){

            System.out.println("Count = " + neighSearch.size());

            System.out.println("Min = " + Conversions.convertToDollarValue(Statistics.lowestAssessedValue(neighSearch)));

            System.out.println("Max = " + Conversions.convertToDollarValue(Statistics.highestAssessedValue(neighSearch)));

            System.out.println("Range = " + Conversions.convertToDollarValue(Statistics.assessedValueRange(neighSearch)));

            System.out.println("Mean = " + Conversions.convertToDollarValue(Statistics.assessedValueMean(neighSearch)));

            System.out.println("Median = " + Conversions.convertToDollarValue(Statistics.assessedValueMedian(neighSearch)));

        }
        else {
            System.out.println("Data not found.");
        }
    }


}