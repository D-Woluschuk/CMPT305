package org.CMPT305Project;

import org.CMPT305ProjectM2.Record;
import org.CMPT305ProjectM2.Statistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsTest {
    List<Record> recordList;
    List<Record> emptyList;
    List<Record> fullList;

    List<Record> problemList;

    @BeforeEach
    void setUp() throws IOException {
        recordList = CSV.readCSV("Test_With_Entries.csv");
        emptyList = CSV.readCSV("Test_Without_Entries.csv");
        fullList = CSV.readCSV("Lots_of_Entries.csv");
        problemList = CSV.readCSV("Problem_File.csv");
    }

    @Test
    void getNumberOfEntries() {
        int expected;
        int result;

        expected = 34;
        result = Statistics.getNumberOfEntries(recordList);
        assertEquals(expected, result);

        expected = 0;
        result = Statistics.getNumberOfEntries(emptyList);
        assertEquals(expected, result);

        expected = 4437;
        result = Statistics.getNumberOfEntries(fullList);
        assertEquals(expected, result);

        expected = 0;
        result = Statistics.getNumberOfEntries(problemList);
        assertEquals(expected, result);

    }

    @Test
    void highestAssessedValue() {
        double expected;
        double result;

        expected = 185121000.00;
        result = Statistics.highestAssessedValue(fullList);
        assertEquals(expected, result);

        expected = 826000.00;
        result = Statistics.highestAssessedValue(recordList);
        assertEquals(expected, result);

        expected = 0;
        result = Statistics.highestAssessedValue(emptyList);
        assertEquals(expected, result);

        expected = 0;
        result = Statistics.highestAssessedValue(problemList);
        assertEquals(expected, result);
    }

    @Test
    void lowestAssessedValue() {
        double expected;
        double result;

        expected = 0;
        result = Statistics.lowestAssessedValue(fullList);
        assertEquals(expected, result);

        expected = 0;
        result = Statistics.lowestAssessedValue(recordList);
        assertEquals(expected, result);

        expected = 0;
        result = Statistics.lowestAssessedValue(emptyList);
        assertEquals(expected, result);

        expected = 0;
        result = Statistics.lowestAssessedValue(problemList);
        assertEquals(expected, result);

    }

    @Test
    void assessedValueRange() {
        double expected;
        double result;

        expected = 185121000.00;
        result = Statistics.assessedValueRange(fullList);
        assertEquals(expected, result);

        expected = 826000.00;
        result = Statistics.assessedValueRange(recordList);
        assertEquals(expected, result);

        expected = 0;
        result = Statistics.assessedValueRange(emptyList);
        assertEquals(expected, result);

        expected = 0;
        result = Statistics.assessedValueRange(problemList);
        assertEquals(expected, result);
    }

    @Test
    void assessedValueMean() {
        double expected;
        double result;

        expected = 528187.18;
        result = Statistics.assessedValueMean(fullList);
        assertEquals(expected, result);

        expected = 288794.12;
        result = Statistics.assessedValueMean(recordList);
        assertEquals(expected, result);

        expected = 0;
        result = Statistics.assessedValueMean(emptyList);
        assertEquals(expected, result);

        expected = 0;
        result = Statistics.assessedValueMean(problemList);
        assertEquals(expected, result);
    }

    @Test
    void assessedValueMedian() {
        double expected;
        double result;

        expected = 296500.00;
        result = Statistics.assessedValueMedian(fullList);
        assertEquals(expected, result);

        expected = 288250.00;
        result = Statistics.assessedValueMedian(recordList);
        assertEquals(expected, result);

        expected = 0;
        result = Statistics.assessedValueMedian(emptyList);
        assertEquals(expected, result);

        expected = 0;
        result = Statistics.assessedValueMedian(problemList);
        assertEquals(expected, result);

    }
}