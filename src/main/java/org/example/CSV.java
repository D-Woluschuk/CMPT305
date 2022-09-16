package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;



public class CSV {

    //String filePath = "C:\\Users\\wolus\\Desktop\\Property_Assessment_Data_2022.csv";


    public static boolean checkFile(String pathToFile){
        File inputFile = new File(pathToFile);
        return inputFile.isFile();
    }

    public static String getFilePath(){
        //String filePath = "C:\\Users\\wolus\\Desktop\\stocks.csv";
        String filePath = "C:\\Users\\wolus\\Desktop\\Property_Assessment_Data_2022.csv";
        //String filePath = "/Users/dylanwoluschuk/Desktop/Property_Assessment_Data_2022.csv";


        //Scanner input = new Scanner(System.in);
        //System.out.println("Enter filename, including path: ");
        //filePath = input.nextLine();
        //System.out.println("File path entered is: " + filePath);

        return filePath;
    }

    public static ArrayList<String[]> readCSV(String pathToFile) throws IOException {

        String line;

        BufferedReader input = Files.newBufferedReader(Paths.get(pathToFile));

        //To remove header
        input.readLine();

        ArrayList<String[]> aLine = new ArrayList<>();

        while ((line = input.readLine()) != null) {
            String [] splitLine = line.split(",");
            aLine.add(splitLine);
        }

        input.close();

        return aLine;
    }


    public static void printData(ArrayList<String[]> data){


        for (String[] row: data) {
            System.out.println(row[0]);
            System.out.println(row[1]);
            System.out.println(row[2]);
            System.out.println(row[3]);
            System.out.println(row[4]);
            System.out.println(row[5]);
            System.out.println(row[6]);
            System.out.println(row[7]);
            System.out.println();
        }

    }








}
