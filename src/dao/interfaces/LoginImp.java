/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import java.util.List;
import models.Login;

/**
 *
 * @author Gawrgura
 */
public interface LoginImp {
    public List<Login> getInfo(String username, String password);
}
