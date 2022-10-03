package org.CMPT305Project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountSearchTest {
    List<Record> recordList;
    @BeforeEach
    void setUp() throws IOException {
        recordList = CSV.readCSV("Property_Assessment_Data_2022.csv");
    }

    @Test
    void accountSearch() {
        Record result1 = AccountSearch.accountSearch("1103530", recordList);
        assert result1 != null;
        assertEquals(true, result1.getAccountID() == 1103530);

        Record result2 = AccountSearch.accountSearch("1234567890", recordList);
        assertNull(result2);

        Record result3 = AccountSearch.accountSearch("abc", recordList);
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

        assertEquals(true, AccountSearch.accountInputCheck(accNum1));
        assertEquals(true, AccountSearch.accountInputCheck(accNum3));


        assertEquals(false, AccountSearch.accountInputCheck(accNum2));
        assertEquals(false, AccountSearch.accountInputCheck(accNum4));
        assertEquals(false, AccountSearch.accountInputCheck(accNum5));
        assertEquals(false, AccountSearch.accountInputCheck(accNum6));
        assertEquals(false, AccountSearch.accountInputCheck(accNum7));

    }
}