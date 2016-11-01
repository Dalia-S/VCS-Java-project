/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vilnius.coding.topsport.main;

import java.sql.SQLException;
import lt.vilnius.coding.topsport.action.DBConn;
import lt.vilnius.coding.topsport.gui.LogInPage;

/**
 *
 * @author Dalia
 */
public class TopSport {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        createDBRecords();
        new LogInPage().setVisible(true);
    }

    private static void createDBRecords() throws ClassNotFoundException, SQLException {
        String dBQuery = "create table if not exists TSusers\n"
                + "(\n"
                + "Rec_ID int auto_increment primary key,\n"
                + "UserName varchar(225) not null unique,\n"
                + "Password varchar(225) not null,\n"
                + "FirstName varchar(225) not null,\n"
                + "LastName varchar(225) not null,\n"
                + "PhoneNumber varchar(225),\n"
                + "Address varchar(225),\n"
                + "City varchar(225),\n"
                + "BDay date not null,\n"
                + "RegDate date,\n"
                + "Balance int\n"
                + ")";
        new DBConn().getStmt().executeUpdate(dBQuery);

        dBQuery = "create table if not exists Games\n"
                + "(\n"
                + "Rec_ID int auto_increment primary key,\n"
                + "Game varchar(225),\n"
                + "Price int, \n"
                + "Winnings int,\n"
                + "UserName varchar(225),\n"
                + "Played int,\n"
                + "Won int,\n"
                + "Date date\n"
                + ")";
        new DBConn().getStmt().executeUpdate(dBQuery);

        try {
            dBQuery = "INSERT INTO TSusers (UserName, Password, FirstName, LastName, BDay, Balance, RegDate)\n"
                    + "VALUES ('admin', 'admin', 'Admin', 'Admin ', '2000-01-01', 50, '2000-01-01');";
            new DBConn().getStmt().executeUpdate(dBQuery);

            dBQuery = "INSERT INTO games (Game, Price, Winnings) VALUES ('CoinToss', 1, 2);";
            new DBConn().getStmt().executeUpdate(dBQuery);

            dBQuery = "INSERT INTO games (Game, Price, Winnings) VALUES ('RollDice', 4, 15);";
            new DBConn().getStmt().executeUpdate(dBQuery);

            dBQuery = "INSERT INTO games (Game, Price, Winnings) VALUES ('DogRace', 2, 10);";
            new DBConn().getStmt().executeUpdate(dBQuery);

        } catch (ClassNotFoundException | SQLException e) {
        }
    }
}
