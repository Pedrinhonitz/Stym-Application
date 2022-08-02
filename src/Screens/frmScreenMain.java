package Screens;

import DataBaseController.DBController;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class frmScreenMain extends javax.swing.JFrame {

    public frmScreenMain() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEntrarConta = new javax.swing.JButton();
        btnCriarConta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtEmailLogin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pfldSenhaLogin = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        textLoginInvalido = new javax.swing.JLabel();
        txtLoginInvalid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stym Login");
        setResizable(false);

        btnEntrarConta.setText("Entrar");
        btnEntrarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarContaActionPerformed(evt);
            }
        });

        btnCriarConta.setText("Criar Conta");
        btnCriarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarContaActionPerformed(evt);
            }
        });

        jLabel1.setText("E-mail");

        jLabel2.setText("Senha");

        txtLoginInvalid.setEditable(false);
        txtLoginInvalid.setForeground(new java.awt.Color(255, 51, 51));
        txtLoginInvalid.setText("  ");
        txtLoginInvalid.setBorder(null);
        txtLoginInvalid.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtLoginInvalid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginInvalidActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCriarConta, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(btnEntrarConta, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtEmailLogin)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(pfldSenhaLogin)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textLoginInvalido)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(300, 300, 300)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtLoginInvalid, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmailLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pfldSenhaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textLoginInvalido)
                    .addComponent(txtLoginInvalid, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCriarConta)
                    .addComponent(btnEntrarConta))
                .addGap(43, 43, 43))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Verifica o E-mail e a Senha do Usuario para o LOGIN
    private void btnEntrarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarContaActionPerformed
        DBController database = new DBController("database.db");
        boolean check = false;
        String email = txtEmailLogin.getText();
        String senha = pfldSenhaLogin.getText();
       
        if(email.equals("root") && senha.equals("root")) {
            frmScreenUserRoot rootScreen = new frmScreenUserRoot();
            rootScreen.setVisible(true);
            txtEmailLogin.setText("");
            pfldSenhaLogin.setText(""); 
        }else {
            try {
                database.dbConnect();

                check = database.comparationQueryLogin(email, senha);

                if(check) { 
                    frmMenu screenMenu = new frmMenu(email);
                    try {
                        User usuario = new User(email, senha);
                        System.out.println("EMAIL: " + usuario.getEmail());
                        System.out.println("Senha: " + usuario.getPassword());
                    } catch (Exception ex) {
                        Logger.getLogger(frmScreenMain.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    screenMenu.setVisible(true);
                    txtEmailLogin.setText("");
                    pfldSenhaLogin.setText("");        
                }else {
                    txtLoginInvalid.setText(" E-mail ou Senha Inválidos!");
                    pfldSenhaLogin.setText("");
                }


                database.dbDisconnect();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEntrarContaActionPerformed
    // Abre a Tela de Criar Conta
    private void btnCriarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarContaActionPerformed
        frmScreenCreatedAccount screenCreatedAccount = new frmScreenCreatedAccount();
        screenCreatedAccount.setVisible(true);
    }//GEN-LAST:event_btnCriarContaActionPerformed

    private void txtLoginInvalidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginInvalidActionPerformed
        
    }//GEN-LAST:event_txtLoginInvalidActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmScreenMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmScreenMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmScreenMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmScreenMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmScreenMain().setVisible(true);
            }
        });
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriarConta;
    private javax.swing.JButton btnEntrarConta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField pfldSenhaLogin;
    private javax.swing.JLabel textLoginInvalido;
    private javax.swing.JTextField txtEmailLogin;
    private javax.swing.JTextField txtLoginInvalid;
    // End of variables declaration//GEN-END:variables
}
