/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder.report.impl;

import builder.report.abs.SellReport;

/**
 *
 * @author Gawrgura
 */
public class YearlySellReport extends SellReport{

    @Override
    public String folderName() {
        return "sell";
    }

    @Override
    public String name() {
        return "Laporan Penjualan Tahunan";
    }

    @Override
    public String type() {
        return "yearly";
    }

    @Override
    public String fileName() {
        return "laporan_detail_penjualan_tahunan.jrxml";
    }
    
}
