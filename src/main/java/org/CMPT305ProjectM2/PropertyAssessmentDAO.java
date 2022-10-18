package org.CMPT305ProjectM2;

import java.util.List;

public interface PropertyAssessmentDAO {
    Record getByAccountNumber(int accountNumber);

    List<Record> getByNeighbourhood(String neighbourhood);

    List<Record> getByAssessmentClass(String assessmentClass);

    List<Record> getAll();

    List<Assessment> createAssessment(String [] aLine);

}
