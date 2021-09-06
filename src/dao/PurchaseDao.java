/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.interfaces.PurchaseImp;
import database.Database;
import models.Med;
import models.Purchase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hamdan
 */
public class PurchaseDao implements PurchaseImp{
    Connection conn;
    
    final String insert = "insert into purchases values (null, ?,?,?)";
    final String all = "select * from purchases";
    final String med = "select * from med";
    final String medByName = "select * from med where name=?";
    final String medById = "select * from med where id=?";
    
    public PurchaseDao(){
        conn = Database.connection();
    }

    @Override
    public void insert(Purchase t) {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);
            stat.setString(1, t.getDate());
            stat.setInt(2, t.getTotal());
            stat.setString(3, t.getPurchaseCode());
            stat.executeUpdate();
            
            ResultSet rs = stat.getGeneratedKeys();
            
            while(rs.next()){
                t.setId(rs.getInt(PreparedStatement.RETURN_GENERATED_KEYS));
            }
        } catch (SQLException e){
            System.err.println(e);
        } finally {
            try {
                stat.close();
            } catch (SQLException e){
                System.err.println(e);
            }
        }
    }

    @Override
    public List<Purchase> all() {
        List<Purchase> lt = null;
        try {
            lt = new ArrayList<>();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(all);
            while(res.next()){
                Purchase t = new Purchase();
                t.setId(res.getInt(1));
                t.setDate(res.getString(2));
                t.setPurchaseCode(res.getString(3));
                lt.add(t);
            }
        } catch (SQLException e){
            System.err.println(e);
        }
        
        return lt;
    }

    @Override
    public List<Med> getMed() {
        List<Med> lm = null;
        try {
            lm = new ArrayList<Med>();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(med);
            while(res.next()){
                Med m = new Med();
                m.setId(res.getInt(1));
                m.setName(res.getString(2));
                lm.add(m);
            }
        } catch (SQLException e){
            System.err.println(e);
        }
        
        return lm;
    }

    @Override
    public List<Med> getMedByName(String name) {
        List<Med> lm = null;
        try {
            lm = new ArrayList<>();
            PreparedStatement stat = conn.prepareStatement(medByName);
            stat.setString(1, name);
            ResultSet res = stat.executeQuery();
            while(res.next()){
                Med m = new Med();
                m.setId(res.getInt(1));
                m.setName(res.getString(2));
                m.setDesctription(res.getString(3));
                m.setPrice(res.getInt(4));
                lm.add(m);
            }
        } catch (SQLException e){
            System.err.println(e);
        }
        
        return lm;
    }

    @Override
    public List<Med> getMedById(int id) {
        List<Med> lm = null;
        try {
            lm = new ArrayList<>();
            PreparedStatement stat = conn.prepareStatement(medById);
            stat.setInt(1, id);
            ResultSet res = stat.executeQuery();
            while(res.next()){
                Med m = new Med();
                m.setId(res.getInt(1));
                m.setName(res.getString(2));
                m.setDesctription(res.getString(3));
                m.setPrice(res.getInt(4));
                lm.add(m);
            }
        } catch (SQLException e){
            System.err.println(e);
        }
        
        return lm;
    }
}
