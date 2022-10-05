package org.CMPT305Project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class NeighbourhoodTest {

    Neighbourhood neighTest1, neighTest2, neighTest3;

    @BeforeEach
    void setUp() {
        neighTest1 = new Neighbourhood(1160, "Parkdale");
        neighTest2 = new Neighbourhood(2330, "Highlands");
        neighTest3 = new Neighbourhood(2550, "Montrose");
    }

    @Test
    void testToString() {
        String expected = "(1160) Parkdale";
        String result = neighTest1.toString();
        assertEquals(expected, result);
    }

    @Test
    void getNeighbourhoodId() {
        int expected;
        int result;

        expected = 1160;
        result = neighTest1.getNeighbourhoodId();
        assertEquals(expected, result);

        expected = 2330;
        result = neighTest2.getNeighbourhoodId();
        assertEquals(expected, result);

        expected = 2550;
        result = neighTest3.getNeighbourhoodId();
        assertEquals(expected, result);
    }

    @Test
    void getNeighbourhoodName() {
        String expected;
        String result;

        expected = "Parkdale";
        result = neighTest1.getNeighbourhoodName();
        assertEquals(expected, result);

        expected = "Highlands";
        result = neighTest2.getNeighbourhoodName();
        assertEquals(expected, result);

        expected = "Montrose";
        result = neighTest3.getNeighbourhoodName();
        assertEquals(expected, result);
    }

    @Test
    void testEquals() {
        //Reflexive
        assertTrue(neighTest1.equals(neighTest1));

        //Symmetric
        Neighbourhood neighTest4 = new Neighbourhood(1160, "Parkdale");
        assertTrue(neighTest1.equals(neighTest4));
        assertTrue(neighTest4.equals(neighTest1));


        //Transitive
        Neighbourhood neighTest5 = new Neighbourhood(1160, "Parkdale");
        assertTrue(neighTest4.equals(neighTest5));
        assertTrue(neighTest1.equals(neighTest5));

        //False Values
        assertFalse(neighTest3.equals(null));
        assertFalse(neighTest3.equals(neighTest2));
        assertFalse(neighTest1.equals(neighTest3));
        assertFalse(neighTest1.equals(null));
    }

    @Test
    void testHashCode() {
        int neighID1 = neighTest1.getNeighbourhoodId();

        int expected = Objects.hash(neighID1);

        assertEquals(expected, neighTest1.hashCode());
    }
}