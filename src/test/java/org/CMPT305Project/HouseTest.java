package org.CMPT305Project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseTest {

    House houseTest1;
    House houseTest2;

    @BeforeEach
    void setUp() {
        houseTest1 = new House("1945", "10623", "106St","N");
        houseTest2 = new House("", "294", "Clareview Road", "Y");

    }

    @Test
    void getHouseNumber() {
        assertEquals("10623", houseTest1.getHouseNumber());

        String expected = houseTest2.getHouseNumber();
        assertNotEquals(expected, "10623");
    }

    @Test
    void getStreetName() {

    }

    @Test
    void getGarageStatus() {
    }

    @Test
    void testEquals() {
    }
}