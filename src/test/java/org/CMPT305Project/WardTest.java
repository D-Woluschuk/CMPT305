package org.CMPT305Project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WardTest {

    Ward wardTest1, wardTest2, wardTest3;
    Neighbourhood neighTest1, neighTest2, neighTest3;
    @BeforeEach
    void setUp() {

        neighTest1 = new Neighbourhood(2500, "Matt Berry");
        neighTest2 = new Neighbourhood(1150, "Oliver");
        neighTest3 = new Neighbourhood(4590, "West Meadowlark");
        wardTest1 = new Ward("Dene Ward", neighTest1);
        wardTest2 = new Ward("O-Day'min Ward", neighTest2);
        wardTest3 = new Ward("sipiwiyiniwak Ward", neighTest3);
    }

    @Test
    void getWardName() {
        String expected = "Dene Ward";
        assertEquals(true, expected.equalsIgnoreCase(wardTest1.getWardName()));
        assertEquals(false, expected.equalsIgnoreCase(wardTest2.getWardName()));
    }

    @Test
    void getaNeighbourhood() {
        Neighbourhood expected = new Neighbourhood(2500, "Matt Berry");
        assertEquals(true, expected.equals(neighTest1));
    }

    @Test
    void testToString() {
    }

    @Test
    void testEquals() {
        //Reflexive
        assertEquals(true, wardTest1.equals(wardTest1));

        //Symmetric
        Neighbourhood neighTest4 = new Neighbourhood(2500, "Matt Berry");
        Ward wardTest4 = new Ward("Dene Ward", neighTest4);
        assertEquals(true, wardTest1.equals(wardTest4));
        assertEquals(true, wardTest4.equals(wardTest1));


        //Transitive
        Neighbourhood neighTest5 = new Neighbourhood(2500, "Matt Berry");
        Ward wardTest5 = new Ward("Dene Ward", neighTest5);
        assertEquals(true, wardTest4.equals(wardTest5));
        assertEquals(true, wardTest1.equals(wardTest5));

        //False Values
        assertEquals(false, wardTest3 == null);
        assertEquals(false, wardTest3.equals(wardTest2));
        assertEquals(false, wardTest1.equals(wardTest3));
        assertEquals(false, wardTest1 == null);
    }

    @Test
    void testHashCode() {
    }
}