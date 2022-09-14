package org.example;

import java.io.*;
import java.util.ArrayList;


public class CSV {

    //String filePath = "C:\\Users\\wolus\\Desktop\\Property_Assessment_Data_2022.csv";


    public static boolean checkFile(String pathToFile){
        File inputFile = new File(pathToFile);
        return inputFile.isFile();
    }

    public static String getFilePath(){
        //String filePath = "C:\\Users\\wolus\\Desktop\\Property_Assessment_Data_2022.csv";
        String filePath = "/Users/dylanwoluschuk/Desktop/Property_Assessment_Data_2022.csv";

        //Scanner input = new Scanner(System.in);
        //System.out.println("Enter filename, including path: ");
        //filePath = input.nextLine();
        //System.out.println("File path entered is: " + filePath);

        return filePath;
    }

    public static ArrayList<String> readCSV(String pathToFile) throws IOException {

        String in;
        BufferedReader input = new BufferedReader(new FileReader(pathToFile));
        in = input.readLine();
        ArrayList<String> aLine = new ArrayList<>();


        while ((in = input.readLine()) != null) {
            aLine.add(in);
        }

        input.close();

        return aLine;
    }








}
