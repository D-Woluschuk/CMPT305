package org.CMPT305Project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class GeographyTest {
    Geography geography1, geography2, geography3;

    @BeforeEach
    void setUp() {
        geography1 = new Geography(53.426826855643, -113.619431792539);
        geography2 = new Geography(53.5156485632332, -113.492397695502);
        geography3 = new Geography(53.6304966315854, -113.580474269319);

    }

    @Test
    void testEquals() {
        //reflexive
        assertTrue(geography1.equals(geography1));

        //symmetric
        Geography geography1Dup = new Geography(53.426826855643, -113.619431792539);

        assertTrue(geography1.equals(geography1Dup));
        assertTrue(geography1Dup.equals(geography1));

        //transitive
        Geography geography1Dup1 = new Geography(53.426826855643, -113.619431792539);

        assertTrue(geography1.equals(geography1Dup));
        assertTrue(geography1Dup.equals(geography1Dup1));
        assertTrue(geography1.equals(geography1Dup1));

        //false results
        Geography geographyTest1 = new Geography(53.4193805147976,-113.440069344885 );

        assertFalse(geographyTest1.equals(null));
        assertFalse(geography1.equals(geography2));
        assertFalse(geography2.equals(geographyTest1));
        assertFalse(geographyTest1.equals(geography2));
    }

    @Test
    void testToString(){

        String expected = "(53.426826855643, -113.619431792539)";

        assertEquals(expected, geography1.toString());
    }

    @Test
    void testHashCode(){

        double latValue = geography1.getLatitude();
        double longValue = geography1.getLongitude();

        int expected = Objects.hash(latValue, longValue);

        assertEquals(expected, geography1.hashCode());
    }


    @Test
    void getLatitude(){

        double latTest1 = 53.6304966315854;

        assertEquals(latTest1, geography3.getLatitude());
    }

    @Test
    void getLongitude(){

        double longTest1 = -113.580474269319;

        assertEquals(longTest1, geography3.getLongitude());
    }

}