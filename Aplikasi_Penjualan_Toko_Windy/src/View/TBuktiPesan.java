
package View;
import Controller.Controller_BuktiPesan;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class TBuktiPesan extends javax.swing.JFrame {
       
    Controller_BuktiPesan controller;   
 
    public TBuktiPesan() {
        initComponents();
        setLocationRelativeTo(this);
        controller = new Controller_BuktiPesan(this);           
        controller.reset();
    }

    public JComboBox getCmbbarang() {
        return cmbbarang;
    }

    public JComboBox getCmbkategori() {
        return cmbkategori;
    }

    public JTable getTbldetil() {
        return tbldetil;
    }

    public JTextField getTxtharga() {
        return txtharga;
    }

    public JTextField getTxtkdbrg() {
        return txtkdbrg;
    }

    public JTextField getTxtkdkategori() {
        return txtkdkategori;
    }

    public JTextField getTxtnobp() {
        return txtnobp;
    }

    public JTextField getTxtqty() {
        return txtqty;
    }

    public JTextField getTxtstok() {
        return txtstok;
    }

    public JTextField getTxttglbp() {
        return txttglbp;
    }

    public JLabel getTxttotal() {
        return txttotal;
    }
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txttglbp = new javax.swing.JTextField();
        txtnobp = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        cmbkategori = new javax.swing.JComboBox();
        txtkdkategori = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cmbbarang = new javax.swing.JComboBox();
        txtharga = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtkdbrg = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtqty = new javax.swing.JTextField();
        txtstok = new javax.swing.JTextField();
        cmdadd = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txttotal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldetil = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        cmdbatal = new javax.swing.JButton();
        cmdsimpan = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jLabel3.setBackground(new java.awt.Color(0, 0, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CETAK BUKTI PESAN");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 0, 480, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(170, 10, 500, 40);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        jLabel8.setBackground(new java.awt.Color(0, 0, 153));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Tgl. Transaksi");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(10, 50, 100, 20);

        jLabel9.setBackground(new java.awt.Color(0, 0, 153));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("No. Transaksi");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(10, 10, 100, 20);

        txttglbp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txttglbp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txttglbp);
        txttglbp.setBounds(130, 50, 110, 30);

        txtnobp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtnobp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtnobp);
        txtnobp.setBounds(130, 10, 110, 30);

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText(":");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(110, 50, 20, 20);

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText(":");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(110, 10, 20, 20);

        jLabel32.setBackground(new java.awt.Color(0, 0, 153));
        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(51, 153, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel32.setText("Year-Month-Date");
        jPanel2.add(jLabel32);
        jLabel32.setBounds(250, 50, 100, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(20, 60, 360, 90);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(null);

        jLabel14.setBackground(new java.awt.Color(0, 0, 153));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Nama Kategori");
        jPanel4.add(jLabel14);
        jLabel14.setBounds(10, 20, 120, 20);

        cmbkategori.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbkategori.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Pilih-" }));
        cmbkategori.setBorder(null);
        cmbkategori.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbkategoriItemStateChanged(evt);
            }
        });
        jPanel4.add(cmbkategori);
        cmbkategori.setBounds(150, 20, 250, 30);

        txtkdkategori.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtkdkategori.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtkdkategori.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtkdkategori.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtkdkategoriKeyPressed(evt);
            }
        });
        jPanel4.add(txtkdkategori);
        txtkdkategori.setBounds(440, 20, 110, 30);

        jLabel15.setBackground(new java.awt.Color(0, 0, 153));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Harga");
        jPanel4.add(jLabel15);
        jLabel15.setBounds(10, 120, 120, 20);

        cmbbarang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbbarang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Pilih-" }));
        cmbbarang.setBorder(null);
        cmbbarang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbbarangItemStateChanged(evt);
            }
        });
        jPanel4.add(cmbbarang);
        cmbbarang.setBounds(150, 60, 250, 30);

        txtharga.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtharga.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtharga.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtharga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txthargaKeyPressed(evt);
            }
        });
        jPanel4.add(txtharga);
        txtharga.setBounds(150, 120, 160, 30);

        jLabel16.setBackground(new java.awt.Color(0, 0, 153));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Nama Barang");
        jPanel4.add(jLabel16);
        jLabel16.setBounds(10, 60, 120, 20);

        txtkdbrg.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtkdbrg.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtkdbrg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtkdbrg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtkdbrgKeyPressed(evt);
            }
        });
        jPanel4.add(txtkdbrg);
        txtkdbrg.setBounds(440, 60, 110, 30);

        jLabel17.setBackground(new java.awt.Color(0, 0, 153));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Qty");
        jPanel4.add(jLabel17);
        jLabel17.setBounds(10, 160, 120, 20);

        txtqty.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtqty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtqty.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtqty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtqtyKeyPressed(evt);
            }
        });
        jPanel4.add(txtqty);
        txtqty.setBounds(150, 160, 60, 30);

        txtstok.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtstok.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtstok.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(txtstok);
        txtstok.setBounds(380, 120, 60, 30);

        cmdadd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmdadd.setText("Add");
        cmdadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdaddActionPerformed(evt);
            }
        });
        cmdadd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmdaddKeyPressed(evt);
            }
        });
        jPanel4.add(cmdadd);
        cmdadd.setBounds(230, 160, 60, 30);

        jLabel19.setBackground(new java.awt.Color(0, 0, 153));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Stok");
        jPanel4.add(jLabel19);
        jLabel19.setBounds(320, 120, 40, 20);

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText(":");
        jPanel4.add(jLabel13);
        jLabel13.setBounds(130, 20, 20, 20);

        jLabel21.setBackground(new java.awt.Color(0, 0, 0));
        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText(":");
        jPanel4.add(jLabel21);
        jLabel21.setBounds(130, 60, 20, 20);

        jLabel22.setBackground(new java.awt.Color(0, 0, 0));
        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText(":");
        jPanel4.add(jLabel22);
        jLabel22.setBounds(130, 120, 20, 20);

        jLabel23.setBackground(new java.awt.Color(0, 0, 0));
        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText(":");
        jPanel4.add(jLabel23);
        jLabel23.setBounds(130, 160, 20, 20);

        jLabel28.setBackground(new java.awt.Color(0, 0, 0));
        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText(":");
        jPanel4.add(jLabel28);
        jLabel28.setBounds(360, 120, 20, 20);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(20, 160, 570, 200);

        txttotal.setBackground(java.awt.Color.yellow);
        txttotal.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        txttotal.setForeground(new java.awt.Color(0, 0, 204));
        txttotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttotal.setText("Rp. 0");
        txttotal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txttotal.setOpaque(true);
        getContentPane().add(txttotal);
        txttotal.setBounds(410, 60, 360, 90);

        tbldetil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbldetil.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbldetil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbldetil.setRowHeight(23);
        tbldetil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldetilMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbldetil);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 410, 760, 170);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(null);

        cmdbatal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmdbatal.setText("BATAL");
        cmdbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdbatalActionPerformed(evt);
            }
        });
        cmdbatal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmdbatalKeyPressed(evt);
            }
        });
        jPanel5.add(cmdbatal);
        cmdbatal.setBounds(30, 110, 110, 50);

        cmdsimpan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmdsimpan.setText("SIMPAN");
        cmdsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdsimpanActionPerformed(evt);
            }
        });
        cmdsimpan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmdsimpanKeyPressed(evt);
            }
        });
        jPanel5.add(cmdsimpan);
        cmdsimpan.setBounds(30, 40, 110, 50);

        getContentPane().add(jPanel5);
        jPanel5.setBounds(600, 160, 170, 200);

        jLabel25.setBackground(new java.awt.Color(0, 0, 153));
        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 0, 0));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("**Klik 2x pada baris data, untuk mengubah atau membatalkan pesanan");
        getContentPane().add(jLabel25);
        jLabel25.setBounds(320, 390, 460, 20);

        jLabel27.setBackground(new java.awt.Color(0, 0, 153));
        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(204, 0, 0));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Detil Belanja :");
        getContentPane().add(jLabel27);
        jLabel27.setBounds(20, 380, 240, 30);

        setSize(new java.awt.Dimension(805, 641));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbkategoriItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbkategoriItemStateChanged
        if (getCmbkategori().getSelectedIndex() >0) { //mengantisipasi apabila terdapat data kosong               
                 controller.reset2();  
                 controller.tampilkdkategori();
                 controller.isicombobarang();     
        } 
    }//GEN-LAST:event_cmbkategoriItemStateChanged

    private void cmbbarangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbbarangItemStateChanged
        if (getCmbbarang().getSelectedIndex() >0) { //mengantisipasi apabila terdapat data kosong                               
                controller.tampilkdbarang();                
                txtqty.requestFocus(); 
        }
    }//GEN-LAST:event_cmbbarangItemStateChanged

    private void tbldetilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldetilMouseClicked
         if (evt.getClickCount() == 2 ){    
                controller.resetrow();
                controller. hitung_grandtotal();
         }else {  
             controller.isiField(tbldetil.getSelectedRow());
         }
    }//GEN-LAST:event_tbldetilMouseClicked

    private void cmdaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdaddActionPerformed
        controller.isiTable();
        controller. hitung_grandtotal();
        controller.reset3();
    }//GEN-LAST:event_cmdaddActionPerformed

    private void cmdaddKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmdaddKeyPressed
        controller.isiTable();
        controller. hitung_grandtotal();
        controller.reset3();
    }//GEN-LAST:event_cmdaddKeyPressed

    private void cmdbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdbatalActionPerformed
        
        controller.reset();   
    }//GEN-LAST:event_cmdbatalActionPerformed

    private void cmdbatalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmdbatalKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){ 
        
            controller.reset();
          }  
    }//GEN-LAST:event_cmdbatalKeyPressed

    private void cmdsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdsimpanActionPerformed
        if ((!getTxtnobp().getText().isEmpty())
             && (getTbldetil().getRowCount()!=0)){   
            
                controller.simpan_transaksi();
                controller.simpan_detiltransaksi();
                controller.cetak();
                controller.reset();
            }
        else
            JOptionPane.showMessageDialog(null, "No. Transaksi atau Kode Pelanggan atau Detil Belanja, tidak boleh kosong!");                           
    }//GEN-LAST:event_cmdsimpanActionPerformed

    private void cmdsimpanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmdsimpanKeyPressed
        if ((!getTxtnobp().getText().isEmpty()) 
             && (getTbldetil().getRowCount()!=0)){ 
            
                controller.simpan_transaksi();
                controller.simpan_detiltransaksi();
                controller.cetak();
                controller.reset();
            }
        else
            JOptionPane.showMessageDialog(null, "No. Transaksi atau Kode Pelanggan atau Detil Belanja, tidak boleh kosong!");                           
    }//GEN-LAST:event_cmdsimpanKeyPressed

    private void txtkdkategoriKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkdkategoriKeyPressed
         if (evt.getKeyCode()==KeyEvent.VK_ENTER){ 
                txtkdbrg.setText("");
                txtharga.setText("");
                txtstok.setText("");
                txtqty.setText("");
                controller.tampilnmkategori();
                controller.isicombobarang();
                txtkdbrg.requestFocus();
          }  
    }//GEN-LAST:event_txtkdkategoriKeyPressed

    private void txtkdbrgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkdbrgKeyPressed
         if (evt.getKeyCode()==KeyEvent.VK_ENTER){             
  
             if ( getTxtkdbrg().getText().trim().isEmpty()){
                      txtharga.setText("");
                      txtstok.setText("");
                      txtqty.setText("");
                      controller.isicombobarang();                      
             }             
             else{
                      controller.tampilnmbarang();
                      controller.isicombobarang2();                            
             }             
          }  
    }//GEN-LAST:event_txtkdbrgKeyPressed

    private void txtqtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtqtyKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){ 
            cmdadd.requestFocus();
        }
    }//GEN-LAST:event_txtqtyKeyPressed

    private void txthargaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthargaKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){  
              txtqty.requestFocus();
          }  
    }//GEN-LAST:event_txthargaKeyPressed

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
            java.util.logging.Logger.getLogger(TBuktiPesan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TBuktiPesan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TBuktiPesan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TBuktiPesan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TBuktiPesan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbbarang;
    private javax.swing.JComboBox cmbkategori;
    private javax.swing.JButton cmdadd;
    private javax.swing.JButton cmdbatal;
    private javax.swing.JButton cmdsimpan;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbldetil;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtkdbrg;
    private javax.swing.JTextField txtkdkategori;
    private javax.swing.JTextField txtnobp;
    private javax.swing.JTextField txtqty;
    private javax.swing.JTextField txtstok;
    private javax.swing.JTextField txttglbp;
    private javax.swing.JLabel txttotal;
    // End of variables declaration//GEN-END:variables
}
