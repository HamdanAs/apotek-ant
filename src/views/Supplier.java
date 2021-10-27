/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import utilities.Colors;
import utilities.Input;

/**
 *
 * @author Gawrgura
 */
public class Supplier extends javax.swing.JFrame {

    /**
     * Creates new form Supplier
     */
    
    public Supplier() {
        initComponents();
        
        if(tId.getText().equals(""))
            btnDelete.setEnabled(false);
        
        tName.requestFocus();
    }

    public JTextArea gettAddress() {
        return tAddress;
    }

    public JTextField gettCity() {
        return tCity;
    }

    public JTextField gettContact() {
        return tContact;
    }

    public JTextField gettId() {
        return tId;
    }

    public JTextField gettName() {
        return tName;
    }

    public JTextField gettPhone() {
        return tPhone;
    }

    public JTextField gettPost() {
        return tPost;
    }

    public JTextField gettProvince() {
        return tProvince;
    }

    public JTextField gettSearch() {
        return tSearch;
    }

    public JTable getTblData() {
        return tblData;
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tContact = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tAddress = new javax.swing.JTextArea();
        tSearch = new javax.swing.JTextField();
        tCity = new javax.swing.JTextField();
        tProvince = new javax.swing.JTextField();
        tPost = new javax.swing.JTextField();
        tPhone = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tName = new javax.swing.JTextField();
        btnAdd = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        tId = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(249, 213, 167));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Poppins SemiBold", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Form Supplier");

        jLabel10.setFont(new java.awt.Font("Poppins ExtraBold", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(144, 170, 203));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("X");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 429, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, -1));

        jPanel3.setBackground(new java.awt.Color(254, 241, 230));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Cari Supplier");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 102, -1));

        tContact.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        tContact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tContactKeyPressed(evt);
            }
        });
        jPanel3.add(tContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 120, -1));

        jLabel3.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Alamat");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 102, -1));

        jLabel4.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Kota");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 102, -1));

        jLabel5.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Provinsi");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 102, -1));

        jLabel6.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Kode Pos");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 102, -1));

        jLabel7.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("No Telepon");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 102, -1));

        jLabel8.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Kontak");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 102, -1));

        tAddress.setColumns(20);
        tAddress.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        tAddress.setLineWrap(true);
        tAddress.setRows(3);
        tAddress.setWrapStyleWord(true);
        tAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tAddressKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tAddressKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tAddress);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 219, 76));

        tSearch.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jPanel3.add(tSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 220, -1));

        tCity.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        tCity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tCityKeyPressed(evt);
            }
        });
        jPanel3.add(tCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 125, -1));

        tProvince.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        tProvince.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tProvinceKeyPressed(evt);
            }
        });
        jPanel3.add(tProvince, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 125, -1));

        tPost.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        tPost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tPostKeyPressed(evt);
            }
        });
        jPanel3.add(tPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 60, -1));

        tPhone.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        tPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tPhoneKeyPressed(evt);
            }
        });
        jPanel3.add(tPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 120, -1));

        jLabel11.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Nama Supplier");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 102, -1));

        tName.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        tName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tNameKeyPressed(evt);
            }
        });
        jPanel3.add(tName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 125, -1));

        btnAdd.setBackground(new java.awt.Color(255, 176, 133));
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnAddFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnAddFocusLost(evt);
            }
        });
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        btnAdd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAddKeyPressed(evt);
            }
        });
        btnAdd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Tambah");
        btnAdd.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 30));

        jPanel3.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 90, -1));

        btnDelete.setBackground(new java.awt.Color(255, 176, 133));
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnDeleteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnDeleteFocusLost(evt);
            }
        });
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
        btnDelete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnDeleteKeyPressed(evt);
            }
        });
        btnDelete.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Hapus");
        btnDelete.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 30));

        jPanel3.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 90, -1));

        tId.setEditable(false);
        tId.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jPanel3.add(tId, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 50, -1));

        jLabel9.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("ID Supplier");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 102, -1));

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblData);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 320, 360));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 710, 460));

        getContentPane().add(jPanel1, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private int x, y;
    
    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        int xx = evt.getXOnScreen();
        int yy = evt.getYOnScreen();
        this.setLocation(xx - x, yy - y);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void tAddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tAddressKeyPressed
        Input.moveCursor(evt, tName, Input.UP);
        Input.moveCursor(evt, tCity, Input.DOWN_KEY);
    }//GEN-LAST:event_tAddressKeyPressed

    private void tAddressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tAddressKeyReleased

    }//GEN-LAST:event_tAddressKeyReleased

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        System.out.println("Hello");
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void tNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tNameKeyPressed
        Input.moveCursor(evt, tAddress, Input.DOWN_KEY);
    }//GEN-LAST:event_tNameKeyPressed

    private void tCityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCityKeyPressed
        Input.moveCursor(evt, tProvince, Input.DOWN_KEY);
        Input.moveCursor(evt, tAddress, Input.UP);
    }//GEN-LAST:event_tCityKeyPressed

    private void tProvinceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tProvinceKeyPressed
        Input.moveCursor(evt, tPost, Input.DOWN_KEY);
        Input.moveCursor(evt, tCity, Input.UP);
    }//GEN-LAST:event_tProvinceKeyPressed

    private void tPostKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tPostKeyPressed
        Input.moveCursor(evt, tPhone, Input.DOWN_KEY);
        Input.moveCursor(evt, tProvince, Input.UP);
    }//GEN-LAST:event_tPostKeyPressed

    private void tPhoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tPhoneKeyPressed
        Input.moveCursor(evt, tContact, Input.DOWN_KEY);
        Input.moveCursor(evt, tPost, Input.UP);
    }//GEN-LAST:event_tPhoneKeyPressed

    private void tContactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tContactKeyPressed
        Input.moveCursor(evt, btnAdd, Input.DOWN_KEY);
        Input.moveCursor(evt, tPhone, Input.UP);
    }//GEN-LAST:event_tContactKeyPressed

    private void btnAddFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnAddFocusGained
        Colors.changeBg(btnAdd, Colors.HOVER_COLOR);
    }//GEN-LAST:event_btnAddFocusGained

    private void btnAddFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnAddFocusLost
        Colors.changeBg(btnAdd, Colors.BUTTON_COLOR);
    }//GEN-LAST:event_btnAddFocusLost

    private void btnDeleteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnDeleteFocusGained
        Colors.changeBg(btnDelete, Colors.HOVER_COLOR);
    }//GEN-LAST:event_btnDeleteFocusGained

    private void btnDeleteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnDeleteFocusLost
        Colors.changeBg(btnDelete, Colors.BUTTON_COLOR);
    }//GEN-LAST:event_btnDeleteFocusLost

    private void btnAddKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddKeyPressed
        Input.moveCursor(evt, tContact, Input.UP);
        Input.executeAction(evt, Input.RIGHT, () -> {
            if(btnDelete.isEnabled()){
                btnDelete.requestFocus();
            }
        });
    }//GEN-LAST:event_btnAddKeyPressed

    private void btnDeleteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnDeleteKeyPressed
        
        Input.moveCursor(evt, tContact, Input.UP);
        Input.moveCursor(evt, btnAdd, Input.LEFT);
    }//GEN-LAST:event_btnDeleteKeyPressed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Supplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnAdd;
    private javax.swing.JPanel btnDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea tAddress;
    private javax.swing.JTextField tCity;
    private javax.swing.JTextField tContact;
    private javax.swing.JTextField tId;
    private javax.swing.JTextField tName;
    private javax.swing.JTextField tPhone;
    private javax.swing.JTextField tPost;
    private javax.swing.JTextField tProvince;
    private javax.swing.JTextField tSearch;
    private javax.swing.JTable tblData;
    // End of variables declaration//GEN-END:variables
}
