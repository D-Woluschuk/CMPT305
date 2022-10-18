package org.CMPT305Project;

import org.CMPT305ProjectM2.Conversions;
import org.CMPT305ProjectM2.Record;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountSearchTest {
    List<Record> recordList;
    List<Record> emptyList;

    List<Record> problemList;

    @BeforeEach
    void setUp() throws IOException {
        recordList = CSV.readCSV("Test_With_Entries.csv");
        emptyList = CSV.readCSV("Test_Without_Entries.csv");
        problemList = CSV.readCSV("Problem_File.csv");
    }

    @Test
    void accountSearch() {
        String accNum1 = "4220364";
        String accNum2 = "1234567890";
        String accNum3 = "abc";
        String accNum4 = "";
        Record result;


        //Testing with a csv file that has some entries
        result = AccountSearch.accountSearch(accNum1, recordList);
        assert result != null;
        int expected = Conversions.convertAccNum(accNum1);
        assertEquals(expected, result.getAccountID());

        result = AccountSearch.accountSearch(accNum2, recordList);
        assertNull(result);

        result = AccountSearch.accountSearch(accNum3, recordList);
        assertNull(result);

        result = AccountSearch.accountSearch(accNum4, recordList);
        assertNull(result);


        //Testing with an empty csv file
        result = AccountSearch.accountSearch(accNum1, emptyList);
        assertNull(result);

        result = AccountSearch.accountSearch(accNum2, emptyList);
        assertNull(result);

        result = AccountSearch.accountSearch(accNum3, emptyList);
        assertNull(result);

        result = AccountSearch.accountSearch(accNum4, recordList);
        assertNull(result);


        //Testing with a bad csv file
        result = AccountSearch.accountSearch(accNum1, problemList);
        assertNull(result);

        result = AccountSearch.accountSearch(accNum2, problemList);
        assertNull(result);

        result = AccountSearch.accountSearch(accNum3, problemList);
        assertNull(result);

        result = AccountSearch.accountSearch(accNum4, problemList);
        assertNull(result);

    }

    @Test
    void accountInputCheck() {

        //Valid account numbers
        String accNum1 = "1234567";
        String accNum3 = "1234567890";
        assertTrue(AccountSearch.accountInputCheck(accNum1));
        assertTrue(AccountSearch.accountInputCheck(accNum3));

        //Not valid account numbers
        String accNum2 = "123456789O";
        String accNum4 = "abcdefghijk";
        String accNum5 = "ABCDEFG123";
        String accNum6 = "12EA56789";
        String accNum7 = "";
        assertFalse(AccountSearch.accountInputCheck(accNum2));
        assertFalse(AccountSearch.accountInputCheck(accNum4));
        assertFalse(AccountSearch.accountInputCheck(accNum5));
        assertFalse(AccountSearch.accountInputCheck(accNum6));
        assertFalse(AccountSearch.accountInputCheck(accNum7));

    }
}