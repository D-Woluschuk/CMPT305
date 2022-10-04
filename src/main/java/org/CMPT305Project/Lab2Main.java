package org.CMPT305Project;

import java.io.IOException;
import java.util.List;


public class Lab2Main {

    /**
     * The client program gathers the file name specified by the user input, then checks to see
     * if the file exists. It then attempts to read the file and populate a list of Record objects
     * that is then used to display various statistical information about the data set.
     * @param args: The command line arguments passed in from the terminal.
     * @throws IOException: If there is an issue finding, opening, or reading the file
     *                      specified by the user.
     */
    public static void main(String[] args) throws IOException {

        String filePath = UserInput.getFileName();
        boolean fileCheck = CSV.checkFile(filePath);

        if (fileCheck){
            List<Record> fileContents = CSV.readCSV(filePath);
            if (fileContents.size() == 0){
                System.out.println("The file has no data.");
                return;
            }
            allAssessmentsInfo(fileContents);
            accountStatistics(fileContents);
            neighStatistics(fileContents);
        }

        else {
            System.out.println("Could not find the file!\nPlease try again!");
        }

    }


    /**
     * Displays statistical information about the entire data set read from the user specified csv file.
     * @param fileContents: A list of Record objects that is used to calculate the statistical information.
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
     * Displays statistical information about the user specified account number where a Record object has
     * the same account number in the user specified csv file.
     * @param fileContents: The list of Record objects to be searched for the user specified account id.
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
     * Displays statistical information about the user specified neighbourhood where each Record object has the
     * same neighbourhood name in the user specified csv file.
     * @param fileContents: The list of Record objects to be searched for the user specified neighbourhood.
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