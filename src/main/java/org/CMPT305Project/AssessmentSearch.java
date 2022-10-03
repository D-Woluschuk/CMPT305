package org.CMPT305Project;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class AssessmentSearch {

    /**
     *
     * @param anAssessmentClass
     * @param recordList
     * @return
     */
    public static List<Record> searchByAssessment(String anAssessmentClass, List<Record> recordList){
        List<Record> foundRecords = new ArrayList<>();

        for (Record aRecord: recordList) {
            for (Assessment anAssessment: aRecord.getAssessment()) {
                if (anAssessmentClass.equalsIgnoreCase(anAssessment.getAssessmentClass())){
                    foundRecords.add(aRecord);
                    break;
                }
            }
        }
        return foundRecords;
    }

}
