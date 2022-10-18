package org.CMPT305Project;

import org.CMPT305ProjectM2.Conversions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConversionsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void convertAccNum() {
        int result;

        String accNum1 = "1234567890";
        String accNum2 = "0";
        String accNum3 = "12e4567890";
        String accNum4 = "abcdefg";
        String accNum5 = "";
        String accNum6 = "a";

        assertTrue(Conversions.convertAccNum(accNum1) == 1234567890);
        assertTrue(Conversions.convertAccNum(accNum2) == 0);

        result = Conversions.convertAccNum(accNum3);
        assertEquals(0, result);

        result = Conversions.convertAccNum(accNum4);
        assertEquals(0, result);

        result = Conversions.convertAccNum(accNum5);
        assertEquals(0, result);

        result = Conversions.convertAccNum(accNum6);
        assertEquals(0, result);
    }

    @Test
    void convertAssessedValue() {
        double result;
        String value1 = "1234567890";
        String value2 = "0";
        String value3 = "12e4567890";
        String value4 = "abcdefg";
        String value5 = "";
        String value6 = "a";

        assertTrue(Conversions.convertAssessedValue(value1) == 1234567890);
        assertTrue(Conversions.convertAssessedValue(value2) == 0);

        result = Conversions.convertAssessedValue(value3);
        assertEquals(0, result);

        result = Conversions.convertAssessedValue(value4);
        assertEquals(0, result);

        result = Conversions.convertAssessedValue(value5);
        assertEquals(0, result);

        result = Conversions.convertAssessedValue(value6);
        assertEquals(0, result);

    }

    @Test
    void convertLatitude() {
        double result;
        String value1 = "53.28372438334";
        String value2 = "0";
        String value3 = "Latitude";
        String value4 = "531921812";
        String value5 = "";
        String value6 = "a";
        String value7 = ".";


        assertTrue(Conversions.convertLatitude(value1) == 53.28372438334);
        assertTrue(Conversions.convertLatitude(value2) == 0);


        result = Conversions.convertLatitude(value3);
        assertEquals(0, result);

        result = Conversions.convertLatitude(value4);
        assertEquals(0, result);

        result = Conversions.convertLatitude(value5);
        assertEquals(0, result);

        result = Conversions.convertLatitude(value6);
        assertEquals(0, result);

        result = Conversions.convertLatitude(value7);
        assertEquals(0, result);
    }

    @Test
    void convertLongitude() {
        double result;
        String value1 = "-113.28372438334";
        String value2 = "0.0";
        String value3 = "Longitude";
        String value4 = "-113856473";
        String value5 = null;
        String value6 = "b.";
        String value7 = ".";


        assertTrue(Conversions.convertLongitude(value1) == -113.28372438334);
        assertTrue(Conversions.convertLatitude(value2) == 0.0);


        result = Conversions.convertLongitude(value3);
        assertEquals(0, result);

        result = Conversions.convertLongitude(value4);
        assertEquals(0, result);
        //assertThrows(NullPointerException.class, () -> Conversions.convertLongitude(value5));
        result = Conversions.convertLongitude(value5);
        assertEquals(0, result);

        result = Conversions.convertLongitude(value6);
        assertEquals(0, result);

        //assertThrows(NumberFormatException.class, () -> Conversions.convertLongitude(value6));


        result = Conversions.convertLongitude(value7);
        assertEquals(0, result);
    }

    @Test
    void convertToDollarValue() {
        String result;
        String expected;
        double value1 = 1234567890;
        double value2 = 0.0;
        double value3 = 123;
        double value4 = -113856473;
        double value5 = 999888777666555444333222111.00;
        double value6 = 1;

        expected = "$1,234,567,890.00";
        result = Conversions.convertToDollarValue(value1);
        assertEquals(expected, result);

        expected = "$0.00";
        result = Conversions.convertToDollarValue(value2);
        assertEquals(expected, result);

        expected = "$123.00";
        result = Conversions.convertToDollarValue(value3);
        assertEquals(expected, result);


        expected = "-$113,856,473.00";
        result = Conversions.convertToDollarValue(value4);
        assertEquals(expected, result);

        for (int i = 0; i < 10; i++){
            expected = "$999,888,777,666,555,500,000,000,000.00";
            result = Conversions.convertToDollarValue(value5);
            assertEquals(expected, result);
        }


        expected = "$1.00";
        result = Conversions.convertToDollarValue(value6);
        assertEquals(expected, result);

    }

    @Test
    void convertNeighbourhoodId(){
        int result;

        String neighID1 = "4758392";
        String neighID2 = "0";
        String neighID3 = "12E4567890";
        String neighID4 = "This is not an ID";
        String neighID5 = "";
        String neighID6 = "k";

        assertTrue(Conversions.convertNeighbourhoodId(neighID1) == 4758392);
        assertTrue(Conversions.convertNeighbourhoodId(neighID2) == 0);

        result = Conversions.convertNeighbourhoodId(neighID3);
        assertEquals(0, result);

        result = Conversions.convertNeighbourhoodId(neighID4);
        assertEquals(0, result);

        result = Conversions.convertNeighbourhoodId(neighID5);
        assertEquals(0, result);

        result = Conversions.convertNeighbourhoodId(neighID6);
        assertEquals(0, result);



    }
}