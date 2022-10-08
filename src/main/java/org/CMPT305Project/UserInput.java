package org.CMPT305Project;

import java.util.Scanner;


/**
 * This class is a helper class to the client program to assist in gathering user input from the terminal
 */
class UserInput {


    /**
     * Gathers user input through STDIN to be used by the client program.
     * @return userInput: A string that represents the users input through STDIN
     */
    static String getUserInput () {
        Scanner input = new Scanner(System.in);
        String userInput;

        userInput = input.nextLine();

        return userInput;
    }


    /**
     * Uses the getUserInput method to gather the csv filename required for the client programs.
     * @return A call to getUserInput to gather the input.
     */
    static String getFileName(){
        System.out.print("CSV filename: ");

        return getUserInput();
    }

}
