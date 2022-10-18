package org.CMPT305Project;

import org.CMPT305ProjectM2.Assessment;
import org.CMPT305ProjectM2.House;
import org.CMPT305ProjectM2.Neighbourhood;
import org.CMPT305ProjectM2.Record;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class RecordTest {

    List<Record> recordList;
    Record recordTest1, recordTest2, recordTest3;

    @BeforeEach
    void setUp() throws IOException {
        recordList = CSV.readCSV("Test_With_Entries.csv");
        recordTest1 = recordList.get(0);
        recordTest2 = recordList.get(1);
        recordTest3 = recordList.get(2);

    }

    @Test
    void getAccountID() {
        int expected;
        int result;

        expected = 4220364;
        result = recordTest1.getAccountID();
        assertEquals(expected, result);

        expected = 4150595;
        result = recordTest2.getAccountID();
        assertEquals(expected, result);

        expected = 4233516;
        result = recordTest3.getAccountID();
        assertEquals(expected, result);

    }

    @Test
    void getAssessedValue() {
        double expected;
        double result;

        expected = 556500;
        result = recordTest1.getAssessedValue();
        assertEquals(expected, result);

        expected = 291500;
        result = recordTest2.getAssessedValue();
        assertEquals(expected, result);

        expected = 826000;
        result = recordTest3.getAssessedValue();
        assertEquals(expected, result);
    }

    @Test
    void getNeighbourhood() {
        Neighbourhood expected;
        Neighbourhood result;

        expected = new Neighbourhood(6710, "STRATHEARN");
        result = recordTest1.getNeighbourhood();
        assertEquals(expected, result);

        expected = new Neighbourhood(6370, "KINISKI GARDENS");
        result = recordTest2.getNeighbourhood();
        assertEquals(expected, result);

        expected = new Neighbourhood(5480, "STRATHCONA");
        result = recordTest3.getNeighbourhood();
        assertEquals(expected, result);

    }

    @Test
    void getAssessment() {
        List<Assessment> resultList;
        Assessment expected;

        expected = new Assessment("RESIDENTIAL", 100);
        resultList = recordTest1.getAssessment();
        assertEquals(expected, resultList.get(0));

        expected = new Assessment("COMMERCIAL", 100);
        resultList = recordTest2.getAssessment();
        assertNotEquals(expected, resultList.get(0));

        expected = new Assessment("RESIDENTIAL", 100);
        resultList = recordTest3.getAssessment();
        assertEquals(expected, resultList.get(0));

    }

    @Test
    void getaHouse() {
        House expected;
        House result;

        expected = new House("", "8705", "92A AVENUE NW", "Y");
        result = recordTest1.getaHouse();
        assertEquals(expected, result);


        expected = new House("", "3520", "44 AVENUE NW", "N");
        result = recordTest2.getaHouse();
        assertEquals(expected, result);

        expected = new House("", "9707", "89 AVENUE NW", "Y");
        result = recordTest3.getaHouse();
        assertEquals(expected, result);
    }

    @Test
    void compareTo() {
        int expected;
        int result;

        result = recordTest1.compareTo(recordTest2);
        expected = 1;
        assertEquals(expected, result);

        result = recordTest2.compareTo(recordTest1);
        expected = -1;
        assertEquals(expected, result);

        Record recordTest4 = recordTest1;
        result = recordTest1.compareTo(recordTest4);
        expected = 0;
        assertEquals(expected, result);


        Record recordTest5 = recordTest2;
        result = recordTest1.compareTo(recordTest5);
        expected = 1;
        assertEquals(expected, result);

        result = recordTest5.compareTo(recordTest2);
        expected = 0;
        assertEquals(expected, result);

        result = recordTest3.compareTo(recordTest2);
        expected = 1;
        assertEquals(expected, result);

        result = recordTest3.compareTo(recordTest1);
        expected = 1;
        assertEquals(expected, result);

    }

    @Test
    void testToString() {
        String expected;
        String result;

        expected = "\nAccount Number = 4220364" +
                "\nHouse Address = 8705 92A AVENUE NW Y" +
                "\nAssessed Value = $556,500.00" +
                "\nAssessment Class = [RESIDENTIAL: 100.0%]" +
                "\nNeighbourhood = (Mtis Ward), (6710) STRATHEARN" +
                "\nLocation = (53.52735097, -113.4610493)";
        result = recordTest1.toString();
        assertEquals(expected, result);
    }

    @Test
    void testEquals() {
        //Reflexive
        assertTrue(recordTest1.equals(recordTest1));

        //Symmetric
        Record recordTest4 = recordList.get(0);
        assertTrue(recordTest1.equals(recordTest4));
        assertTrue(recordTest4.equals(recordTest1));


        //Transitive
        Record recordTest5 = recordList.get(0);
        assertTrue(recordTest4.equals(recordTest5));
        assertTrue(recordTest1.equals(recordTest5));

        //False Values
        assertFalse(recordTest3.equals(null));
        assertFalse(recordTest3.equals(recordTest2));
        assertFalse(recordTest1.equals(recordTest3));
        assertFalse(recordTest1.equals(null));
    }

    @Test
    void testHashCode() {
        int expected;
        int result;

        expected = Objects.hash(4220364);
        result = recordTest1.hashCode();
        assertEquals(expected, result);
    }
}