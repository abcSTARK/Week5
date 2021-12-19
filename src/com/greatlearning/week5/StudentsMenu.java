package com.greatlearning.week5;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentsMenu {
    int menuChoice;
    Directory directory =new Directory();
    public void enterMenu(int acc) throws SQLException {

        System.out.println("---------------------------------------------------");
        System.out.println("Please Select Operation You Want to Perform :");
        System.out.println("Press 1 to Register Student.");
        System.out.println("Press 2 to Update Student Details.");
        System.out.println("Press 3 to Display Directory");
        System.out.println("Press 4 to Delete Student");
        System.out.println("Press 0 to Logout");
        System.out.println("Press 9 to exit Application");
        System.out.println("---------------------------------------------------");
        System.out.println(" ");
        Scanner scanner = new Scanner(System.in);
        System.out.println ("Press any key:");
        menuChoice = scanner.nextInt();
        switch (menuChoice) {
            case 1:
                System.out.println("Please Enter the StudentID:");
                int id=scanner.nextInt();
                System.out.println("Please Enter the First Name:");
                String fname=scanner.next();
                System.out.println("Please Enter the Last Name:");
                String lname=scanner.next();
                System.out.println("Please Enter the Email Id:");
                String email=scanner.next();
                Student stu = new Student(id,fname,lname,email);
                directory.registration(stu);

                enterMenu(acc);
                break;
            case 2:
                System.out.println("Please Enter the Student Details to Modify:");
                System.out.println("Please Enter the StudentID:");
                id=scanner.nextInt();
                System.out.println("Please Enter the First Name:");
                fname=scanner.next();
                System.out.println("Please Enter the Last Name:");
                lname=scanner.next();
                System.out.println("Please Enter the Email Id:");
                email=scanner.next();
                Student stu2 = new Student(id,fname,lname,email);
                directory.update(stu2);
                enterMenu(acc);
                break;
            case 3:
                System.out.println("----- Student Directory -----");
                directory.getDirectory();
                System.out.println(" ");
                enterMenu(acc);
                break;

            case 4:
                System.out.println("Enter Student ID to Delete");
                id=scanner.nextInt();
                directory.delete(id);
                enterMenu(acc);
                break;

            case 9:
                System.out.println("... Exiting Student Directory Application ...");
                Logger log = new Logger();
                log.saveLog();

                System.exit(0);
                break;

            case 0:
                System.out.println("Transaction Ended");
                directory.start();
                break;
        }



    }
}
