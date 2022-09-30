package org.CMPT305Project;

import java.util.List;

public class AccountSearch {

    public static Record accountSearch(String anAccNumber, List<Record> recordList){
        if (!accountInputCheck(anAccNumber)){
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

        return anAccNumber.matches("[a-zA-Z]+");

    }

}
