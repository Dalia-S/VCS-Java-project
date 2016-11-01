/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vilnius.coding.topsport.object;

import java.sql.ResultSet;
import java.sql.SQLException;
import lt.vilnius.coding.topsport.action.DBConn;

/**
 *
 * @author Dalia
 */
public class User {

    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String city;
    private String bDay;
    private String regDate;
    private int balance;

    public User() {
    }

    public User(String userName, String password, String firstName, String lastName,
            String phoneNumber, String address, String city, String bDay) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.bDay = bDay;
    }

    public User(String userName, String password, String firstName, String lastName,
            String phoneNumber, String address, String city, String bDay, String regDate, int balance) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.bDay = bDay;
        this.regDate = regDate;
        this.balance = balance;
    }

    public User getDetails(String userName) throws ClassNotFoundException, SQLException {
        String dBQuery = "select * from tsusers where UserName = '" + userName + "'";
        ResultSet rs = new DBConn().getStmt().executeQuery(dBQuery);
        rs.next();
        User user = new User(userName, rs.getString("Password"), rs.getString("FirstName"), rs.getString("LastName"),
                rs.getString("PhoneNumber"), rs.getString("Address"), rs.getString("City"), rs.getString("BDay"),
                rs.getString("RegDate"), rs.getInt("Balance"));
        return user;
    }

    public String getPassword(String userName) throws ClassNotFoundException, SQLException {
        String dBQuery = "select * from tsusers where UserName = '" + userName + "'";
        ResultSet rs = new DBConn().getStmt().executeQuery(dBQuery);
        rs.next();
        return rs.getString("Password");
    }

    public void setBalance(String newBalance, String userName) throws ClassNotFoundException, SQLException {
        String dBQuery = "update tsusers set Balance = " + newBalance + " where UserName = '" + userName + "'";
        new DBConn().getStmt().executeUpdate(dBQuery);
    }

    public int getBalance(String userName) throws ClassNotFoundException, SQLException {
        String dBQuery = "select * from tsusers where UserName = '" + userName + "'";
        ResultSet rs = new DBConn().getStmt().executeQuery(dBQuery);
        rs.next();
        return rs.getInt("Balance");
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getbDay() {
        return bDay;
    }

    public void setbDay(String bDay) {
        this.bDay = bDay;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}
