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
import dao.SupplierDao;
import dao.interfaces.InvoiceImp;
import dao.interfaces.MedImp;
import dao.interfaces.PurchDetailImp;
import dao.interfaces.PurchaseImp;
import dao.interfaces.SupplierImp;
import java.text.DecimalFormat;
import models.Invoice;
import models.Med;
import models.PurchaseDetail;
import models.Purchase;
import utilities.Date;
import utilities.InvoiceCode;
import utilities.Table;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import models.Supplier;
import utilities.Currency;
import views.Pembelian;

/**
 *
 * @author hamdan
 */
public class BuyController {
    private final Pembelian frame;
    private final PurchaseImp tImp;
    private final PurchDetailImp tdImp;
    private final InvoiceImp iImp;
    private final MedImp mImp;
    private final SupplierImp sImp;
    private final Table table;
    private List<Med> lm;
    private List<Supplier> ls;
    
    private enum State{
        isOpen,
        isNotOpen
    }
    
    private State currentState;
    private int changes;
    private boolean passChanges = false;
    private int chargeTotal;
    
    public BuyController(Pembelian frame){
        this.frame = frame;
        tImp = new PurchaseDao();
        tdImp = new PurchDetailDao();
        iImp = new InvoiceDao();
        mImp = new MedDao();
        sImp = new SupplierDao();
        table = new Table(frame.getTblData());
        
        initTable();
        
        currentState = State.isNotOpen;
        
        frame.gettTanggal().setText(Date.now());
        frame.gettKode().setText(InvoiceCode.generate("PM", "purchase"));
    }
    
    private void initTable(){
        table.setColumn(new String[]{"ID Obat", "Nama Obat", "Harga Beli", "Harga Jual", "Qty", "Total"});
        table.setColumnWidth(578, 10, 55, 15, 15, 5, 15);
        table.textCenter(0);
        table.textLeft(1);
        table.textCenter(2);
        table.textCenter(3);
        table.textCenter(4);
        table.textCenter(5);
    }
    
    public void Open(){
        currentState = State.isOpen;
    }
    
    public void savePurchase(){
        if(passChanges){
            
            Purchase t = new Purchase();
            t.setDate(Date.now());
            t.setSupplierId(0);
            t.setTotal(chargeTotal);
            t.setPurchaseCode(InvoiceCode.generate("PM", "purchase"));

            tImp.insert(t);

            System.out.println(t.getId());
            
            for (int i = 0; i < table.getRowCount(); i++){
                PurchaseDetail td = new PurchaseDetail();
                int medId = Integer.parseInt((String) table.getColumnValue(i, 0));
                int qty = Integer.parseInt((String) table.getColumnValue(i, 4));

                td.setMedId(medId);
                td.setQty(qty);
                td.setPurchaseId(t.getId());

                tdImp.insert(td);

                mImp.addStock(qty, medId);
            }

            Invoice i = new Invoice();

            i.setDate(Date.now());
            i.setSeq(InvoiceCode.getSequenceNum("purchase"));

            iImp.insert(i, "purchase");

            JOptionPane.showMessageDialog(frame, "Transaksi berhasil, Uang kembaliannya adalah " + changes, "Pembayaran berhasil", JOptionPane.INFORMATION_MESSAGE);
            reset();
        }
    }
    
    public void reset(){
        frame.gettNama().setText("");
        frame.gettQty().setText("");
        frame.gettTotal().setText("Rp. 0,00");
        frame.gettBayar().setText("");
        frame.gettKode().setText(InvoiceCode.generate("PM", "purchase"));
        
        table.clearRow();
    }
    
    public void clearInput(){
        frame.gettNama().setText("");
        frame.gettBeli().setText("");
        frame.gettJual().setText("");
        frame.gettId().setText("");
        frame.gettQty().setText("");
    }
    
    public void fillSupplierCombo(){
        frame.gettSupplier().removeAllItems();
        
        ls = sImp.all();
                
        ls.forEach(lm1 -> {
            frame.gettSupplier().addItem(lm1.getName());
        });
    }
    
    public void addRow(){
        lm = tImp.getMedByName((String) frame.gettNama().getText());
        
        String[] data = new String[6];
        
        if(frame.gettId().getText().equals("")){
            JOptionPane.showMessageDialog(frame, "Data obat tidak boleh kosong!", "Pembelian", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if(frame.gettQty().getText().equals("")){
            JOptionPane.showMessageDialog(frame, "Qty tidak boleh kosong!", "Pembelian", JOptionPane.WARNING_MESSAGE);
            frame.gettQty().requestFocus();
            return;
        }
        
        lm.forEach((lm1) -> {
            data[0] = Integer.toString(lm1.getId());
            data[1] = lm1.getName();
            data[2] = Integer.toString(lm1.getBasePrice());
            data[3] = Integer.toString(lm1.getPrice());
            data[4] = frame.gettQty().getText();
            data[5] = Integer.toString(lm1.getPrice() * Integer.parseInt(data[4]));
        });
        
        if(frame.gettNama().getText().equals("")){
            JOptionPane.showMessageDialog(frame, "Silahkan pilih data terlebih dahulu!");
        }
        
        table.addRow(data);
        
        clearInput();
    }
    
    public void deleteRow(){
        table.removeRow(frame.getTblData().getSelectedRow());
    }
    
    public void calculateTotal(){
        int total = 0;
        
        for(int i = 0; i < table.getRowCount(); i++){
            int amount = Integer.parseInt((String) table.getColumnValue(i, 5));
            total += amount;
        }
        chargeTotal = total;
        
        String output = Currency.make(total);
        
        frame.gettTotal().setText(output);
    }
    
    public void calculateChanges(){
        int total = (int) chargeTotal;
        int pay = Integer.parseInt(frame.gettBayar().getText());
        
        if(pay < total){
            JOptionPane.showMessageDialog(frame, "Uang anda tidak cukup, uang yang harus dibayar adalah " + total, "Penjualan", JOptionPane.WARNING_MESSAGE);
            passChanges = false;
        } else {
            setChanges(pay - total);
            passChanges = true;
        }
    }
    
    private void setChanges(int changes){
        this.changes = changes;
    }
    
    public void getMedById(){
        lm = tImp.getMedById(frame.gettId().getText());
        
        if(lm.isEmpty()){
            JOptionPane.showMessageDialog(frame, "Data obat tidak ditemukan!", "Data Obat", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        frame.gettNama().setText(lm.get(0).getName());
        frame.gettBeli().setText(Integer.toString(lm.get(0).getBasePrice()));
        frame.gettJual().setText(Integer.toString(lm.get(0).getPrice()));
    }
    
    public void getMedByName(){
        lm = tImp.getMedByName((String) frame.gettNama().getText());
        
        if(!lm.isEmpty()){
            frame.gettNama().setText(lm.get(0).getName());
            frame.gettId().setText(Integer.toString(lm.get(0).getId()));
            frame.gettBeli().setText(Integer.toString(lm.get(0).getBasePrice()));
            frame.gettJual().setText(Integer.toString(lm.get(0).getPrice()));
        }
    }
}
