package com.greatlearning.week4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Random;

public class BankingApplication {
    public static void main(String args[]){

        System.out.println("Starting Indian Bank System ... ");
        Bank bank = new Bank();
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        Logger log = new Logger();
        log.generateLog("******** Log For Last Session ********");
        bank.start();
        log.saveLog();


    }

}
