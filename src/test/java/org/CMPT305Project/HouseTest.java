package org.CMPT305Project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class HouseTest {

    House houseTest1;
    House houseTest2;

    @BeforeEach
    void setUp() {
        houseTest1 = new House("1945", "10623", "106St NW","N");
        houseTest2 = new House("", "294", "Clareview Road NW", "Y");

    }

    @Test
    void getSuiteNumber(){
        assertEquals("1945", houseTest1.getSuiteNumber());
        assertEquals("", houseTest2.getSuiteNumber());

    }

    @Test
    void getHouseNumber() {
        assertEquals("10623", houseTest1.getHouseNumber());
        assertEquals("294", houseTest2.getHouseNumber());
    }

    @Test
    void getStreetName() {
        assertEquals("Clareview Road NW", houseTest2.getStreetName());
        assertEquals("106St NW", houseTest1.getStreetName());
    }

    @Test
    void getGarageStatus() {
        assertEquals("Y", houseTest2.getGarageStatus());
        assertEquals("N", houseTest1.getGarageStatus());
    }

    @Test
    void testEquals() {
        //Reflexive
        assertTrue(houseTest1.equals(houseTest1));

        //Symmetric
        House houseTest3 = new House("1945", "10623", "106St NW", "N");
        assertTrue(houseTest1.equals(houseTest3));
        assertTrue(houseTest3.equals(houseTest1));

        //Transitive
        House houseTest4 = new House("1945", "10623", "106St NW", "N");
        assertTrue(houseTest3.equals(houseTest4));
        assertTrue(houseTest1.equals(houseTest4));

        //False Results
        assertFalse(houseTest1.equals(null));
        assertFalse(houseTest2.equals(null));
        assertFalse(houseTest1.equals(houseTest2));
        assertFalse(houseTest2.equals(houseTest4));
        House houseTest5 = new House("", "15712", "106St NW", "Y");
        assertFalse(houseTest5.equals(houseTest1));
    }

    @Test
    void testToString(){
        String house1 = houseTest1.toString();

        String expected = "1945-10623 106St NW N";

        assertEquals(expected, house1);


    }

    @Test
    void testHashCode(){

        String suiteNum = houseTest1.getSuiteNumber();
        String houseNum = houseTest1.getHouseNumber();
        String streetName = houseTest1.getStreetName();
        String garageStatus = houseTest1.getGarageStatus();

        int expected = Objects.hash(suiteNum, houseNum, streetName, garageStatus);
        assertTrue(expected == houseTest1.hashCode());

        String suiteNum2 = houseTest2.getSuiteNumber();
        String houseNum2 = houseTest2.getHouseNumber();
        String streetName2 = houseTest2.getStreetName();
        String garageStatus2 = houseTest2.getGarageStatus();

        int expected2 = Objects.hash(suiteNum2, houseNum2, streetName2, garageStatus2);
        assertFalse(expected2 == houseTest1.hashCode());

    }
}