/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

import builder.initializer.ReportInitializer;
import builder.report.impl.DailyBuyReport;
import builder.report.impl.DailySellReport;
import builder.report.impl.MonthlyBuyReport;
import builder.report.impl.MonthlySellReport;
import builder.report.impl.YearlyBuyReport;
import builder.report.impl.YearlySellReport;

/**
 *
 * @author Gawrgura
 */
public class ReportBuilder {
    private static final ReportBuilder OBJ = new ReportBuilder();
    private ReportBuilder(){}
    
    public static ReportBuilder getInstance(){
        return OBJ;
    }
    
    public ReportInitializer prepareSellReport(){
        ReportInitializer reportInitializer = new ReportInitializer();
        
        reportInitializer.addReport(new DailySellReport());
        reportInitializer.addReport(new MonthlySellReport());
        reportInitializer.addReport(new YearlySellReport());
        
        return reportInitializer;
    }
    
    public ReportInitializer prepareBuyReport(){
        ReportInitializer reportInitializer = new ReportInitializer();
        
        reportInitializer.addReport(new DailyBuyReport());
        reportInitializer.addReport(new MonthlyBuyReport());
        reportInitializer.addReport(new YearlyBuyReport());
        
        return reportInitializer;
    }
}
