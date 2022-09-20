package org.example;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


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

            System.out.println(fileContents.get(2));
            //size = Statistics.getNumberOfEntries(fileContents);
            //System.out.println("Number of entries: " + size);
            BigDecimal maxValue = Statistics.highestAssessedValue(fileContents);
            System.out.println("The highest assessed value is: " + maxValue);
            //BigDecimal minValue = Statistics.lowestAssessedValue(fileContents);
            //System.out.println("The lowest assessed value is: " + minValue);
            //CSV.printData(fileContents);
        }

        else {
            System.out.println("Could not find the file!\n Please try again!");
        }

    }
}