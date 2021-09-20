/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.MedDao;
import dao.interfaces.MedImp;
import java.util.HashMap;
import models.Med;
import models.tables.MedTable;
import utilities.Table;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import utilities.validator.Validator;
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
    }
    
    public void reset(){
        frame.getMed_tId().setText("");
        frame.getMed_tName().setText("");
        frame.getMed_tDescription().setText("");
        frame.getMed_tBasePrice().setText("");
        frame.getMed_tPrice().setText("");
        frame.getMed_tStock().setText("");
        frame.getMed_tSearch().setText("");
    }
    
    public void fillTable(){
        table = new Table(frame.getMed_table());
        table.setColumn(new String[]{"ID Obat", "Nama Obat", "Harga Beli", "Harga Jual", "Stock"});
        table.setColumnWidth(578, 10, 40, 20, 20, 10);
        table.textCenter(0);
        table.textLeft(1);
        table.textCenter(2);
        table.textCenter(3);
        table.textCenter(4);
        
        lm = medImp.all();
        
        lm.forEach((Med m) -> {
            Object[] o = new Object[]{
                m.getId(),
                m.getName(),
                m.getBasePrice(),
                m.getPrice(),
                m.getStock()
            };
            
            table.addRow(o);
        });
    }
    
    public void fillField(int row){
        frame.getMed_tId().setText(Integer.toString(lm.get(row).getId()));
        frame.getMed_tName().setText(lm.get(row).getName());
        frame.getMed_tStock().setText(Integer.toString(lm.get(row).getStock()));
        frame.getMed_tDescription().setText(lm.get(row).getDesctription());
        frame.getMed_tBasePrice().setText(Integer.toString(lm.get(row).getBasePrice()));
        frame.getMed_tPrice().setText(Integer.toString(lm.get(row).getPrice()));
    }
    
    public void insert(){
        HashMap<JComponent, String> rules = new HashMap<>();
        rules.put(frame.getMed_tName(), "required");
        rules.put(frame.getMed_tBasePrice(), "required");
        rules.put(frame.getMed_tPrice(), "required");
        
        Validator validator = new Validator(rules);
        
        validator.validateHash();
        
        while(validator.fails()){
            JOptionPane.showMessageDialog(frame, "Nama obat, harga jual dan harga beli harus diisi\nSilahkan Lengkapi!", "Error", JOptionPane.WARNING_MESSAGE);
            
            System.out.println(validator.fails());
            
            validator.validateHash();
            
            return;
        }
        
        Med m = new Med();
        m.setName(frame.getMed_tName().getText());
        m.setDesctription(frame.getMed_tDescription().getText());
        m.setBasePrice(Integer.parseInt(frame.getMed_tBasePrice().getText()));
        m.setPrice(Integer.parseInt(frame.getMed_tPrice().getText()));

        lm = medImp.find(frame.getMed_tName().getText());
        
        if(lm.isEmpty()){
            medImp.insert(m);

            JOptionPane.showMessageDialog(frame, "Data tersimpan!", "Menejemen Obat", JOptionPane.INFORMATION_MESSAGE);

            reset();
        } else {
            if(lm.get(0).getName().equals(m.getName())){
                JOptionPane.showMessageDialog(frame, "Nama obat sudah ada didalam database!", "Menejemen Obat", JOptionPane.WARNING_MESSAGE);
            }
        }
        
    }
    
    public void update(){
        if(frame.getMed_tId().getText().equals("")){
            JOptionPane.showMessageDialog(frame, "Silahkan pilih data!", "Menejemen Obat", JOptionPane.WARNING_MESSAGE);
        } else {
            Med m = new Med();
            m.setName(frame.getMed_tName().getText());
            m.setDesctription(frame.getMed_tDescription().getText());
            m.setBasePrice(Integer.parseInt(frame.getMed_tBasePrice().getText()));
            m.setPrice(Integer.parseInt(frame.getMed_tPrice().getText()));
            m.setId(Integer.parseInt(frame.getMed_tId().getText()));

            medImp.update(m);

            JOptionPane.showMessageDialog(null, "Data tersimpan!", "Menejemen Obat", JOptionPane.INFORMATION_MESSAGE);

            reset();
        }
    }
    
    public void delete(){
        if(!frame.getMed_tId().getText().trim().isEmpty()){
            if (JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menghapus data ini?") == JOptionPane.YES_OPTION) {
                int id = Integer.parseInt(frame.getMed_tId().getText());
                medImp.delete(id);
                
                reset();
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
