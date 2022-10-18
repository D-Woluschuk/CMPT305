package org.CMPT305Project;

import org.CMPT305ProjectM2.Assessment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class AssessmentTest {

    Assessment testAssessment1, testAssessment2, testAssessment3;

    @BeforeEach
    void setUp() {
        testAssessment1 = new Assessment("Residential", 50.0);
        testAssessment2 = new Assessment("Commercial", 26.0);
        testAssessment3 = new Assessment("Farmland", 24.0);
    }

    @Test
    void getAssessmentClass() {
        String result;
        result = testAssessment1.getAssessmentClass();
        String expected = "Residential";
        assertEquals(expected, result);

        result = testAssessment2.getAssessmentClass();
        assertNotEquals(expected, result);
        expected = "Commercial";
        assertEquals(expected, result);

        result = testAssessment3.getAssessmentClass();
        assertNotEquals(expected, result);
        expected = "Farmland";
        assertEquals(expected, result);
    }

    @Test
    void getAssessmentPercent() {
        double result;
        double expected;

        result = testAssessment1.getAssessmentPercent();
        expected = 50.0;
        assertEquals(expected, result);
        assertNotEquals(49.9, result);

        result = testAssessment2.getAssessmentPercent();
        expected = 26.0;
        assertEquals(expected, result);
        assertNotEquals(25.99, result);

        result = testAssessment3.getAssessmentPercent();
        expected = 24.0;
        assertEquals(expected, result);
        assertNotEquals(0, result);


    }

    @Test
    void testHashCode() {
        String assessmentClass1 = testAssessment1.getAssessmentClass();
        double assessmentPercent1 = testAssessment1.getAssessmentPercent();

        int expected = Objects.hash(assessmentClass1, assessmentPercent1);

        assertEquals(expected, testAssessment1.hashCode());

    }

    @Test
    void testEquals() {
        //Reflexive
        assertTrue(testAssessment1.equals(testAssessment1));

        //Symmetric
        Assessment testAssessment4 = new Assessment("Residential", 50.0);
        assertTrue(testAssessment1.equals(testAssessment4));
        assertTrue(testAssessment4.equals(testAssessment1));

        //Transitive
        Assessment testAssessment5 = new Assessment("Residential", 50.0);
        assertTrue(testAssessment4.equals(testAssessment5));
        assertTrue(testAssessment1.equals(testAssessment5));

        //False Results
        assertFalse(testAssessment1.equals(null));
        assertFalse(testAssessment2.equals(null));
        assertFalse(testAssessment1.equals(testAssessment2));
        assertFalse(testAssessment3.equals(testAssessment4));
        Assessment testAssessment6 = new Assessment("Other Residential", 99.0);
        assertFalse(testAssessment6.equals(testAssessment1));
    }

    @Test
    void testToString() {

        String expected = "Residential: 50.0%";
        String result = testAssessment1.toString();
        assertEquals(expected, result);


    }
}