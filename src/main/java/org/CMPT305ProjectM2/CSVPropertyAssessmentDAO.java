package org.CMPT305ProjectM2;

import org.CMPT305Project.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVPropertyAssessmentDAO implements PropertyAssessmentDAO {

    private final String fileName;


    public CSVPropertyAssessmentDAO(String aFileName){
        this.fileName = aFileName;
    }

    @Override
    public Record getByAccountNumber(int anAccNumber){

        List<Record> recordList;
        recordList = getAll();

        for (Record record: recordList) {
            if (record.getAccountID() == anAccNumber){
                return record;
            }
        }
        return null;
    }



    @Override
    public List<Record> getByNeighbourhood(String neighbourhood){

        List<Record> recordList;

        recordList = getAll();
        List<Record> neighRecords = new ArrayList<>();

        if (recordList == null){
            return  neighRecords;
        }


        //This loop finds a neighbourhood name from each record and compares it to the user inputted name.
        for (Record aRecord : recordList){

            //If they match, we add the record with that neighbourhood name to neighRecords.
            if ((neighbourhood.equalsIgnoreCase(aRecord.getNeighbourhood().getNeighbourhoodName()))){
               neighRecords.add(aRecord);
            }
        }
        return neighRecords;
    }

    @Override
    public List<Record> getByAssessmentClass(String assessmentClass){


        List<Record> recordList;
        recordList = getAll();

        List<Record> foundRecords = new ArrayList<>();

        //This loop goes through each record
        for (Record aRecord: recordList) {

            //This loop goes through each assessment object in the record.
            for (Assessment anAssessment: aRecord.getAssessment()) {

                //If the assessment object has the same assessmentClass Name as the user inputted value
                //we add it to a list of Record objects to be returned.
                if (assessmentClass.equalsIgnoreCase(anAssessment.getAssessmentClass())){
                    foundRecords.add(aRecord);

                    //We will break since we do not need to search the other values if we
                    //already found the assessment class name we are looking for.
                    break;
                }
            }
        }
        return foundRecords;
    }

    @Override
    public List<Record> getAll() {

        try {
            return readCSV();
        } catch (IOException e) {
            System.err.println("Could not locate the file, or it could not be opened. Exiting..");
            System.exit(1);
        }
        return null;
    }



    /**
     * Determines if the pathToFile string represents a file.
     * @param pathToFile: A file name that the user inputted.
     * @return True: If the inputFile the user wants to read is actually a file
     *         False: If the inputFile the user wants to read is not a file.
     */
    public boolean checkFile(String pathToFile){
        File inputFile = new File(pathToFile);
        return inputFile.isFile();
    }

    /**
     * Attempts to read the csv file line by line. It then breaks up each line and uses each element
     * to create a Record object and add it to a list.
     * @param : The file that the user wants to read from.
     * @return recordList: A list of Record objects, where each Record object consists of the
     * data read from a line in the file.
     * @throws IOException: If the file cannot be opened, read, or found.
     */
    public List<Record> readCSV() throws IOException {


        List<Record> recordList = new ArrayList<>();

        boolean fileStatus = checkFile(fileName);
        if (!fileStatus)
            return recordList;

        String line;

        BufferedReader input = Files.newBufferedReader(Paths.get(fileName));

        try {
            //To remove header
            input.readLine();
        } catch (IOException ioException){
            System.err.println("An issue reading the file has occurred.");
            System.exit(1);
        }



        while ((line = input.readLine()) != null) {
            String[] splitLine = line.split(",");

            //If the line is less than 12 entries long, we don't have all the data needed, so we will return with what we have
            if (splitLine.length < 12){
                return recordList;
            }

            //Account Number
            int accNum = Conversions.convertAccNum(splitLine[0]);

            //Suite Number, House Number, Street, Garage
            House aHouse = new House(splitLine[1], splitLine[2], splitLine[3], splitLine[4]);

            //Neighbourhood ID, Neighbourhood Name
            Neighbourhood aNeigh = new Neighbourhood(Conversions.convertNeighbourhoodId(splitLine[5]), splitLine[6]);

            //Ward ID, Neighbourhood
            Ward aWard = new Ward(splitLine[7], aNeigh);

            //Assessed Value
            double assessedValue = Conversions.convertAssessedValue(splitLine[8]);

            //Latitude and Longitude
            double lat = Conversions.convertLatitude(splitLine[9]);
            double longitude = Conversions.convertLongitude(splitLine[10]);
            Geography geography = new Geography(lat, longitude);

            //From here the only data remaining is assessment class information.
            String [] remainderOfLine = Arrays.copyOfRange(splitLine, 12, splitLine.length);

            List<Assessment> assessmentList = createAssessment(remainderOfLine);

            //Creating the new Record object and adding it to a list.
            Record aRecord = new Record(accNum, aHouse, aWard, assessedValue, geography, assessmentList);
            recordList.add(aRecord);
        }
        input.close();
        return recordList;
    }


    /**
     *Reads the remainder of a line from a csv file and creates Assessment objects based on the
     * assessment classes a particular object has.
     * @param aLine: The remainder of a line read from the csv file.
     * @return assessmentClass: The new List of assessment objects that will be stored into a Record object.
     */
    @Override
    public List<Assessment> createAssessment(String [] aLine){
        double percentage;
        String className;
        List<Assessment> assessmentClass = new ArrayList<>();
        for (int i = 0; i < aLine.length; i++) {
            try {
                percentage = Double.parseDouble(aLine[i]);

                //Since the file format has 3 columns for class names, and 3 columns for percentages
                //once we grab the first item, we can skip ahead 3 spaces and if we get an exception,
                //we check if were at the end.
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
