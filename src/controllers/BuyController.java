/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.InvoiceDao;
import dao.MedDao;
import dao.PurchDetailDao;
import dao.PurchaseDao;
import dao.interfaces.InvoiceImp;
import dao.interfaces.MedImp;
import dao.interfaces.PurchDetailImp;
import dao.interfaces.PurchaseImp;
import models.Invoice;
import models.Med;
import models.PurchaseDetail;
import models.Purchase;
import utilities.Date;
import utilities.InvoiceCode;
import utilities.Table;
import java.util.List;
import javax.swing.JOptionPane;
import views.MainFrm;

/**
 *
 * @author hamdan
 */
public class BuyController {
    private final MainFrm frame;
    private final PurchaseImp pImp;
    private final PurchDetailImp pdImp;
    private final InvoiceImp iImp;
    private final MedImp mImp;
    private final Table table;
    private List<Med> lm;
    
    public BuyController(MainFrm frame){
        this.frame = frame;
        pImp = (PurchaseImp) new PurchaseDao();
        pdImp = (PurchDetailImp) new PurchDetailDao();
        iImp = (InvoiceImp) new InvoiceDao();
        mImp = (MedImp) new MedDao();
        
        table = new Table(frame.getBuy_table());
        table.setColumn(new String[]{"ID Obat", "Nama Obat", "Harga", "Qty", "Total"});
        table.setColumnWidth(578, 10, 55, 15, 5, 15);
        table.textCenter(0);
        table.textLeft(1);
        table.textCenter(2);
        table.textCenter(3);
        table.textCenter(4);
    }
    
    public void savePurchase(){
        Purchase t = new Purchase();
        t.setDate(Date.now());
        t.setTotal(Integer.parseInt(frame.getBuy_tTotal().getText()));
        t.setPurchaseCode(InvoiceCode.generate("PM", "purchase"));

        pImp.insert(t);
        
        for (int i = 0; i < table.getRowCount(); i++){
            PurchaseDetail td = new PurchaseDetail();
            int medId = Integer.parseInt((String) table.getColumnValue(i, 0));
            int qty = Integer.parseInt((String) table.getColumnValue(i, 3));
            
            td.setMedId(medId);
            td.setQty(qty);
            
            mImp.addStock(qty, medId);
            
            td.setPurchaseId(t.getId());
            
            pdImp.insert(td);
            
        }
        
        
        Invoice i = new Invoice();
        
        i.setDate(Date.now());
        i.setSeq(InvoiceCode.getSequenceNum("purchase"));
        
        iImp.insert(i, "purchase");
        
        JOptionPane.showMessageDialog(null, "Data telah tersimpan", "Pembayaran berhasil", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void reset(){
        frame.getBuy_tName().setSelectedItem("");
        frame.getBuy_tQty().setText("");
        frame.getBuy_tTotal().setText("");
        
        table.clearRow();
    }
    
    public void clearInput(){
        frame.getBuy_tQty().setText("");
    }
    
    public void fillCombo(){
        
        lm = pImp.getMed();
        
        lm.forEach(lm1 -> {
            frame.getBuy_tName().addItem(lm1.getName());
        });
        
    }
    
    public void getMedById(){
        lm = pImp.getMedById(frame.getBuy_tId().getText());
        
        if(lm.isEmpty()){
            JOptionPane.showMessageDialog(null, "Data obat tidak ditemukan!", "Data Obat", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        frame.getBuy_tStock().setText(Integer.toString(lm.get(0).getStock()));
        frame.getBuy_tName().setSelectedItem(lm.get(0).getName());
    }
    
    public void getMedByName(){
        lm = pImp.getMedByName((String) frame.getBuy_tName().getSelectedItem());
        
        if(lm.isEmpty()){
            JOptionPane.showMessageDialog(null, "Data obat tidak ditemukan!", "Data Obat", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        frame.getBuy_tName().setSelectedItem(lm.get(0).getName());
        frame.getBuy_tStock().setText(Integer.toString(lm.get(0).getStock()));
        frame.getBuy_tId().setText(Integer.toString(lm.get(0).getId()));
    }
    
    public void addRow(){
        lm = pImp.getMedById(frame.getBuy_tId().getText());
        
        String[] data = new String[5];
        
        lm.forEach((lm1) -> {
            data[0] = Integer.toString(lm1.getId());
            data[1] = lm1.getName();
            data[2] = Integer.toString(lm1.getPrice());
            data[3] = frame.getBuy_tQty().getText();
            data[4] = Integer.toString(lm1.getPrice() * Integer.parseInt(data[3]));
        });
        
        List<Med> ls = mImp.find((String) frame.getBuy_tName().getSelectedItem());
        
        if(ls.get(0).getStock() < Integer.parseInt(frame.getBuy_tQty().getText())){
            JOptionPane.showMessageDialog(frame, "Stok tidak mencukupi", "Penjualan", JOptionPane.WARNING_MESSAGE);
            frame.getBuy_tQty().requestFocus();
        } else {
            table.addRow(data);
        }
    }
    
    public void deleteRow(){
        table.removeRow(frame.getBuy_table().getSelectedRow());
    }
    
    public void calculateTotal(){
        int total = 0;
        
        for(int i = 0; i < table.getRowCount(); i++){
            int amount = Integer.parseInt((String) table.getColumnValue(i, 4));
            total += amount;
        }
        
        frame.getBuy_tTotal().setText(Integer.toString(total));
    }
}
