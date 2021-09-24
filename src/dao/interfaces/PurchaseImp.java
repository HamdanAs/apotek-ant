/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import models.Med;
import models.Purchase;
import java.util.List;

/**
 *
 * @author hamdan
 */
public interface PurchaseImp {
    public void insert(Purchase t);
    public List<Med> getMed();
    public List<Med> getMedByName(String name);
    public List<Med> getMedById(String id);
    public List<Purchase> all();
}
