/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vilnius.coding.topsport.action;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Connection;

/**
 *
 * @author Dalia
 */
public class DBConn {

    public Statement getStmt() throws ClassNotFoundException, SQLException {
        Connection conn = connectToDB();
        Statement stmt = (Statement) conn.createStatement();
        return stmt;
    }

    private Connection connectToDB() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn
                = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/TopSportDB?user=root&password=root");
        return conn;
    }
}
