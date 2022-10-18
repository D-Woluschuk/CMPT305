package org.CMPT305Project;

import org.CMPT305ProjectM2.Assessment;
import org.CMPT305ProjectM2.Record;

import java.util.ArrayList;
import java.util.List;

/**
 * This class allows a client program to search the list of property assessment records
 * by an assessment class name. (Residential, Commercial, etc).
 */
public class AssessmentSearch {

    /**
     * Searches the list of property assessment records for a user specified assessment class name.
     * @param anAssessmentClass: The assessment class name that is to be searched for in the
     *                         recordList.
     * @param recordList: The list of all property assessment records read from the csv file.
     * @return foundRecords: A list of records that have the property assessment class specified
     *                       by the user input.
     */
    public static List<Record> searchByAssessment(String anAssessmentClass, List<Record> recordList){
        List<Record> foundRecords = new ArrayList<>();

        //This loop goes through each record
        for (Record aRecord: recordList) {

            //This loop goes through each assessment object in the record.
            for (Assessment anAssessment: aRecord.getAssessment()) {

                //If the assessment object has the same assessmentClass Name as the user inputted value
                //we add it to a list of Record objects to be returned.
                if (anAssessmentClass.equalsIgnoreCase(anAssessment.getAssessmentClass())){
                    foundRecords.add(aRecord);
                    //We will break since we do not need to search the other values if we
                    //already found the assessment class name we are looking for.
                    break;
                }
            }
        }
        return foundRecords;
    }

}
