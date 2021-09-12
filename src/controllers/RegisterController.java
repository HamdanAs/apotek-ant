package controllers;

import dao.LoginDao;
import dao.interfaces.LoginImp;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import models.Login;
import utilities.Validator;
import views.RegisterFrm;

/**
 *
 * @author NESAS
 */
public class RegisterController {
    private final RegisterFrm frame;
    private final LoginImp loginImp;
    private List<Login> list;
    
    public RegisterController(RegisterFrm frame){
        this.frame = frame;
        loginImp = new LoginDao();
    }
    
    public void clear(){
        frame.gettUsername().setText("");
        frame.gettPassword().setText("");
        frame.gettConfirmPassword().setText("");
    }
    
    public void register(){
        String username = frame.gettUsername().getText();
        String password = new String(frame.gettPassword().getPassword());
        String confirmPassword = new String(frame.gettConfirmPassword().getPassword());
        
        Validator validator = new Validator("required", new  JTextField[]{frame.gettUsername()}, new JPasswordField[]{frame.gettPassword(), frame.gettConfirmPassword()});
        
        validator.validateOneRuleWithPassword();
        
        if(validator.isFail()){
            JOptionPane.showMessageDialog(null, "Data harus lengkap!", "Register", JOptionPane.WARNING_MESSAGE);
        } else {
            if(!password.equals(confirmPassword)){
                JOptionPane.showMessageDialog(null, "Password dan Konfirmasi Password tidak sama!", "Register", JOptionPane.WARNING_MESSAGE);
            } else {
                Login l = new Login();
                l.setUsername(username);
                l.setPassword(password);
                l.setLevel(2);

                loginImp.insert(l);

                clear();

                JOptionPane.showMessageDialog(null, "Akun berhasil didaftarkan! silahkan login", "Register", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
