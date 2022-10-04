package org.CMPT305Project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AssessmentSearchTest {

    List<Record> recordList;
    List<Record> emptyList;

    @BeforeEach
    void setUp() throws IOException {
        recordList = CSV.readCSV("Test_With_Entries.csv");
        emptyList = CSV.readCSV("Test_Without_Entries.csv");
    }

    @Test
    void searchByAssessment() {

    }
}