package View;

import Controller.Controller_Suplier;
import java.awt.event.KeyEvent;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MSuplier extends javax.swing.JFrame {

    Controller_Suplier controller;

    public MSuplier() {
        initComponents();
        setLocationRelativeTo(this);
        controller = new Controller_Suplier(this); 
        controller.reset(); 
      }

    public JTable getTblsuplier() {
        return tblsuplier;
    }

    public JTextArea getTxtalamat() {
        return txtalamat;
    }

    public JTextField getTxtkdsuplier() {
        return txtkdsuplier;
    }

    public JTextField getTxtnmsuplier() {
        return txtnmsuplier;
    }

    public JTextField getTxttelp() {
        return txttelp;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtkdsuplier = new javax.swing.JTextField();
        txtnmsuplier = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtalamat = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblsuplier = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        cmdbatal = new javax.swing.JButton();
        cmdsimpan = new javax.swing.JButton();
        cmdubah = new javax.swing.JButton();
        cmdhapus = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txttelp = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 153));
        getContentPane().setLayout(null);

        jLabel2.setBackground(new java.awt.Color(0, 0, 153));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ENTRY DATA SUPLIER");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(170, 10, 330, 42);

        jLabel3.setBackground(new java.awt.Color(0, 0, 153));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Nama Suplier");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 130, 130, 42);

        jLabel1.setBackground(new java.awt.Color(0, 0, 153));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Alamat");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 170, 130, 40);

        jLabel6.setBackground(new java.awt.Color(0, 0, 153));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Kode Suplier");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 90, 130, 42);

        jLabel7.setBackground(new java.awt.Color(0, 0, 153));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText(":");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(160, 90, 20, 42);

        jLabel8.setBackground(new java.awt.Color(0, 0, 153));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText(":");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(160, 130, 20, 42);

        jLabel9.setBackground(new java.awt.Color(0, 0, 153));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText(":");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(160, 170, 20, 42);

        txtkdsuplier.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtkdsuplier.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtkdsuplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtkdsuplierKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtkdsuplierKeyReleased(evt);
            }
        });
        getContentPane().add(txtkdsuplier);
        txtkdsuplier.setBounds(190, 100, 160, 30);

        txtnmsuplier.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtnmsuplier.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtnmsuplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnmsuplierKeyPressed(evt);
            }
        });
        getContentPane().add(txtnmsuplier);
        txtnmsuplier.setBounds(190, 140, 290, 30);

        txtalamat.setColumns(20);
        txtalamat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtalamat.setRows(5);
        txtalamat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtalamat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtalamatKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(txtalamat);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(190, 180, 330, 50);

        tblsuplier.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblsuplier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblsuplier.setModel(new javax.swing.table.DefaultTableModel(
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
        tblsuplier.setRowHeight(23);
        tblsuplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblsuplierMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblsuplier);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 300, 670, 140);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cmdbatal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmdbatal.setText("BATAL");
        cmdbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdbatalActionPerformed(evt);
            }
        });

        cmdsimpan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmdsimpan.setText("SIMPAN");
        cmdsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdsimpanActionPerformed(evt);
            }
        });

        cmdubah.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmdubah.setText("UBAH");
        cmdubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdubahActionPerformed(evt);
            }
        });

        cmdhapus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmdhapus.setText("HAPUS");
        cmdhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdhapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 128, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cmdsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmdubah, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmdhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmdbatal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 188, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(cmdsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(cmdubah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(cmdhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addComponent(cmdbatal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(560, 90, 130, 190);

        jLabel10.setBackground(new java.awt.Color(0, 0, 153));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("No. Telepon");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(20, 240, 130, 40);

        jLabel11.setBackground(new java.awt.Color(0, 0, 153));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText(":");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(160, 240, 20, 42);

        txttelp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txttelp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txttelp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttelpKeyPressed(evt);
            }
        });
        getContentPane().add(txttelp);
        txttelp.setBounds(190, 240, 160, 30);

        setSize(new java.awt.Dimension(723, 493));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdsimpanActionPerformed
        controller.insert();        
        controller.reset();        
    }//GEN-LAST:event_cmdsimpanActionPerformed

    private void cmdubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdubahActionPerformed
        controller.update();        
        controller.reset();        
    }//GEN-LAST:event_cmdubahActionPerformed

    private void cmdhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdhapusActionPerformed
        controller.delete();        
        controller.reset();        
    }//GEN-LAST:event_cmdhapusActionPerformed

    private void cmdbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdbatalActionPerformed
        controller.reset();        
    }//GEN-LAST:event_cmdbatalActionPerformed

    private void tblsuplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblsuplierMouseClicked
        controller.isiField(tblsuplier.getSelectedRow());
        this.txtnmsuplier.requestFocus();
    }//GEN-LAST:event_tblsuplierMouseClicked

    private void txtkdsuplierKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkdsuplierKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){      
            if(txtkdsuplier.getText().isEmpty()){
                controller.reset();  
            }
            else                   
                //controller.isiTable();
                controller.isiTableCari();
                this.txtnmsuplier.requestFocus();

    }   
    }//GEN-LAST:event_txtkdsuplierKeyPressed

    private void txtkdsuplierKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkdsuplierKeyReleased
        controller.isiTableCari();  
        txtnmsuplier.setText("");
        txtalamat.setText("");
        
    }//GEN-LAST:event_txtkdsuplierKeyReleased

    private void txtnmsuplierKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnmsuplierKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){      
              this.txtalamat.requestFocus();   
          }           
    }//GEN-LAST:event_txtnmsuplierKeyPressed

    private void txtalamatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtalamatKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){      
            this.txttelp.requestFocus();   
        }   
    }//GEN-LAST:event_txtalamatKeyPressed

    private void txttelpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelpKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelpKeyPressed

   
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
            java.util.logging.Logger.getLogger(MSuplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MSuplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MSuplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MSuplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new MSuplier().setVisible(true);                
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdbatal;
    private javax.swing.JButton cmdhapus;
    private javax.swing.JButton cmdsimpan;
    private javax.swing.JButton cmdubah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblsuplier;
    private javax.swing.JTextArea txtalamat;
    private javax.swing.JTextField txtkdsuplier;
    private javax.swing.JTextField txtnmsuplier;
    private javax.swing.JTextField txttelp;
    // End of variables declaration//GEN-END:variables


}
