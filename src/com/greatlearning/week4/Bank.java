package com.greatlearning.week4;
import java.awt.image.PackedColorModel;
import java.util.*;
public class Bank {

    static HashMap<Integer,Integer> accdetail = new HashMap<>();
    Logger log = new Logger();
    static{
        accdetail.put(1011,0);
        accdetail.put(1012,0);
        accdetail.put(1013,0);
    }

    public void start(){
        Login login = new Login();
        login.getLoginDetails();
        try {
            login.verify();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getAmount(int accno){
        return accdetail.get(accno);
    }

    public void deposit(int accno ,int depositAmt){
        if(depositAmt<0){
            ExceptionHandling exp = new ExceptionHandling("Enter Amount >0");
            log.generateLog("Enter Amount >0");
            System.out.println(exp.getErr());
        }
        else {
            int amount = accdetail.get(accno);
            amount += depositAmt;
            accdetail.put(accno, amount);
            System.out.println("amount Rs." + depositAmt + " deposited successfully ... to acc : "+ accno);
            log.generateLog("amount Rs." + depositAmt + " deposited successfully ...to acc : "+ accno);
        }
    }

    public void withdraw(int accno, int withdrawAmt){
        int amount = accdetail.get(accno);
        if(amount<withdrawAmt) {
            ExceptionHandling exp = new ExceptionHandling("Insufficient Balance !!");
            System.out.println(exp.getErr());
            log.generateLog("Insufficient Balance !!");
        }
        else
        {
            amount-=withdrawAmt;
            accdetail.put(accno,amount);
            System.out.println("Amount Withdrawn Successfully-->Rs."+withdrawAmt+" from acc "+accno);
            log.generateLog("Amount Withdrawn Successfully-->Rs."+withdrawAmt+" from acc "+accno);
        }
    }

    public void transfer(int transferAmt, int sourceAcc , int targetAcc){ //to write
        Login login = new Login();
        login.getRandomOtp();
        if(login.verifyOtp()) {
            int amount = accdetail.get(sourceAcc);
            if (amount < transferAmt) {
                System.out.println("Insufficient Balance in acc : !!" + sourceAcc);
                log.generateLog("Insufficient Balance in acc : !!" + sourceAcc);
            }
            else {
                amount -= transferAmt;
                accdetail.put(sourceAcc, amount);
                accdetail.put(targetAcc, accdetail.get(targetAcc) + transferAmt);
                System.out.println("Amount Transferred Successfully-->Rs." + transferAmt);
                log.generateLog("Amount Transferred Successfully-->Rs." + transferAmt);
            }
        }
        else {
            System.out.println("-------****-------");
            System.out.println("-------Wrong OTP Try Again-------");
            log.generateLog("-------Wrong OTP Try Again-------");
            System.out.println("-------****-------");

            transfer(transferAmt, sourceAcc, targetAcc);
        }


    }
}
