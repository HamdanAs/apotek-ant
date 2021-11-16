/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.MedDao;
import dao.interfaces.MedImp;
import java.util.Arrays;
import java.util.HashMap;
import models.Med;
import models.tables.MedTable;
import utilities.Table;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import utilities.validator.Validator;
import views.CariObat;
import views.MenejemenObat;
import views.TambahObat;

/**
 *
 * @author hamdan
 */
public class MedController {
    MenejemenObat frame;
    TambahObat frame1;
    CariObat frame2;
    MedImp medImp;
    List<Med> lm;
    Table table;
    
    public MedController(MenejemenObat frame){
        this.frame = frame;
        medImp = new MedDao();
        lm = medImp.all();
        frame1 = new TambahObat();
        
        initTable();
    }
    
    public MedController(TambahObat frame){
        this.frame1 = frame;
        
        medImp = new MedDao();
        lm = medImp.all();
    }
    
    public MedController(CariObat frame){
        this.frame2 = frame;
        
        medImp = new MedDao();
        lm = medImp.all();
    }
    
    private void initTable(){
        table = new Table(frame.getTblData());
        table.setColumn(new String[]{"ID Obat", "Nama Obat", "Harga Beli", "Harga Jual", "Stock"});
        table.setColumnWidth(578, 10, 40, 20, 20, 10);
        table.textCenter(0);
        table.textLeft(1);
        table.textCenter(2);
        table.textCenter(3);
        table.textCenter(4);
    }
    
    public void reset(){
        frame1.gettId().setText("");
        frame1.gettNama().setText("");
        frame1.gettBeli().setText("");
        frame1.gettJual().setText("");
        frame1.gettDeskripsi().setText("");
    }
    
    public void fillTable(){
        table.clearRow();
        
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
    
    public void fillList(){
        String name = frame2.gettCari().getText();
        
        lm = medImp.find(name);
        String[] items = new String[lm.size()];
        
        for(int i = 0; i < lm.size(); i++){
            items[i] = Integer.toString(lm.get(i).getId()) + " - " +lm.get(i).getName();
        }
        
        frame2.getListObat().setListData(items);
    }
    
    public void initList(){
        lm = medImp.all();
        
        String[] items = new String[lm.size()];
        
        for(int i = 0; i < lm.size(); i++){
            items[i] = Integer.toString(lm.get(i).getId()) + " - " +lm.get(i).getName();
        }
        
        frame2.getListObat().setListData(items);
    }
    
    public String getIdFromList(){
        String item = frame2.getListObat().getSelectedValue();
        
        StringTokenizer st = new StringTokenizer(item, " - ");
        String id = st.nextToken();
        
        return id;
    }
    
    public String getNameFromList(){
        String item = frame2.getListObat().getSelectedValue();
        
        StringTokenizer st = new StringTokenizer(item, " - ");
        
        st.nextElement();
        
        return (String) st.nextElement();
    }
    
    public void fillField(int row){
        frame1.setOtherFrame(frame);
        frame1.setVisible(true);
        
        frame1.gettId().setText(Integer.toString(lm.get(row).getId()));
        frame1.gettNama().setText(lm.get(row).getName());
        frame1.gettBeli().setText(Integer.toString(lm.get(row).getBasePrice()));
        frame1.gettJual().setText(Integer.toString(lm.get(row).getPrice()));
        frame1.gettDeskripsi().setText(lm.get(row).getDesctription());
    }
    
    public void insert(){
        HashMap<JComponent, String> rules = new HashMap<>();
        rules.put(frame1.gettNama(), "required");
        rules.put(frame1.gettBeli(), "required");
        rules.put(frame1.gettJual(), "required");
        
        Validator validator = new Validator(rules);
        
        validator.validateHash();
        
        System.out.println(Arrays.toString(validator.getIsFail()));
        
        while(validator.fails()){
            JOptionPane.showMessageDialog(frame1, validator.getErrorMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            
            System.out.println(validator.fails());
            
            validator.validateHash();
            
            return;
        }
        
        Med m = new Med();
        m.setName(frame1.gettNama().getText());
        m.setDesctription(frame1.gettDeskripsi().getText());
        m.setBasePrice(Integer.parseInt(frame1.gettBeli().getText()));
        m.setPrice(Integer.parseInt(frame1.gettJual().getText()));

        lm = medImp.actualFind(m.getName());
        
        if(lm.isEmpty()){
            medImp.insert(m);

            JOptionPane.showMessageDialog(frame1, "Data tersimpan!", "Menejemen Obat", JOptionPane.INFORMATION_MESSAGE);

            reset();
        } else {
            JOptionPane.showMessageDialog(frame1, "Nama obat sudah ada didalam database!", "Menejemen Obat", JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
    public void update(){
        if(frame1.gettId().getText().equals("")){
            JOptionPane.showMessageDialog(frame, "Silahkan pilih data!", "Menejemen Obat", JOptionPane.WARNING_MESSAGE);
        } else {
            Med m = new Med();
            m.setName(frame1.gettNama().getText());
            m.setDesctription(frame1.gettDeskripsi().getText());
            m.setBasePrice(Integer.parseInt(frame1.gettBeli().getText()));
            m.setPrice(Integer.parseInt(frame1.gettJual().getText()));
            m.setId(Integer.parseInt(frame1.gettId().getText()));

            medImp.update(m);

            JOptionPane.showMessageDialog(null, "Data tersimpan!", "Menejemen Obat", JOptionPane.INFORMATION_MESSAGE);

            reset();
        }
    }
    
    public void delete(){
        if(!frame1.gettId().getText().trim().isEmpty()){
            if (JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menghapus data ini?") == JOptionPane.YES_OPTION) {
                int id = Integer.parseInt(frame1.gettId().getText());
                medImp.delete(id);
                
                reset();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Silahkan pilih data yang ingin dihapus");
        }
    }
    
    public void fillFindTable(){
        table.clearRow();
        
        lm = medImp.find(frame.gettCari().getText());
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
    
    public void find(){
        if(!frame.gettCari().getText().trim().isEmpty()){
            medImp.find(frame.gettCari().getText());
            fillFindTable();
        } else {
            JOptionPane.showMessageDialog(null, "Silahkan pilih data!");
        }
    }
}
