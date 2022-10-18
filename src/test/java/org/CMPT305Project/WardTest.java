package org.CMPT305Project;

import org.CMPT305ProjectM2.Neighbourhood;
import org.CMPT305ProjectM2.Ward;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

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
        assertTrue(expected.equalsIgnoreCase(wardTest1.getWardName()));
        assertFalse(expected.equalsIgnoreCase(wardTest2.getWardName()));
    }

    @Test
    void getaNeighbourhood() {
        Neighbourhood expected = new Neighbourhood(2500, "Matt Berry");
        assertEquals(expected, wardTest1.getNeighbourhood());
    }

    @Test
    void testToString() {
        String expected = "(Dene Ward), (2500) Matt Berry";

        assertEquals(expected, wardTest1.toString());
    }

    @Test
    void testEquals() {

        //Reflexive
        assertTrue(wardTest1.equals(wardTest1));

        //Symmetric
        Neighbourhood neighTest4 = new Neighbourhood(2500, "Matt Berry");
        Ward wardTest4 = new Ward("Dene Ward", neighTest4);
        assertTrue(wardTest1.equals(wardTest4));
        assertTrue(wardTest4.equals(wardTest1));


        //Transitive
        Neighbourhood neighTest5 = new Neighbourhood(2500, "Matt Berry");
        Ward wardTest5 = new Ward("Dene Ward", neighTest5);
        assertTrue(wardTest4.equals(wardTest5));
        assertTrue(wardTest1.equals(wardTest5));

        //False Values
        assertFalse(wardTest3.equals(null));
        assertFalse(wardTest3.equals(wardTest2));
        assertFalse(wardTest1.equals(wardTest3));
        assertFalse(wardTest1.equals(null));
    }

    @Test
    void testHashCode(){
        Neighbourhood neighbourhood = wardTest1.getNeighbourhood();
        String wardName = wardTest1.getWardName();

        int expected = Objects.hash(wardName, neighbourhood);

        assertEquals(expected, wardTest1.hashCode());
    }

}