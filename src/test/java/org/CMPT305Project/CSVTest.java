package org.CMPT305Project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CSVTest {

    String path1, path2, path3, path4;
    @BeforeEach
    void setUp() {
        path1 = "AssessmentSearchTest.csv";
        path2 = "Test_With_Entries.csv";
        path3 = "Test_Without_Entries.csv";
        path4 = "This_is_not_a_file.csv";

    }

    @Test
    void checkFile() {
        assertTrue(CSV.checkFile(path1));
        assertTrue(CSV.checkFile(path2));
        assertTrue(CSV.checkFile(path3));
        assertFalse(CSV.checkFile(path4));

    }

    @Test
    void readCSV() {
    }
}