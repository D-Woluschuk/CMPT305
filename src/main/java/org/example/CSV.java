package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


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

    public static List<Record> readCSV(String pathToFile) throws IOException {

        String line;

        BufferedReader input = Files.newBufferedReader(Paths.get(pathToFile));

        //To remove header
        input.readLine();

        //ArrayList<String[]> aLine = new ArrayList<>();
        List<Record> recordList = new ArrayList<>();


        while ((line = input.readLine()) != null) {
            String[] splitLine = line.split(",");
            int accNum = Record.convertAccNum(splitLine[0]);

            House aHouse = new House(splitLine[1], splitLine[2], splitLine[3], splitLine[4]);
            Neighbourhood aNeigh = new Neighbourhood(splitLine[5], splitLine[6]);
            Ward aWard = new Ward(splitLine[7], aNeigh);

            double value = Record.assessedValue(splitLine[8]);

            double lat = Record.getLatitude(splitLine[9]);
            double longitude = Record.getLongitude(splitLine[10]);

            Geography geography = new Geography(lat, longitude);

            double percent1;
            try {
                percent1 = Double.parseDouble(splitLine[12]);

            } catch (NumberFormatException e1) {
                percent1 = 0;
            }
            double percent2;
            try {
                percent2 = Double.parseDouble(splitLine[13]);
            } catch (NumberFormatException e2) {
                percent2 = 0;
            }

            double percent3;
            try {
                percent3 = Double.parseDouble(splitLine[14]);
            } catch (NumberFormatException e3) {
                percent3 = 0;
            }
            String class1;
            try {
                class1 = splitLine[15];
            } catch (ArrayIndexOutOfBoundsException a1){
                class1 = "";
            }

            String class2;
            try {
                class2 = splitLine[16];
            } catch (ArrayIndexOutOfBoundsException a2){
                class2 = "";
            }

            String class3;
            try {
                class3 = splitLine[17];
            } catch (ArrayIndexOutOfBoundsException a3){
                class3 = "";
            }
            Assessment assessment = new Assessment(class1, class2, class3, percent1, percent2, percent3);
            Record aRecord = new Record(accNum, aHouse, aWard, value, geography, assessment);
            recordList.add(aRecord);
        }

        input.close();

        return recordList;
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
