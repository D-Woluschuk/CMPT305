package org.example;

import java.util.ArrayList;

public class Statistics {

    public static int getNumberOfEntries(ArrayList<String> fileContents){
        int entryCount;

        entryCount = fileContents.size();

        return entryCount;
    }
}
