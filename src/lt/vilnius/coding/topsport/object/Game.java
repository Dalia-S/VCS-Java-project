/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vilnius.coding.topsport.object;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lt.vilnius.coding.topsport.action.DBConn;

/**
 *
 * @author Dalia
 */
public class Game {

    private String gameName;
    private int price;
    private int winnings;
    private String userName;
    private int played;
    private int won;
    private String date;

    public Game() {
    }

    public Game(int price, int winnings) {
        this.price = price;
        this.winnings = winnings;
    }

    public Game(String gameName, int price, int winnings, String userName, int played, int won, String date) {
        this.gameName = gameName;
        this.price = price;
        this.winnings = winnings;
        this.userName = userName;
        this.played = played;
        this.won = won;
        this.date = date;
    }

    public Game getDetails(String gameName) throws ClassNotFoundException, SQLException {
        String dBQuery = "SELECT * FROM games WHERE game = '" + gameName + "' and date is null";
        ResultSet rs = new DBConn().getStmt().executeQuery(dBQuery);
        rs.next();
        return new Game(rs.getInt("Price"), rs.getInt("Winnings"));
    }

    public void addGamePlayed(String gameName, String userName) {
        try {
            Game game = getDetails(gameName);
            String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String dBQuery = "INSERT INTO games (Game, Price, Winnings, UserName, Played, Won, Date)"
                    + "VALUES ('" + gameName + "', " + game.getPrice() + ", " + game.getWinnings() + ","
                    + "'" + userName + "', 1, 0, '" + today + "');";
            new DBConn().getStmt().executeUpdate(dBQuery);
        } catch (ClassNotFoundException | SQLException ex) {
        }
    }

    public void addGameWon(String gameName, String userName) {
        try {
            Game game = getDetails(gameName);
            String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String dBQuery = "INSERT INTO games (Game, Price, Winnings, UserName, Played, Won, Date)"
                    + "VALUES ('" + gameName + "', " + game.getPrice() + ", " + game.getWinnings() + ","
                    + "'" + userName + "', 1, 1, '" + today + "');";
            new DBConn().getStmt().executeUpdate(dBQuery);
        } catch (ClassNotFoundException | SQLException ex) {
        }
    }

    public String getGame() {
        return gameName;
    }

    public void setGame(String gameName) {
        this.gameName = gameName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWinnings() {
        return winnings;
    }

    public void setWinnings(int winnings) {
        this.winnings = winnings;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getWon() {
        return won;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
