/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import javax.swing.text.JTextComponent;
import java.util.HashSet;
import javax.swing.JPasswordField;

/**
 *
 * @author Gawrgura
 */
public class Validator {
    private final HashSet<String> rules;
    private final String rule;
    private final JTextComponent[] fields;
    private final JPasswordField[] pass;
    private boolean isFail = false;
    
    public Validator(HashSet<String> rules, JTextComponent[] fields){
        this.rule = null;
        this.rules = rules;
        this.fields = fields;
        this.pass = null;
    }
    
    public Validator(String rule, JTextComponent[] fields){
        this.rules = null;
        this.rule = rule;
        this.fields = fields;
        this.pass = null;
    }
    
    public Validator(String rule, JTextComponent[] fields, JPasswordField[] pass){
        this.rules = null;
        this.rule = rule;
        this.fields = fields;
        this.pass = pass;
    }
    
    public void validate(){
        rules.forEach((r) -> {
            isFail = r.contains("required");
        });
    }
    
    public void validateOneRule(){
        for(JTextComponent field : fields){
            if(rule.equals("required")){
                if(field.getText().isEmpty()){
                    isFail = true;
                }
            }
        }
    }
    
    public void validateOneRuleWithPassword(){
        boolean isPass = false;
        
        for(JTextComponent field : fields){
            if(rule.equals("required")){
                isPass = !field.getText().isEmpty();
            }
        }
        
        if(isPass){
            for(JPasswordField p : pass){
                if(rule.equals("required")){
                    isFail = p.getPassword().length == 0;
                }
            }
        } else {
            isFail = true;
        }
    }
    
    public boolean isFail(){
        return isFail;
    }
}
