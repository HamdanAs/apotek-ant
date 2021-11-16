/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.sun.glass.events.KeyEvent;
import controllers.MedController;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;
import utilities.Input;

/**
 *
 * @author Gawrgura
 */
public class CariObat extends javax.swing.JFrame {

    /**
     * Creates new form CariObat
     */
    
    MedController controller;
    Pembelian framePembelian;
    Penjualan framePenjualan;
    
    public CariObat() {
        initComponents();
        
        controller = new MedController(this);
        
        controller.initList();
    }

    public JList<String> getListObat() {
        return listObat;
    }

    public JTextField gettCari() {
        return tCari;
    }
    
    public void setOtherFrame(Pembelian frm){
        this.framePembelian = frm;
    }
    
    public void setOtherFrame(Penjualan frm){
        this.framePenjualan = frm;
    }
    
    private void registerFunctionKey(java.awt.event.KeyEvent e){
        Input.executeAction(e, java.awt.event.KeyEvent.VK_ESCAPE, () -> {
            this.dispose();
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listObat = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(254, 241, 230));

        tCari.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        tCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tCariKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tCariKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tCariKeyTyped(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        listObat.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        listObat.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        listObat.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listObat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listObatMouseClicked(evt);
            }
        });
        listObat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listObatKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(listObat);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tCari)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCariKeyPressed
        
    }//GEN-LAST:event_tCariKeyPressed

    private void tCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCariKeyReleased
        Input.executeAction(evt, Input.DOWN, () -> {
            listObat.requestFocus();
        });
        
        registerFunctionKey(evt);
        
        controller.fillList();
    }//GEN-LAST:event_tCariKeyReleased

    private void tCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCariKeyTyped
       
    }//GEN-LAST:event_tCariKeyTyped

    private void listObatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listObatKeyPressed
        Input.executeAction(evt, Input.ENTER, () -> {
            listObatMouseClicked(null);
        });
        
        registerFunctionKey(evt);
    }//GEN-LAST:event_listObatKeyPressed

    private void listObatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listObatMouseClicked
        if(framePembelian != null) {
            framePembelian.gettId().setText(controller.getIdFromList());
            framePembelian.controller.getMedById();
            framePembelian.gettQty().requestFocus();
    //            System.out.println(controller.getNameFromList());
            this.dispose();
        } else if(framePenjualan != null){
            framePenjualan.gettId().setText(controller.getIdFromList());
            framePenjualan.controller.getMedById();
            framePenjualan.gettQty().requestFocus();
    //            System.out.println(controller.getNameFromList());
            this.dispose();
        }
    }//GEN-LAST:event_listObatMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CariObat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CariObat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CariObat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CariObat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CariObat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listObat;
    private javax.swing.JTextField tCari;
    // End of variables declaration//GEN-END:variables
}
