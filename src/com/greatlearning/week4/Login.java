package com.greatlearning.week4;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Login {

    int acc;
    int pass;
    int otp;
    public void getLoginDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the account number(Hint -- 1011,1012,1013):");
        acc = scanner.nextInt();
        System.out.println("Enter the Password(Hint -- 123,1234,12345):");
        pass = scanner.nextInt();
    }

    public void getRandomOtp(){
        Random r = new Random();
        otp = 1000 + r.nextInt(10000);
        System.out.println("Enter OTP : "+ otp);
    }

    public boolean verifyOtp(){
        Scanner scanner = new Scanner(System.in);
        int token = scanner.nextInt();
        if(token == otp){
            return true;
        }
        else
            return false;
    }


    public void verify() throws Exception{
        HashMap<Integer,Integer> map = new HashMap<>(); //hardcoded Login details
        map.put(1011,123);
        map.put(1012,1234);
        map.put(1013,12345);

        if(map.get(acc)==pass){
        //if(true){
            System.out.println("||| Welcome to Indian Bank |||");
            Customers customers = new Customers();
            customers.enterMenu(acc);

        }
        else {

            System.out.println("Wrong Credentials");
            getLoginDetails();
        }

    }
}
