package com.greatlearning.week4;

import java.util.Scanner;

public class Customers {
    int menuChoice;
    Bank banking =new Bank();
    public void enterMenu(int acc) {
        System.out.println("---------------------------------------------------");
        System.out.println("Please Select Operation You Want to Perform :");
        System.out.println("Press 1 to Deposit Amount.");
        System.out.println("Press 2 to Withdraw Amount.");
        System.out.println("Press 3 to View Balance");
        System.out.println("Press 4 to Transfer");
        System.out.println("Press 0 to Logout");
        System.out.println("Press 9 to exit Application");
        System.out.println("---------------------------------------------------");
        System.out.println(" ");
        Scanner scanner = new Scanner(System.in);
        System.out.println ("Press any key:");
        menuChoice = scanner.nextInt();
        switch (menuChoice) {
            case 1:
                System.out.println("Please Enter the amount to withdraw:");
                int depamt=scanner.nextInt();
                banking.deposit(acc,depamt);
                enterMenu(acc);
                break;
            case 2:
                System.out.println("Please Enter the amount to withdraw:");
                int withamt=scanner.nextInt();
                banking.withdraw(acc,withamt);
                enterMenu(acc);
                break;
            case 3:
                System.out.println("Your Account Balance is "+banking.getAmount(acc)+" Rupees");
                System.out.println(" ");
                enterMenu(acc);
                break;

            case 4:
                System.out.println("Please Enter the amount to Transfer:");
                int transferAmt=scanner.nextInt();
                System.out.println("Please Enter the Target Account to Transfer:");
                int transferAcc=scanner.nextInt();
                banking.transfer(transferAmt,acc,transferAcc);
                enterMenu(acc);
                break;

            case 9:
                System.out.println("... Exiting Indian Bank Application ...");
                Logger log = new Logger();
                log.saveLog();
                System.exit(0);
                break;

            case 0:
                System.out.println("Transaction Ended");
                banking.start();
                break;
        }



    }
}
