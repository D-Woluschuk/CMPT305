package test.org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class GeographyTest {
    Geography geography1, geography2;
    @BeforeEach
    void setUp() {
        geography1 = new Geography(53.426826855643, -113.619431792539);
        geography2 = new Geography(53.5156485632332, -113.492397695502);
    }

    @Test
    void testEquals() {
        //reflexive
        assertEquals(true, geography1.equals(geography1));

        //symmetric
        Geography geography1Dup = new Geography(53.426826855643, -113.619431792539);
        assertEquals(true, geography1.equals(geography1Dup));
        assertEquals(true, geography1Dup.equals(geography1));

        //transitive
        Geography geography1Dup1 = new Geography(53.426826855643, -113.619431792539);
        assertEquals(true, geography1.equals(geography1Dup));
        assertEquals(true, geography1Dup.equals(geography1Dup1));
        assertEquals(true, geography1.equals(geography1Dup1));

        //false results
        Geography geographyTest1 = new Geography(53.4193805147976,-113.440069344885 );
        assertEquals(false, geographyTest1.equals(null));
        assertEquals(false, geography1.equals(geography2));
        assertEquals(false, geography2.equals(geographyTest1));
        assertEquals(false, geographyTest1.equals(geography2));
    }

}