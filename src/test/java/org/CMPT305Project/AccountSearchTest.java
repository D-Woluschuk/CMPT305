package org.CMPT305Project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountSearchTest {
    List<Record> recordList;
    List<Record> emptyList;
    @BeforeEach
    void setUp() throws IOException {
        recordList = CSV.readCSV("Test_With_Entries.csv");
        emptyList = CSV.readCSV("Test_Without_Entries.csv");
    }

    @Test
    void accountSearch() {

        //Testing with a csv file that has some entries

        Record result1 = AccountSearch.accountSearch("4220364", recordList);
        assert result1 != null;
        assertEquals(4220364, result1.getAccountID());

        Record result2 = AccountSearch.accountSearch("1234567890", recordList);
        assertNull(result2);

        Record result3 = AccountSearch.accountSearch("abc", recordList);
        assertNull(result3);


        //Testing with an empty csv file

        result1 = AccountSearch.accountSearch("4220364", emptyList);
        assertNull(result1);

        result2 = AccountSearch.accountSearch("1234567890", emptyList);
        assertNull(result2);

        result3 = AccountSearch.accountSearch("abc", emptyList);
        assertNull(result3);

    }

    @Test
    void accountInputCheck() {
        String accNum1 = "1234567";
        String accNum2 = "123456789O";
        String accNum3 = "1234567890";
        String accNum4 = "abcdefghijk";
        String accNum5 = "ABCDEFG123";
        String accNum6 = "12EA56789";
        String accNum7 = "";

        assertTrue(AccountSearch.accountInputCheck(accNum1));
        assertTrue(AccountSearch.accountInputCheck(accNum3));


        assertFalse(AccountSearch.accountInputCheck(accNum2));
        assertFalse(AccountSearch.accountInputCheck(accNum4));
        assertFalse(AccountSearch.accountInputCheck(accNum5));
        assertFalse(AccountSearch.accountInputCheck(accNum6));
        assertFalse(AccountSearch.accountInputCheck(accNum7));

    }
}