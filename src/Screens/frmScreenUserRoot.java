package Screens;

import DataBaseController.DBController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class frmScreenUserRoot extends javax.swing.JFrame {

    public frmScreenUserRoot() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNomeGame = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaSumario = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPkGame = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPrecoJogo = new javax.swing.JTextField();
        btnCancelarCadastroJogo = new javax.swing.JButton();
        btnDeletarJogo = new javax.swing.JButton();
        btnInserirJogo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Stym Root User");
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));

        jLabel1.setText("Nome do Jogo");

        txtaSumario.setColumns(20);
        txtaSumario.setRows(5);
        jScrollPane1.setViewportView(txtaSumario);

        jLabel2.setText("Sumario do Jogo");

        jLabel3.setText("ID do Jogo");

        jLabel4.setText("Preço do Jogo");

        btnCancelarCadastroJogo.setText("Cancelar");
        btnCancelarCadastroJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCadastroJogoActionPerformed(evt);
            }
        });

        btnDeletarJogo.setText("Deletar");
        btnDeletarJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarJogoActionPerformed(evt);
            }
        });

        btnInserirJogo.setText("Inserir");
        btnInserirJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirJogoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNomeGame)
                    .addComponent(txtPkGame)
                    .addComponent(txtPrecoJogo)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelarCadastroJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeletarJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInserirJogo, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)))
                .addGap(164, 164, 164)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNomeGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtPkGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtPrecoJogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelarCadastroJogo)
                            .addComponent(btnDeletarJogo)
                            .addComponent(btnInserirJogo)))
                    .addComponent(jScrollPane1))
                .addGap(131, 131, 131))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInserirJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirJogoActionPerformed
        DBController database = new DBController("database.db");
        
        int pkGame = Integer.parseInt(txtPkGame.getText());
        double price = Double.parseDouble(txtPrecoJogo.getText());
        String description = txtNomeGame.getText();
        String sumary = txtaSumario.getText();
        boolean check = false;
        
        try {
            database.dbConnect();
            check = database.comparationQueryGame(pkGame, description, sumary);
            database.dbDisconnect();
            if(check) {
                database.dbConnect();
                database.insertGameDataBase(pkGame, price, description, sumary);
                database.dbDisconnect();
            }else {
                JOptionPane.showMessageDialog(this, "Jogo Já Cadastrado!");
            }
        } catch (Exception ex) {
            Logger.getLogger(frmScreenSendGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInserirJogoActionPerformed

    private void btnCancelarCadastroJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCadastroJogoActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarCadastroJogoActionPerformed

    private void btnDeletarJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarJogoActionPerformed
        DBController database = new DBController("database.db");
        
        int pkGame = Integer.parseInt(txtPkGame.getText());
        String description = txtNomeGame.getText();
        
        try { 
            database.dbConnect();

            database.deleteGame(pkGame, description);

            database.dbDisconnect();
        } catch (Exception ex) {
            Logger.getLogger(frmScreenSendGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnDeletarJogoActionPerformed

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
            java.util.logging.Logger.getLogger(frmScreenUserRoot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmScreenUserRoot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmScreenUserRoot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmScreenUserRoot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new frmScreenUserRoot().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarCadastroJogo;
    private javax.swing.JButton btnDeletarJogo;
    private javax.swing.JButton btnInserirJogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtNomeGame;
    private javax.swing.JTextField txtPkGame;
    private javax.swing.JTextField txtPrecoJogo;
    private javax.swing.JTextArea txtaSumario;
    // End of variables declaration//GEN-END:variables
}
