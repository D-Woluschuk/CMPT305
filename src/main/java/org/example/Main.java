package org.example;

import java.io.IOException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {
        String filePath;
        boolean fileCheck;
        ArrayList<String> fileContents;
        int size;
        //HashMap<Integer, Record> records = new HashMap<Integer, Record>();
        filePath = CSV.getFilePath();
        fileCheck = CSV.checkFile(filePath);
        if (fileCheck){
            fileContents = CSV.readCSV(filePath);
            size = Statistics.getNumberOfEntries(fileContents);
            System.out.println("Number of entries: " + size);
        }
        else {
            System.out.println("Could not find the file!");
        }

    }
}