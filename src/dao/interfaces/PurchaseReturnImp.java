/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import models.Med;
import java.util.List;
import models.PurchaseReturn;

/**
 *
 * @author hamdan
 */
public interface PurchaseReturnImp {
    public void insert(PurchaseReturn t);
    public List<Med> getMed();
    public List<Med> getMedByName(String name);
    public List<Med> getMedById(String id);
    public List<PurchaseReturn> all();
}
