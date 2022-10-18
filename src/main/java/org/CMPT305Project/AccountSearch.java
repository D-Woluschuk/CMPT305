package org.CMPT305Project;

import org.CMPT305ProjectM2.Conversions;
import org.CMPT305ProjectM2.Record;

import java.util.List;

/**
 * This class allows a client program to search a list of property assessment records for
 * a user inputted account number.
 */
public class AccountSearch {

    /**
     *
     * @param anAccNumber: A user provided account number that is used to search the record list.
     * @param recordList: The list of Record objects that is created from the property assessment file.
     * @return Null: If the user provided account number is not valid (contains non-numerical values).
     *         Null: If the user provided account number is not found within the list of records.
     *         record: A Record object that has the same account number as the account number inputted by the user.
     */
    public static Record accountSearch(String anAccNumber, List<Record> recordList){

        //Account number is not valid. Ex: "abc", "123e", etc..
        if (!accountInputCheck(anAccNumber)){
            return null;
        }

        //The inputted account number must be converted, so it can be compared
        // against the account number in a record.
        int convertedAccNum = Conversions.convertAccNum(anAccNumber);

        //This loop takes each record from the list of records and compares the inputted account number
        //with the account number of the record in the list.
        for (Record record: recordList) {
            if (record.getAccountID() == convertedAccNum){

                //If the account number was found
                return record;
            }
        }

        //No record with the inputted account number was found.
        return null;
    }

    /**
     * Checks the user inputted account number to determine if it is valid or not.
     * @param anAccNumber: A string that represents the user inputted account number they
     *                   would like to search for in the record list.
     * @return True: If the inputted account number is a valid account number (Only numerical values)
     *         False: If the inputted account number is not valid (Contains non-numerical values)
     */
    public static boolean accountInputCheck(String anAccNumber){
        return anAccNumber.matches("[0-9]+");
    }

}
