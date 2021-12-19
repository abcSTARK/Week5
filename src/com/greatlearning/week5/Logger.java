package com.greatlearning.week5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    static File logfile = new File("student-log-file.txt");
    static FileWriter fw;

    static {
        try {
            fw = new FileWriter(logfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    PrintWriter pw = new PrintWriter(fw);
    public void generateLog(String printLog){
        pw.println(printLog);
    }

    public void  saveLog(){
        pw.close();
    }


}
