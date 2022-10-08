package org.CMPT305Project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AssessmentSearchTest {

    List<Record> recordList;
    List<Record> emptyList;
    List<Record> assessmentsList;

    List<Record> problemList;

    @BeforeEach
    void setUp() throws IOException {
        recordList = CSV.readCSV("Test_With_Entries.csv");
        emptyList = CSV.readCSV("Test_Without_Entries.csv");
        assessmentsList = CSV.readCSV("AssessmentSearchTest.csv");
        problemList = CSV.readCSV("Problem_File.csv");
    }


    @Test
    void searchByAssessment() {
        String searchTerm1 = "Commercial";
        String searchTerm2 = "Residential";
        String searchTerm3 = "Farmland";
        String searchTerm4 = "";

        List<Record> resultsList;

        //Searching for entries where the entire file is Residential class only.
        resultsList = AssessmentSearch.searchByAssessment(searchTerm1, recordList);
        assertEquals(0, resultsList.size());

        resultsList = AssessmentSearch.searchByAssessment(searchTerm2, recordList);
        assertEquals(34, resultsList.size());

        resultsList = AssessmentSearch.searchByAssessment(searchTerm3, recordList);
        assertEquals(0, resultsList.size());

        resultsList = AssessmentSearch.searchByAssessment(searchTerm4, recordList);
        assertEquals(0, resultsList.size());


        //Searching for values when certain entries have multiple assessment classes
        resultsList = AssessmentSearch.searchByAssessment(searchTerm1, assessmentsList);
        assertEquals(5, resultsList.size());

        resultsList = AssessmentSearch.searchByAssessment(searchTerm3, assessmentsList);
        assertEquals(7, resultsList.size());

        resultsList = AssessmentSearch.searchByAssessment(searchTerm2, assessmentsList);
        assertEquals(15, resultsList.size());

        resultsList = AssessmentSearch.searchByAssessment(searchTerm4, assessmentsList);
        assertEquals(0, resultsList.size());


        //Searching for an assessment when the file was empty
        resultsList = AssessmentSearch.searchByAssessment(searchTerm1, emptyList);
        assertEquals(0, resultsList.size());

        resultsList = AssessmentSearch.searchByAssessment(searchTerm2, emptyList);
        assertEquals(0, resultsList.size());

        resultsList = AssessmentSearch.searchByAssessment(searchTerm3, emptyList);
        assertEquals(0, resultsList.size());

        resultsList = AssessmentSearch.searchByAssessment(searchTerm4, emptyList);
        assertEquals(0, resultsList.size());


        //Searching for an assessment when the file has problems
        resultsList = AssessmentSearch.searchByAssessment(searchTerm1, problemList);
        assertEquals(0, resultsList.size());

        resultsList = AssessmentSearch.searchByAssessment(searchTerm2, problemList);
        assertEquals(0, resultsList.size());

        resultsList = AssessmentSearch.searchByAssessment(searchTerm3, problemList);
        assertEquals(0, resultsList.size());

        resultsList = AssessmentSearch.searchByAssessment(searchTerm4, problemList);
        assertEquals(0, resultsList.size());
    }
}