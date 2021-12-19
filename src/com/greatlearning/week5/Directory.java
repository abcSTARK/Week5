package com.greatlearning.week5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Directory {


    Logger log = new Logger();


    public void start(){
        Login login = new Login();
        login.getLoginDetails();
        try {
            login.verify();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getDirectory() throws SQLException {

        String sql = "select * FROM STUDENT";
        Connection connection = DBConnection.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()) {
        Student st = new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
            System.out.println(st.toString());
        }

        System.out.println("Student table displayed successfully");
        log.generateLog("Student table displayed successfully");

        DBConnection.closeConnection(connection);

    }

    public void registration(Student stu) throws SQLException {

        String sql = "insert into STUDENT values (?,?,?,?)";
        Connection connection = DBConnection.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1,stu.getUserId());
        stmt.setString(2,stu.getFirstName());
        stmt.setString(3,stu.getLastName());
        stmt.setString(4,stu.getEmail());

        int insert = stmt.executeUpdate();
        System.out.println("Student " + stu.getFirstName() + " inserted successfully");
        log.generateLog("Student " + stu.getFirstName() + " inserted successfully");

        DBConnection.closeConnection(connection);

    }

    public void delete(int userid ) throws SQLException {

        String sql = "DELETE from STUDENT where userId=?";
        Connection connection = DBConnection.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1,userid);

        int insert = stmt.executeUpdate();
        System.out.println("Student id " + userid + " deleted successfully");
        log.generateLog("Student " + userid + " deleted successfully");

        DBConnection.closeConnection(connection);


    }

    public void update(Student stu) throws SQLException { //to write
        Login login = new Login();
        login.getRandomOtp();
        if(login.verifyOtp()) {

            String sql = "UPDATE STUDENT set firstName=?,lastName=?,email=? where userId=?";
            Connection connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(4,stu.getUserId());
            stmt.setString(1,stu.getFirstName());
            stmt.setString(2,stu.getLastName());
            stmt.setString(3,stu.getEmail());

            int insert = stmt.executeUpdate();
            System.out.println("Student " + stu.getFirstName() + " updated successfully");
            log.generateLog("Student " + stu.getFirstName() + " inserted successfully");

            DBConnection.closeConnection(connection);

                log.generateLog("Amount Transferred Successfully-->Rs.");

        }
        else {
            System.out.println("-------****-------");
            System.out.println("-------Wrong OTP Try Again-------");
            log.generateLog("-------Wrong OTP Try Again-------");
            System.out.println("-------****-------");

            update(stu);
        }


    }
}
