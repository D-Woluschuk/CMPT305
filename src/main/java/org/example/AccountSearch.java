package org.example;

import java.util.List;
import java.util.Scanner;

public class AccountSearch {

    public static Record accountSearch(String anAccNumber, List<Record> recordList){
        if (!accountInputCheck(anAccNumber)){
            System.out.println("Error: invalid account number...\nSorry, account number not found");
            return null;
        }
        for (Record record: recordList) {
            if (record.getAccountID() == Record.convertAccNum(anAccNumber)){
                return record;
            }
        }

        return null;
    }

    public static boolean accountInputCheck(String anAccNumber){

        return !anAccNumber.matches("[a-zA-Z]+");

    }

}
