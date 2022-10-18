package org.CMPT305ProjectM2;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class Lab2Main {

    /**
     * The client program gathers the file name specified by the user input, then checks to see
     * if the file exists. It then attempts to read the file and populate a list of Record objects
     * that is then used to display various statistical information about the data set.
     * @param args: The command line arguments passed in from the terminal.
     */
    public static void main(String[] args) {

        String filePath = UserInput.getFileName();
        CSVPropertyAssessmentDAO csvDAO = new CSVPropertyAssessmentDAO(filePath);
        allAssessmentsInfo(csvDAO);
        accountStatistics(csvDAO);
        neighStatistics(csvDAO);
    }


    /**
     * Displays statistical information about the entire data set read from the user specified csv file.
     * @param propAssessmentDAO:
     */
    private static void allAssessmentsInfo(PropertyAssessmentDAO propAssessmentDAO){

        List<Record> fileContents = propAssessmentDAO.getAll();

        System.out.println("Descriptive statistics of all property assessments");

        displayStatistics(fileContents);
    }

    /**
     * Displays statistical information about the user specified account number where a Record object has
     * the same account number in the user specified csv file.
     * @param propAssessmentDAO:
     */
    private static void accountStatistics(PropertyAssessmentDAO propAssessmentDAO){

        System.out.print("\nFind a property assessment by account number: ");
        Scanner input = new Scanner(System.in);
        int userInput = input.nextInt();

        Record aRecord = propAssessmentDAO.getByAccountNumber(userInput);

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
     * @param propAssessmentDAO:
     */
    private static void neighStatistics(PropertyAssessmentDAO propAssessmentDAO){

        System.out.print("\nNeighbourhood: ");
        String input = UserInput.getUserInput();
        List<Record> neighSearch = propAssessmentDAO.getByNeighbourhood(input);
        displayStatistics(neighSearch);

    }


    private static void displayStatistics(List<Record> fileContents){


        System.out.println("Count = " + fileContents.size());

        System.out.println("Min = " + Conversions.convertToDollarValue(Statistics.lowestAssessedValue(fileContents)));

        System.out.println("Max = " + Conversions.convertToDollarValue(Statistics.highestAssessedValue(fileContents)));

        System.out.println("Range = " + Conversions.convertToDollarValue(Statistics.assessedValueRange(fileContents)));

        System.out.println("Mean = " + Conversions.convertToDollarValue(Statistics.assessedValueMean(fileContents)));

        System.out.println("Median = " + Conversions.convertToDollarValue(Statistics.assessedValueMedian(fileContents)));

    }


}