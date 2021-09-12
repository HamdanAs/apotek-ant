/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.LoginDao;
import dao.interfaces.LoginImp;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import models.Login;
import utilities.validator.Validator;
import views.LoginFrm;
import views.MainFrm;

/**
 *
 * @author Gawrgura
 */
public class LoginController {
    private final LoginFrm frame;
    private final LoginImp loginImp;
    private List<Login> list;
    
    public LoginController(LoginFrm frame){
        this.frame = frame;
        loginImp = new LoginDao();
    }
    
    public void login(){
        String username = frame.gettUsername().getText();
        String password = new String(frame.gettPassword().getPassword());
        
        list = loginImp.getInfo(username, password);
        
        if(list.isEmpty()){
            JOptionPane.showMessageDialog(null, "Login Gagal! Silahkan masukan data yang benar!", "Login gagal", JOptionPane.WARNING_MESSAGE);
        } else {
            MainFrm mainFrm = new MainFrm();
            mainFrm.setVisible(true);
            mainFrm.changeUsername(username);
            mainFrm.setUsername(username);
            mainFrm.setId(list.get(0).getId());
            mainFrm.setLevel(list.get(0).getLevel());
            mainFrm.checkLevel();
            frame.dispose();
        }
    }
}
