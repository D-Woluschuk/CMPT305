package org.CMPT305ProjectM2;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ApiPropertyAssessmentDAO implements PropertyAssessmentDAO {

    @Override
    public Record getByAccountNumber(int accountNumber){
        String[] results = requestData("?account_number=" + accountNumber);
        return createRecord(results);
    }

    @Override
    public List<Record> getByNeighbourhood(String neighbourhood){
        if (neighbourhood.contains(" ")){
            neighbourhood = neighbourhood.replaceAll(" ", "+");
        }
        int offset = 0;
        List<Record> neighRecords = new ArrayList<>();
        int limit = 750;
        String [] results = requestData("?$limit=" + limit + "&$offset=" + offset + "&neighbourhood=" + neighbourhood.toUpperCase());

        while (results.length != 1) {
            offset += limit;
            List<String> aLine = new ArrayList<>();
            int i;
            for (i = 0; i < results.length; i++) {

                if (results[i].contains("\n")) {

                    results[i] = results[i].replaceFirst("\n", "");
                    aLine.add(results[i]);
                    String[] anEntry = new String[aLine.size()];
                    anEntry = aLine.toArray(anEntry);
                    Record aRecord = createRecord(anEntry);
                    neighRecords.add(aRecord);
                    aLine.clear();
                }

                aLine.add(results[i]);


            }
            results = requestData("?$limit=" + limit + "&$offset=" + offset + "&neighbourhood=" + neighbourhood.toUpperCase());

        }


        return neighRecords;

    }

    @Override
    public List<Record> getByAssessmentClass(String assessmentClass){

        if (assessmentClass.contains(" ")){
            assessmentClass = assessmentClass.replaceAll(" ", "+");
        }

        List<Record> assessmentRecords = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            int offset = 0;
            int limit = 750;

            String[] results = requestData("?$limit=" + limit + "&$offset=" + offset + "&mill_class_" + i + "=" + assessmentClass.toUpperCase());

            while (results.length != 1) {

                offset += limit;
                List<String> aLine = new ArrayList<>();
                int j;
                for (j = 0; j < results.length; j++) {

                    if (results[j].contains("\n")) {

                        results[j] = results[j].replaceFirst("\n", "");
                        aLine.add(results[j]);
                        String[] anEntry = new String[aLine.size()];
                        anEntry = aLine.toArray(anEntry);
                        Record aRecord = createRecord(anEntry);
                        assessmentRecords.add(aRecord);
                        aLine.clear();
                    }
                    aLine.add(results[j]);


                }

                results = requestData("?$limit=" + limit + "&$offset=" + offset + "&mill_class_" + i + "=" + assessmentClass.toUpperCase());

            }

        }
        return assessmentRecords;

    }

    @Override
    public List<Record> getAll(){
        return null;
    }

    public Record createRecord(String [] actualData){


            //Account Number
            int accNumber = Conversions.convertAccNum(actualData[0]);
            //Suite Number, House Number, Street, Garage
            House aHouse = new House(actualData[1], actualData[2], actualData[3], actualData[4]);

            //Neighbourhood ID, Neighbourhood Name
            Neighbourhood aNeigh = new Neighbourhood(Conversions.convertNeighbourhoodId(actualData[5]), actualData[6]);

            //Ward ID, Neighbourhood
            Ward aWard = new Ward(actualData[7], aNeigh);

            //Assessed Value
            double assessedValue = Conversions.convertAssessedValue(actualData[8]);

            //Latitude and Longitude
            double lat = Conversions.convertLatitude(actualData[9]);
            double longitude = Conversions.convertLongitude(actualData[10]);
            Geography geography = new Geography(lat, longitude);

            actualData[actualData.length-1] = actualData[actualData.length-1].replaceFirst("\n", "");

            //From here the only data remaining is assessment class information.
            String [] remainderOfLine = Arrays.copyOfRange(actualData, 12, actualData.length);

            List<Assessment> assessmentList =  createAssessment(remainderOfLine);
            //Creating the new Record object and adding it to a list.

        return new Record(accNumber, aHouse, aWard, assessedValue, geography, assessmentList);
    }


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

    public String [] removeHeader(HttpResponse<String> aResponse){
        String [] form = aResponse.body().split(",");

        form[17] = form[17].substring(15);
        String [] actualData = Arrays.copyOfRange(form, 17, form.length);
        for (int i = 0; i < actualData.length; i++) {
            actualData[i] = actualData[i].replaceAll("\"", "");
            //actualData[i] = actualData[i].replaceFirst("\n", "");
        }

        return actualData;
    }

    public String [] requestData(String query){
        String endpoint = "https://data.edmonton.ca/resource/q7d6-ambg.csv";
        query = endpoint + query;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(query))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return removeHeader(response);

        }catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }
}
