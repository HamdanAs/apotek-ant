package controllers;

import dao.ReportDao;
import dao.interfaces.ReportImp;
import database.Database;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import views.MainFrm;


/**
 *
 * @author NESAS
 */
public class ReportController {
    
    private final MainFrm frame;
    private final ReportImp reportImp;
    private final Connection conn;
    private List<String> listSell;
    
    public ReportController(MainFrm frame){
        this.frame = frame;
        this.conn = Database.connection();
        
        reportImp = new ReportDao();
    }
    
    public void setSellDate(){
        listSell = reportImp.loadDateSell();
        
        frame.getReport_SellDate().addItem("Pilih tanggal");
        
        listSell.forEach((list) -> {
            frame.getReport_SellDate().addItem(list);
        });
    }
    
    public void setSellMonth(){
        listSell = reportImp.loadMonthSell();
        
        frame.getReport_SellMonth().addItem("Pilih bulan");
        
        listSell.forEach((list) -> {
            frame.getReport_SellMonth().addItem(list);
        });
    }
    
    public void setSellYear(){
        listSell = reportImp.loadYearSell();
        
        frame.getReport_SellYear().addItem("Pilih tahun");
        
        listSell.forEach((list) -> {
            frame.getReport_SellYear().addItem(list);
            frame.getReport_SellMonth1().addItem(list);
        });
    }
    
    public void setBuyDate(){
        listSell = reportImp.loadDateBuy();
        
        frame.getReport_BuyDate().addItem("Pilih tanggal");
        
        listSell.forEach((list) -> {
            frame.getReport_BuyDate().addItem(list);
        });
    }
    
    public void setBuyMonth(){
        listSell = reportImp.loadMonthBuy();
        
        frame.getReport_BuyMonth().addItem("Pilih bulan");
        
        listSell.forEach((list) -> {
            frame.getReport_BuyMonth().addItem(list);
        });
    }
    
    public void setBuyYear(){
        listSell = reportImp.loadYearBuy();
        
        frame.getReport_BuyYear().addItem("Pilih tahun");
        
        listSell.forEach((list) -> {
            frame.getReport_BuyYear().addItem(list);
            frame.getReport_BuyMonth1().addItem(list);
        });
    }
    
    public void getSellDailyReport(){
        if(frame.getReport_SellDate().getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Silahkan pilih dulu tanggal", "Laporan", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                
                String date = frame.getReport_SellDate().getSelectedItem().toString();
                Date newDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
                
                String jrxmlFile = "src/reports/laporan_detail_penjualan_harian.jrxml";
                HashMap param = new HashMap();
                param.put("date", newDate);
                JasperReport jr = JasperCompileManager.compileReport(jrxmlFile);
                JasperPrint print = JasperFillManager.fillReport(jr, param, conn);
                JasperViewer.viewReport(print, false);
            } catch (JRException | ParseException e){
                System.err.println(e);
            }
        }
    }
    
    public void getSellMonthlyReport(){
        if(frame.getReport_SellMonth().getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Silahkan pilih dulu bulan", "Laporan", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                String jrxmlFile = "src/reports/laporan_detail_penjualan_bulanan.jrxml";
                HashMap param = new HashMap();
                param.put("imageDir", "src/reports/");
                param.put("month", Integer.parseInt(frame.getReport_SellMonth().getSelectedItem().toString()));
                param.put("year", Integer.parseInt(frame.getReport_SellMonth1().getSelectedItem().toString()));
                JasperReport jr = JasperCompileManager.compileReport(jrxmlFile);
                JasperPrint print = JasperFillManager.fillReport(jr, param, conn);
                JasperViewer.viewReport(print, false);
            } catch (JRException e){
                System.err.println(e);
            }
        }
    }
    
    public void getSellYearlyReport(){
        if(frame.getReport_SellYear().getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Silahkan pilih dulu tahun", "Laporan", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                String jrxmlFile = "src/reports/laporan_detail_penjualan_tahunan.jrxml";
                HashMap param = new HashMap();
                param.put("year", Integer.parseInt(frame.getReport_SellYear().getSelectedItem().toString()));
                JasperReport jr = JasperCompileManager.compileReport(jrxmlFile);
                JasperPrint print = JasperFillManager.fillReport(jr, param, conn);
                JasperViewer.viewReport(print, false);
            } catch (JRException e){
                System.err.println(e);
            }
        }
    }
    
    public void getBuyDailyReport(){
        if(frame.getReport_BuyDate().getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Silahkan pilih dulu tanggal", "Laporan", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                
                String date = frame.getReport_BuyDate().getSelectedItem().toString();
                Date newDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
                
                String jrxmlFile = "src/reports/laporan_pembelian_harian.jrxml";
                HashMap param = new HashMap();
                param.put("date", newDate);
                JasperReport jr = JasperCompileManager.compileReport(jrxmlFile);
                JasperPrint print = JasperFillManager.fillReport(jr, param, conn);
                JasperViewer.viewReport(print, false);
            } catch (JRException | ParseException e){
                System.err.println(e);
            }
        }
    }
    
    public void getBuyMonthlyReport(){
        if(frame.getReport_BuyMonth().getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Silahkan pilih dulu bulan", "Laporan", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                String jrxmlFile = "src/reports/laporan_pembelian_bulanan.jrxml";
                HashMap param = new HashMap();
                param.put("month", Integer.parseInt(frame.getReport_BuyMonth().getSelectedItem().toString()));
                param.put("year", Integer.parseInt(frame.getReport_BuyMonth1().getSelectedItem().toString()));
                JasperReport jr = JasperCompileManager.compileReport(jrxmlFile);
                JasperPrint print = JasperFillManager.fillReport(jr, param, conn);
                JasperViewer.viewReport(print, false);
            } catch (JRException e){
                System.err.println(e);
            }
        }
    }
    
    public void getBuyYearlyReport(){
        if(frame.getReport_BuyYear().getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Silahkan pilih dulu tahun", "Laporan", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                String jrxmlFile = "src/reports/laporan_pembelian_tahunan.jrxml";
                HashMap param = new HashMap();
                param.put("year", Integer.parseInt(frame.getReport_BuyYear().getSelectedItem().toString()));
                JasperReport jr = JasperCompileManager.compileReport(jrxmlFile);
                JasperPrint print = JasperFillManager.fillReport(jr, param, conn);
                JasperViewer.viewReport(print, false);
            } catch (JRException e){
                System.err.println(e);
            }
        }
    }

    public void getMedReport() {
        try {
            String jrxmlFile = "src/reports/apotek_obat.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(jrxmlFile);
            JasperPrint print = JasperFillManager.fillReport(jr, null, conn);
            JasperViewer.viewReport(print, false);
        } catch (JRException e){
            System.err.println(e);
        }
    }
}
