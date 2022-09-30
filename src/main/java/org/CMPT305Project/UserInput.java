package org.CMPT305Project;

import java.util.Scanner;

public class UserInput {


    /**
     * Purpose: Gathers user input through STDIN to be used by the client program.
     * @return userInput: A string that represents the users input through STDIN
     */
    static String getUserInput () {
        Scanner input = new Scanner(System.in);
        String userInput;

        userInput = input.nextLine();
        return userInput;
    }


    /**
     *
     * @return fileName:
     */
    static String getFileName(){
        //String fileName = "C:\\Users\\wolus\\Desktop\\stocks.csv";
        String fileName = "C:\\Users\\wolus\\Desktop\\Property_Assessment_Data_2022.csv";
        //String fileName = "C:\\Users\\wolus\\Desktop\\(COPY)Property_Assessment_Data_2022.csv";
        //String fileName = "/Users/dylanwoluschuk/Desktop/Property_Assessment_Data_2022.csv";


        //Scanner input = new Scanner(System.in);
        //System.out.print("CSV filename: ");
        //String fileName = input.nextLine();
        //System.out.println("File path entered is: " + filePath);

        return fileName;
    }

}
