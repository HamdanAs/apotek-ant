/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.MedDao;
import dao.interfaces.MedImp;
import models.Med;
import models.tables.MedTable;
import utilities.Table;
import java.util.List;
import javax.swing.JOptionPane;
import views.MainFrm;

/**
 *
 * @author hamdan
 */
public class MedController {
    MainFrm frame;
    MedImp medImp;
    List<Med> lm;
    Table table;
    
    public MedController(MainFrm frame){
        this.frame = frame;
        medImp = new MedDao();
        lm = medImp.all();
        
        table = new Table(frame.getMed_table());
        table.setColumn(new String[]{"ID Obat", "Nama Obat", "Deskripsi", "Price", "Stock"});
        table.setColumnWidth(578, 10, 55, 15, 5, 15);
        table.textCenter(0);
        table.textLeft(1);
        table.textCenter(2);
        table.textCenter(3);
        table.textCenter(4);
    }
    
    public void reset(){
        frame.getMed_tId().setText("");
        frame.getMed_tName().setText("");
        frame.getMed_tDescription().setText("");
        frame.getMed_tPrice().setText("");
        frame.getMed_tStock().setText("");
        frame.getMed_tSearch().setText("");
    }
    
    public void fillTable(){
        lm = medImp.all();
        MedTable mt = new MedTable(lm);
        frame.getMed_table().setModel(mt);
    }
    
    public void fillField(int row){
        frame.getMed_tId().setText(Integer.toString(lm.get(row).getId()));
        frame.getMed_tName().setText(lm.get(row).getName());
        frame.getMed_tStock().setText(Integer.toString(lm.get(row).getStock()));
        frame.getMed_tDescription().setText(lm.get(row).getDesctription());
        frame.getMed_tPrice().setText(Integer.toString(lm.get(row).getPrice()));
    }
    
    public void insert(){
        Med m = new Med();
        m.setName(frame.getMed_tName().getText());
        m.setDesctription(frame.getMed_tDescription().getText());
        m.setPrice(Integer.parseInt(frame.getMed_tPrice().getText()));
        
        medImp.insert(m);
    }
    
    public void update(){
        Med m = new Med();
        m.setName(frame.getMed_tName().getText());
        m.setDesctription(frame.getMed_tDescription().getText());
        m.setPrice(Integer.parseInt(frame.getMed_tPrice().getText()));
        m.setId(Integer.parseInt(frame.getMed_tId().getText()));
        
        medImp.update(m);
    }
    
    public void delete(){
        if(!frame.getMed_tId().getText().trim().isEmpty()){
            if (JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menghapus data ini?") == JOptionPane.YES_OPTION) {
                int id = Integer.parseInt(frame.getMed_tId().getText());
                medImp.delete(id);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Silahkan pilih data yang ingin dihapus");
        }
    }
    
    public void fillFindTable(){
        lm = medImp.find(frame.getMed_tSearch().getText());
        MedTable mt = new MedTable(lm);
        frame.getMed_table().setModel(mt);
    }
    
    public void find(){
        if(!frame.getMed_tSearch().getText().trim().isEmpty()){
            medImp.find(frame.getMed_tSearch().getText());
            fillFindTable();
        } else {
            JOptionPane.showMessageDialog(null, "Silahkan pilih data!");
        }
    }
}
