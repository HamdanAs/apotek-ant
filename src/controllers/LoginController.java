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
import models.Login;
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
        
        list = loginImp.getInfo(username, username);
        
        if(list.isEmpty()){
            JOptionPane.showMessageDialog(null, "Username salah!", "Login gagal", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if(list.get(0).getUsername().equals(username) && list.get(0).getPassword().equals(password)){
            MainFrm mainFrm = new MainFrm();
            mainFrm.setVisible(true);
            mainFrm.changeUsername(username);
            frame.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Password salah!", "Login gagal", JOptionPane.WARNING_MESSAGE);
        }
    }
}
