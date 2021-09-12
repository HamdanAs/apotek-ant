/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.validator;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComponent;
import javax.swing.text.JTextComponent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Gawrgura
 */
public class Validator {
    private final JComponent field;
    private final JComponent[] fields;
    private final String rule;
    private boolean isFail;
    
    private final static String NOT_EMPTY_REGEX = ".*\\S.*"; 
    
    public Validator(String rule, JComponent field){
        this.rule = rule;
        this.field = field;
        this.fields = null;
    }
    
    public Validator(String rule, JComponent[] fields){
        this.rule = rule;
        this.field = null;
        this.fields = fields;
    }

    public void validate(){
        if(rule.equals("required")){
            checkRequired();
        }
    }
    
    public boolean fails(){
        return isFail;
    }
    
    private void checkRequired(){
        Pattern pattern = Pattern.compile(NOT_EMPTY_REGEX);
            
        if(field == null){
            for(JComponent f : fields){
                Matcher matcher;
                
                if(isPassword(f)){
                    matcher = pattern.matcher( new String(((JPasswordField) f).getPassword()) );
                } else {
                    matcher = pattern.matcher(((JTextField) f).getText());
                }
                
                isFail = !matcher.find(); 
            }
        } else {
            Matcher matcher = pattern.matcher(((JTextField) field).getText());

            isFail = !matcher.find();
        }
    }
    
    private boolean isPassword(JComponent c){
        return c instanceof JPasswordField;
    }
}
