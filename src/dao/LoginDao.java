/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.interfaces.LoginImp;
import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Login;

/**
 *
 * @author Gawrgura
 */
public class LoginDao implements LoginImp{
    Connection conn;
    
    private final String info = "select * from user where username = ? and password = ?";
    
    public LoginDao(){
        conn = Database.connection();
    }

    @Override
    public List<Login> getInfo(String username, String password) {
        List<Login> list = null;
        try {
            list = new ArrayList<>();
            PreparedStatement stat = conn.prepareStatement(info);
            stat.setString(1, username);
            stat.setString(2, password);
            ResultSet res = stat.executeQuery();
            while(res.next()){
                Login l = new Login();
                l.setUsername(res.getString(2));
                l.setPassword(res.getString(3));
                
                list.add(l);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        
        return list;
    }
}
