package com.greatlearning.week5;

import java.util.HashMap;

public class StudentApplication {
    public static void main(String args[]){

        System.out.println("Starting Student Directory System ... ");
        Directory directory = new Directory();
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        Logger log = new Logger();
        log.generateLog("******** Log For Last Session ********");
        directory.start();
        log.saveLog();


    }

}
