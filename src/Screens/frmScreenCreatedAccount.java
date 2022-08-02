package Screens;

import DataBaseController.DBController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class frmScreenCreatedAccount extends javax.swing.JFrame {

    public frmScreenCreatedAccount() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelarCriarConta = new javax.swing.JButton();
        btnConfirmarCriarConta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtEmailCriarConta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNomeCriarConta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pfldSenhaCriarConta = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        txtNicknameCriarConta = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Stym Create Account");
        setResizable(false);

        btnCancelarCriarConta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8-desfazer-20.png"))); // NOI18N
        btnCancelarCriarConta.setText("Cancelar");
        btnCancelarCriarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCriarContaActionPerformed(evt);
            }
        });

        btnConfirmarCriarConta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8-salvar-20.png"))); // NOI18N
        btnConfirmarCriarConta.setText("Confirmar");
        btnConfirmarCriarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarCriarContaActionPerformed(evt);
            }
        });

        jLabel1.setText("E-mail");

        txtEmailCriarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailCriarContaActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome");

        txtNomeCriarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeCriarContaActionPerformed(evt);
            }
        });

        jLabel3.setText("Senha");

        pfldSenhaCriarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfldSenhaCriarContaActionPerformed(evt);
            }
        });

        jLabel4.setText("Nickname");

        txtNicknameCriarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNicknameCriarContaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnCancelarCriarConta, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(209, 209, 209)
                            .addComponent(btnConfirmarCriarConta, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEmailCriarConta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(67, 67, 67)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(txtNomeCriarConta)
                                .addComponent(jLabel4)
                                .addComponent(txtNicknameCriarConta, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))))
                    .addComponent(pfldSenhaCriarConta, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmailCriarConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeCriarConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pfldSenhaCriarConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNicknameCriarConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmarCriarConta)
                    .addComponent(btnCancelarCriarConta))
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarCriarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCriarContaActionPerformed
        txtEmailCriarConta.setText("");
        pfldSenhaCriarConta.setText("");
        txtNomeCriarConta.setText("");
        txtNicknameCriarConta.setText("");
        this.dispose();
    }//GEN-LAST:event_btnCancelarCriarContaActionPerformed

    private void txtEmailCriarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailCriarContaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailCriarContaActionPerformed

    private void txtNomeCriarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeCriarContaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeCriarContaActionPerformed

    private void pfldSenhaCriarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfldSenhaCriarContaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pfldSenhaCriarContaActionPerformed

    private void txtNicknameCriarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNicknameCriarContaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNicknameCriarContaActionPerformed
    // Botão que Realiza o Cadastro da Conta
    private void btnConfirmarCriarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarCriarContaActionPerformed
        try {
            singUpUSerDataBase();
        } catch (Exception ex) {
            Logger.getLogger(frmScreenCreatedAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConfirmarCriarContaActionPerformed

    // Realiza o Cadastro da Conta
    public void singUpUSerDataBase() throws Exception {
        DBController database = new DBController("database.db");
        
        String emailUser =  txtEmailCriarConta.getText();
        String passwordUser = pfldSenhaCriarConta.getText();
        String nameUser = txtNomeCriarConta.getText();
        String nicknameUser = txtNicknameCriarConta.getText();
        boolean flag = false;
        
        database.dbConnect();
        flag = database.comparationQueryCreatedAccount(emailUser, passwordUser);
        
        if(flag) {
           if(emailUser.isEmpty() || passwordUser.isEmpty() || nameUser.isEmpty() || nicknameUser.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos os Campos Devem ser Preenchidos!");;
           }else {
                database.insertUserDataBase(emailUser, passwordUser, nameUser,  nicknameUser);
                txtEmailCriarConta.setText("");
                pfldSenhaCriarConta.setText("");
                txtNomeCriarConta.setText("");
                txtNicknameCriarConta.setText("");
                this.dispose();
           }
        }else {
            JOptionPane.showMessageDialog(this, "E-mail ou Nickname já utilizados");
        }
        database.dbDisconnect();
        
    }
    
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
            java.util.logging.Logger.getLogger(frmScreenCreatedAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmScreenCreatedAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmScreenCreatedAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmScreenCreatedAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new frmScreenCreatedAccount().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarCriarConta;
    private javax.swing.JButton btnConfirmarCriarConta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField pfldSenhaCriarConta;
    private javax.swing.JTextField txtEmailCriarConta;
    private javax.swing.JTextField txtNicknameCriarConta;
    private javax.swing.JTextField txtNomeCriarConta;
    // End of variables declaration//GEN-END:variables
}
