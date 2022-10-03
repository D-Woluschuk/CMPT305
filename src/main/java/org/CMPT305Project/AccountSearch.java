package org.CMPT305Project;

import java.util.List;

/**
 *
 */
public class AccountSearch {

    /**
     *
     * @param anAccNumber
     * @param recordList
     * @return
     */
    public static Record accountSearch(String anAccNumber, List<Record> recordList){
        if (!accountInputCheck(anAccNumber)){
            return null;
        }

        for (Record record: recordList) {
            if (record.getAccountID() == Conversions.convertAccNum(anAccNumber)){
                return record;
            }
        }
        return null;
    }

    /**
     *
     * @param anAccNumber
     * @return
     */
    public static boolean accountInputCheck(String anAccNumber){
        return anAccNumber.matches("[0-9]+");
    }

}
