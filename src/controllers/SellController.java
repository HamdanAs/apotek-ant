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

/**
 *
 * @author hamdan
 */
public class SellController {
    private final TransactionImp tImp;
    private final TransDetailImp tdImp;
    private final InvoiceImp iImp;
    private final MedImp mImp;
    private final Table table;
    private List<Med> lm;
    
    public SellController(){
        tImp = (TransactionImp) new TransactionDao();
        tdImp = (TransDetailImp) new TransDetailDao();
        iImp = (InvoiceImp) new InvoiceDao();
        mImp = (MedImp) new MedDao();
        
        table = new Table(frame.getTransactionTable());
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
        t.setTotal(Integer.parseInt(frame.gettTotal().getText()));
        t.setTransactionCode(InvoiceCode.generate("PM", "transaction"));

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
    }
    
    public void reset(){
        frame.gettMedName().setSelectedItem("");
        frame.gettQty().setText("");
        frame.gettTotal().setText("");
        
        table.clearRow();
    }
    
    public void clearInput(){
        frame.gettQty().setText("");
    }
    
    public void fillCombo(){
        
        lm = tImp.getMed();
        
        lm.forEach(lm1 -> {
            frame.gettMedName().addItem(lm1.getName());
        });
        
    }
    
    public void addRow(){
        lm = tImp.getMedDetail((String) frame.gettMedName().getSelectedItem());
        
        String[] data = new String[5];
        
        lm.forEach((lm1) -> {
            data[0] = Integer.toString(lm1.getId());
            data[1] = lm1.getName();
            data[2] = Integer.toString(lm1.getPrice());
            data[3] = frame.gettQty().getText();
            data[4] = Integer.toString(lm1.getPrice() * Integer.parseInt(data[3]));
        });
        
        table.addRow(data);
    }
    
    public void deleteRow(){
        table.removeRow(frame.getTransactionTable().getSelectedRow());
    }
    
    public void calculateTotal(){
        int total = 0;
        
        for(int i = 0; i < table.getRowCount(); i++){
            int amount = Integer.parseInt((String) table.getColumnValue(i, 4));
            total += amount;
        }
        
        frame.gettTotal().setText(Integer.toString(total));
    }
}
