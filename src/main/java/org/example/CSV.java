package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class CSV {

    public static boolean checkFile(String pathToFile){
        File inputFile = new File(pathToFile);
        return inputFile.isFile();
    }

    public static List<Record> readCSV(String pathToFile) throws IOException {

        String line;

        BufferedReader input = Files.newBufferedReader(Paths.get(pathToFile));

        //To remove header
        input.readLine();

        List<Record> recordList = new ArrayList<>();


        while ((line = input.readLine()) != null) {
            String[] splitLine = line.split(",");
            int accNum = Conversions.convertAccNum(splitLine[0]);

            House aHouse = new House(splitLine[1], splitLine[2], splitLine[3], splitLine[4]);
            Neighbourhood aNeigh = new Neighbourhood(splitLine[5], splitLine[6]);
            Ward aWard = new Ward(splitLine[7], aNeigh);

            double value = Conversions.convertAssessedValue(splitLine[8]);

            double lat = Conversions.convertLatitude(splitLine[9]);
            double longitude = Conversions.convertLongitude(splitLine[10]);

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

}
