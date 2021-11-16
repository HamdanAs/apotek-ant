/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.BuyController;
import controllers.SellController;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import utilities.Input;

/**
 *
 * @author Gawrgura
 */
public class Penjualan extends javax.swing.JFrame implements KeyListener{

    /**
     * Creates new form Penjualan
     */
    
    MainMenu frm;
    SellController controller;
    CariObat cariObat;
    public Penjualan() {
        initComponents();
        controller = new SellController(this);
        controller.reset();
        
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
//        controller.fillSupplierCombo();

        cariObat = new CariObat();
    }

    public JTextField gettBayar() {
        return tBayar;
    }

    public JTextField gettId() {
        return tId;
    }

    public JTextField gettJual() {
        return tJual;
    }

    public JTextField gettKode() {
        return tKode;
    }

    public JTextField gettNama() {
        return tNama;
    }

    public JTextField gettQty() {
        return tQty;
    }

    public JTextField gettTanggal() {
        return tTanggal;
    }

    public JLabel gettTotal() {
        return tTotal;
    }

    public JTable getTblData() {
        return tblData;
    }
    
    public void setOtherFrame(MainMenu frm){
        this.frm = frm;
    }

    public JTextField gettStok() {
        return tStok;
    }
    
    
    
    private void registerFunctionKey(KeyEvent e){
        Input.executeAction(e, KeyEvent.VK_F5, () -> {
            cariObat.setOtherFrame(this);
            cariObat.setVisible(true);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tQty = new javax.swing.JTextField();
        btnTambah = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        tBayar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        tNama = new javax.swing.JTextField();
        tJual = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tKode = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tTanggal = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        tTotal = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tStok = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(254, 241, 230));

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
        jLabel1.setText("Form Penjualan");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jLabel2.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("ID");

        tId.setEditable(false);
        tId.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        tId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tIdActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Nama Obat");

        jLabel5.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Qty");

        tQty.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        tQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tQtyKeyPressed(evt);
            }
        });

        btnTambah.setBackground(new java.awt.Color(52, 91, 99));
        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahMouseClicked(evt);
            }
        });
        btnTambah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnTambahKeyPressed(evt);
            }
        });
        btnTambah.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(212, 236, 221));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Tambah");
        btnTambah.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

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
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblData);

        tBayar.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        tBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tBayarKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Bayar");

        btnSimpan.setBackground(new java.awt.Color(52, 91, 99));
        btnSimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSimpanMouseClicked(evt);
            }
        });
        btnSimpan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(212, 236, 221));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Simpan");
        btnSimpan.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 32));

        tNama.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        tNama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tNamaKeyPressed(evt);
            }
        });

        tJual.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        tJual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tJualKeyPressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Harga Jual");

        tKode.setEditable(false);
        tKode.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Kode Penjualan");

        jLabel13.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Tanggal");

        tTanggal.setEditable(false);
        tTanggal.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(249, 213, 167));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        jLabel7.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Total");

        tTotal.setFont(new java.awt.Font("Poppins Medium", 0, 24)); // NOI18N
        tTotal.setForeground(new java.awt.Color(102, 102, 102));
        tTotal.setText("Total");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 105, Short.MAX_VALUE))
                    .addComponent(tTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel14.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Stok");

        tStok.setEditable(false);
        tStok.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        tStok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tStokKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tBayar)
                            .addComponent(btnSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tKode, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(tJual, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tStok, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tQty, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(25, 25, 25))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(tStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        this.dispose();
        cariObat.dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private int x, y;
    
    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        int xx = evt.getXOnScreen();
        int yy = evt.getYOnScreen();
        this.setLocation(xx - x, yy - y);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
        controller.addRow();
        controller.calculateTotal();
    }//GEN-LAST:event_btnTambahMouseClicked

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
        controller.deleteRow();
        controller.clearInput();
        controller.calculateTotal();
    }//GEN-LAST:event_tblDataMouseClicked

    private void btnSimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimpanMouseClicked
        controller.calculateChanges();
        controller.saveTransaction();
    }//GEN-LAST:event_btnSimpanMouseClicked

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
    }//GEN-LAST:event_formKeyPressed

    private void tNamaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tNamaKeyPressed
        registerFunctionKey(evt);
    }//GEN-LAST:event_tNamaKeyPressed

    private void tJualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tJualKeyPressed
        registerFunctionKey(evt);
    }//GEN-LAST:event_tJualKeyPressed

    private void tQtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tQtyKeyPressed
        registerFunctionKey(evt);
        
        Input.executeAction(evt, Input.ENTER, () -> {
            controller.addRow();
            controller.calculateTotal();
            tNama.requestFocus();
        });
    }//GEN-LAST:event_tQtyKeyPressed

    private void btnTambahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnTambahKeyPressed
        registerFunctionKey(evt);
    }//GEN-LAST:event_btnTambahKeyPressed

    private void tBayarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tBayarKeyPressed
        registerFunctionKey(evt);
    }//GEN-LAST:event_tBayarKeyPressed

    private void tIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tIdActionPerformed
        
    }//GEN-LAST:event_tIdActionPerformed

    private void tStokKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tStokKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tStokKeyPressed

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
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Penjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnSimpan;
    private javax.swing.JPanel btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JTextField tBayar;
    private javax.swing.JTextField tId;
    private javax.swing.JTextField tJual;
    private javax.swing.JTextField tKode;
    private javax.swing.JTextField tNama;
    private javax.swing.JTextField tQty;
    private javax.swing.JTextField tStok;
    private javax.swing.JTextField tTanggal;
    private javax.swing.JLabel tTotal;
    private javax.swing.JTable tblData;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        registerFunctionKey(ke);
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
}
