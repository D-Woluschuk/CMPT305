package org.CMPT305ProjectM2;


import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * This is the client program that utilizes other classes in the package to generate a list
 * of property assessment records and allow a user to search by a property's assessment class.
 */
public class Lab3Main {

    /**
     * The client program gathers user input and reads the csv file specified by user input.
     * It then searches the list of Record objects created by the CSV.readCSV method for an
     * assessment class specified by the user.
     * @param args: Command line arguments
     * @throws IOException: If there is an issue finding, opening, or reading the file
     *                      specified by the user.
     */
    public static void main(String[] args) throws IOException {


        /*String filePath = UserInput.getFileName();
        CSVPropertyAssessmentDAO csvDAO = new CSVPropertyAssessmentDAO(filePath);

        System.out.print("Assessment Class: ");
        String input = UserInput.getUserInput();
        System.out.println("Statistics (assessment class = " + input + ")");

        List<Record> searchResults = csvDAO.getByAssessmentClass(input);
        assessmentClassInfo(searchResults);*/

        PropertyAssessmentDAO dao = new ApiPropertyAssessmentDAO();
        System.out.print("Enter acc num: ");
        Scanner scanner = new Scanner(System.in);
        int accNum = scanner.nextInt();
        Record result = dao.getByAccountNumber(accNum);
        System.out.println(result);

        System.out.println("Enter neighbourhood: ");
        String neigh = scanner.nextLine();
        List<Record> results = dao.getByNeighbourhood(neigh);


    }

    /**
     * Displays the statistical information about the search results from the AssessmentSearch.searchByAssessment method.
     * @param searchResults: A list of Record objects that represent the records that have the assessment class
     *                     specified by the user.
     */
    private static void assessmentClassInfo(List<Record> searchResults){
        if (searchResults.size() != 0) {
            System.out.println("Count = " + Statistics.getNumberOfEntries(searchResults));

            System.out.println("Min = " + Conversions.convertToDollarValue(Statistics.lowestAssessedValue(searchResults)));

            System.out.println("Max = " + Conversions.convertToDollarValue(Statistics.highestAssessedValue(searchResults)));

            System.out.println("Range = " + Conversions.convertToDollarValue(Statistics.assessedValueRange(searchResults)));

            System.out.println("Mean = " + Conversions.convertToDollarValue(Statistics.assessedValueMean(searchResults)));

            System.out.println("Median = " + Conversions.convertToDollarValue(Statistics.assessedValueMedian(searchResults)));
        }

        //If the list does not have any records.
        else{
            System.out.println("Data not found.");
        }
    }
}
