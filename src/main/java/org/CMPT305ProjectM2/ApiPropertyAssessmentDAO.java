package org.CMPT305ProjectM2;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApiPropertyAssessmentDAO implements PropertyAssessmentDAO {

    @Override
    public Record getByAccountNumber(int accountNumber){
        get();
        return null;
    }

    @Override
    public List<Record> getByNeighbourhood(String neighbourhood){
        return null;
    }

    @Override
    public List<Record> getByAssessmentClass(String assessmentClass){
        return null;
    }

    @Override
    public List<Record> getAll(){
        return null;
    }

    public void get(){
        System.out.println("Enter acc num: ");
        Scanner scanner = new Scanner(System.in);
        int accNum = scanner.nextInt();

        String endpoint = "https://data.edmonton.ca/resource/q7d6-ambg.csv";
        String query = endpoint + "?account_number=" + accNum;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(query))
                .GET()
                .build();


        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            List<String> result = new ArrayList<>();
            String aResult = response.body();
            aResult = aResult.replaceAll("\"", "");
            String [] form = response.body().split(",");
            for (String a: form) {
                a = a.replaceAll("\"", "");
            }



        }catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
