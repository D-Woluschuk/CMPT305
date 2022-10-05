package org.CMPT305Project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NeighbourhoodSearchTest {

    List<Record> recordList;
    List<Record> emptyList;
    @BeforeEach
    void setUp() throws IOException {
        recordList = CSV.readCSV("Test_With_Entries.csv");
        emptyList = CSV.readCSV("Test_Without_Entries.csv");
    }

    @Test
    void neighbourhoodSearch() {
        String searchTerm1 = "Matt Berry";
        String searchTerm2 = "beaumaris";
        String searchTerm3 = "Kernohan";
        String searchTerm4 = "Edmonton Energy and Technology Park";
        String searchTerm5 = "";
        String searchTerm6 = "Edmonton";
        String searchTerm7 = "Newton";

        List<Record> resultsList;

        //Testing with "Test_With_Entries.csv"
        resultsList = NeighbourhoodSearch.neighbourhoodSearch(searchTerm7, recordList);
        assertEquals(3, resultsList.size());

        resultsList = NeighbourhoodSearch.neighbourhoodSearch(searchTerm2, recordList);
        assertEquals(1, resultsList.size());
        assertEquals(searchTerm2.toUpperCase(), resultsList.get(0).getNeighbourhood().getNeighbourhoodName());

        resultsList = NeighbourhoodSearch.neighbourhoodSearch(searchTerm3, recordList);
        assertEquals(1, resultsList.size());


        //No results found when searching
        resultsList = NeighbourhoodSearch.neighbourhoodSearch(searchTerm5, recordList);
        assertEquals(0, resultsList.size());
        resultsList = NeighbourhoodSearch.neighbourhoodSearch(searchTerm6, recordList);
        assertEquals(0, resultsList.size());
        resultsList = NeighbourhoodSearch.neighbourhoodSearch(searchTerm4, recordList);
        assertEquals(0, resultsList.size());
        resultsList = NeighbourhoodSearch.neighbourhoodSearch(searchTerm1, recordList);
        assertEquals(0, resultsList.size());


        //Testing with the empty file.
        resultsList = NeighbourhoodSearch.neighbourhoodSearch(searchTerm1, emptyList);
        assertEquals(0, resultsList.size());
        resultsList = NeighbourhoodSearch.neighbourhoodSearch(searchTerm2, emptyList);
        assertEquals(0, resultsList.size());
        resultsList = NeighbourhoodSearch.neighbourhoodSearch(searchTerm3, emptyList);
        assertEquals(0, resultsList.size());



    }
}