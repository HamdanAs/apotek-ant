/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder.report;

/**
 *
 * @author Gawrgura
 */
public interface Report {
    public static String PATH = "src/reports/";
    
    public String name();
    public String type();
    public String fileName();
}
