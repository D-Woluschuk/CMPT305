package org.example;

import java.util.Scanner;

public class UserInput {

    public static String getUserInput () {
        Scanner input = new Scanner(System.in);
        String userInput;
        userInput = input.nextLine();

        return userInput;
    }

}
