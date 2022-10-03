package org.CMPT305Project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class CSV {

    /**
     *
     * @param pathToFile
     * @return
     */
    public static boolean checkFile(String pathToFile){
        File inputFile = new File(pathToFile);
        return inputFile.isFile();
    }

    /**
     *
     * @param pathToFile
     * @return
     * @throws IOException
     */
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

            Neighbourhood aNeigh = new Neighbourhood(Conversions.convertNeighbourhoodId(splitLine[5]), splitLine[6]);

            Ward aWard = new Ward(splitLine[7], aNeigh);

            double assessedValue = Conversions.convertAssessedValue(splitLine[8]);

            double lat = Conversions.convertLatitude(splitLine[9]);
            double longitude = Conversions.convertLongitude(splitLine[10]);

            Geography geography = new Geography(lat, longitude);

            String [] remainderOfLine = Arrays.copyOfRange(splitLine, 12, splitLine.length);

            List<Assessment> assessmentList = createAssessment(remainderOfLine);

            Record aRecord = new Record(accNum, aHouse, aWard, assessedValue, geography, assessmentList);
            recordList.add(aRecord);
        }
        input.close();
        return recordList;
    }


    /**
     *
     * @param aLine
     * @return
     */
    public static List<Assessment> createAssessment(String [] aLine){
        double percentage;
        String className;
        List<Assessment> assessmentClass = new ArrayList<>();
        for (int i = 0; i < aLine.length; i++) {
            try {
                percentage = Double.parseDouble(aLine[i]);
                className = aLine[i + 3];
                Assessment anAssessment = new Assessment(className, percentage);
                assessmentClass.add(anAssessment);

            } catch (NumberFormatException | ArrayIndexOutOfBoundsException error) {
                if (aLine[i].length() == 0) {
                    continue;

                }  else if (i + 3 > aLine.length) {
                    break;
                }
            }

        }
        return assessmentClass;
    }

}
