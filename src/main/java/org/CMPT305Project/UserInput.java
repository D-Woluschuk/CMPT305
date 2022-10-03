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
        System.out.print("CSV filename: ");

        return getUserInput();
    }

}
