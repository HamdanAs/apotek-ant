/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.InvoiceDao;
import dao.MedDao;
import dao.TransDetailDao;
import dao.TransactionDao;
import dao.interfaces.InvoiceImp;
import dao.interfaces.MedImp;
import dao.interfaces.TransDetailImp;
import dao.interfaces.TransactionImp;
import models.Invoice;
import models.Med;
import models.Transaction;
import models.TransactionDetail;
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
public class SellController {
    private final MainFrm frame;
    private final TransactionImp tImp;
    private final TransDetailImp tdImp;
    private final InvoiceImp iImp;
    private final MedImp mImp;
    private final Table table;
    private List<Med> lm;
    
    public SellController(MainFrm frame){
        this.frame = frame;
        tImp = new TransactionDao();
        tdImp = new TransDetailDao();
        iImp = new InvoiceDao();
        mImp = new MedDao();
        
        table = new Table(frame.getSell_table());
        table.setColumn(new String[]{"ID Obat", "Nama Obat", "Harga", "Qty", "Total"});
        table.setColumnWidth(578, 10, 55, 15, 5, 15);
        table.textCenter(0);
        table.textLeft(1);
        table.textCenter(2);
        table.textCenter(3);
        table.textCenter(4);
    }
    
    public void saveTransaction(){
        Transaction t = new Transaction();
        t.setDate(Date.now());
        t.setTotal(Integer.parseInt(frame.getSell_tTotal().getText()));
        t.setTransactionCode(InvoiceCode.generate("PJ", "transaction"));

        tImp.insert(t);
        
        for (int i = 0; i < table.getRowCount(); i++){
            TransactionDetail td = new TransactionDetail();
            int medId = Integer.parseInt((String) table.getColumnValue(i, 0));
            int qty = Integer.parseInt((String) table.getColumnValue(i, 3));
            
            td.setMedId(medId);
            td.setQty(qty);
            
            td.setTransactionId(t.getId());
            
            tdImp.insert(td);
            
            mImp.subStock(qty, medId);
        }
        
        Invoice i = new Invoice();
        
        i.setDate(Date.now());
        i.setSeq(InvoiceCode.getSequenceNum("transaction"));
        
        iImp.insert(i, "transaction");
        
        JOptionPane.showMessageDialog(null, "Data telah tersimpan", "Pembayaran berhasil", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void reset(){
        frame.getSell_tName().setSelectedItem("");
        frame.getSell_tQty().setText("");
        frame.getSell_tTotal().setText("");
        
        table.clearRow();
    }
    
    public void clearInput(){
        frame.getSell_tQty().setText("");
    }
    
    public void fillCombo(){
        
        lm = tImp.getMed();
        
        lm.forEach(lm1 -> {
            frame.getSell_tName().addItem(lm1.getName());
        });
        
    }
    
    public void addRow(){
        lm = tImp.getMedById(Integer.parseInt(frame.getBuy_tId().getText()));
        
        String[] data = new String[5];
        
        lm.forEach((lm1) -> {
            data[0] = Integer.toString(lm1.getId());
            data[1] = lm1.getName();
            data[2] = Integer.toString(lm1.getPrice());
            data[3] = frame.getSell_tQty().getText();
            data[4] = Integer.toString(lm1.getPrice() * Integer.parseInt(data[3]));
        });
        
        table.addRow(data);
    }
    
    public void deleteRow(){
        table.removeRow(frame.getSell_table().getSelectedRow());
    }
    
    public void calculateTotal(){
        int total = 0;
        
        for(int i = 0; i < table.getRowCount(); i++){
            int amount = Integer.parseInt((String) table.getColumnValue(i, 4));
            total += amount;
        }
        
        frame.getSell_tTotal().setText(Integer.toString(total));
    }
    
    public void getMedById(){
        lm = tImp.getMedById(Integer.parseInt(frame.getSell_tId().getText()));
        
        frame.getSell_tName().setSelectedItem(lm.get(0).getName());
    }
    
    public void getMedByName(){
        lm = tImp.getMedByName((String) frame.getSell_tName().getSelectedItem());
        
        frame.getSell_tId().setText(Integer.toString(lm.get(0).getId()));
    }
}
