/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author hamdan
 */
public class Database {
    static Connection conn;
    
    public static Connection connection(){
        if (conn == null){
            MysqlDataSource sql = new MysqlDataSource();
            sql.setDatabaseName("apotek");
            sql.setUser("root");
            sql.setPassword("root");
            
            try {
                conn = sql.getConnection();
            } catch (SQLException e){
                System.err.println(e);
                return null;
            }
        }

        return conn;
    }
}
