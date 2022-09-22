package org.example;

import java.util.Scanner;

public class UserInput {

    public static String getUserInput () {
        Scanner input = new Scanner(System.in);
        String userInput;
        userInput = input.nextLine();

        return userInput;
    }

    public static String getFileName(){
        //String filePath = "C:\\Users\\wolus\\Desktop\\stocks.csv";
        String fileName = "C:\\Users\\wolus\\Desktop\\Property_Assessment_Data_2022.csv";
        //String filePath = "/Users/dylanwoluschuk/Desktop/Property_Assessment_Data_2022.csv";


        //Scanner input = new Scanner(System.in);
        //System.out.println("Enter filename, including path: ");
        //filePath = input.nextLine();
        //System.out.println("File path entered is: " + filePath);

        return fileName;
    }

}
