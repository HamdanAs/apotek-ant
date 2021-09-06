package controllers;

import dao.ReportDao;
import dao.interfaces.ReportImp;
import views.MainFrm;


/**
 *
 * @author NESAS
 */
public class ReportController {
    
    private final MainFrm frame;
    private final ReportImp reportImp;
    
    public ReportController(MainFrm frame){
        this.frame = frame;
        
        reportImp = new ReportDao();
    }
    
    public void getSellDailyReport(){
        
    }
    
}
