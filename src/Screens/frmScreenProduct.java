package Screens;

import DataBaseController.DBController;
import Screens.frmScreenSendGame;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author angemydelson
**/

public class frmScreenProduct extends javax.swing.JFrame {

    public static String search;
    
    
    public frmScreenProduct() {
        initComponents();
        carregarDados();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jtfPesquisar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduto = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produto");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("C059", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Descrição de jogo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 178, -1));

        jtfPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jtfPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 630, -1));

        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nome do jogo", "Descrição do jogo", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProduto);
        if (tblProduto.getColumnModel().getColumnCount() > 0) {
            tblProduto.getColumnModel().getColumn(0).setHeaderValue("Código");
            tblProduto.getColumnModel().getColumn(1).setHeaderValue("Nome do jogo");
            tblProduto.getColumnModel().getColumn(2).setHeaderValue("Descrição do jogo");
            tblProduto.getColumnModel().getColumn(3).setHeaderValue("Valor");
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 980, 300));

        jButton2.setFont(new java.awt.Font("C059", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8-desfazer-20.png"))); // NOI18N
        jButton2.setText("Voltar");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, -1, -1));

        jButton3.setFont(new java.awt.Font("C059", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8-carrinho-de-compras-carregado-20.png"))); // NOI18N
        jButton3.setText("Adicionar no carrinho");
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 460, -1, -1));

        btnPesquisar.setFont(new java.awt.Font("C059", 1, 14)); // NOI18N
        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8-pesquisar-20.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(667, 40, 140, -1));

        btnLimpar.setFont(new java.awt.Font("C059", 1, 14)); // NOI18N
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8-limpar-filtros-20.png"))); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, 170, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/neon-game-controllers-or-joysticks-vector-37693953.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 0, 1000, 501));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        
//        frmScreenProduct prod = new frmScreenProduct();
        
//        search = jtfPesquisar.getText();
        carregarDados();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        jtfPesquisar.setText("");
        carregarDados();
    }//GEN-LAST:event_btnLimparActionPerformed

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
           javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmScreenProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmScreenProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmScreenProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmScreenProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new frmScreenProduct().setVisible(true);
            }
        });
    }
    
 public void carregarDados(){
      DBController database = new DBController("database.db");

        try {
            database.dbConnect();
            
            String query;
//            search = null;
            search = jtfPesquisar.getText();
           
            if (search != null) {
                System.out.println("Angemydelson");
                query = "select * from products where description LIKE '%"+search+"%'";
                
            } else {
                query = "select * from products";
            }
            
            ResultSet produtos = database.selectBasicDataBase(query);
                        
            DefaultTableModel model = new DefaultTableModel(new String[]{"Código", "Nome do jogo" , "Descrição do jogo", "Valor"}, 0);
            
            while (produtos.next()) {
                model.addRow(new Object[]{produtos.getInt("pkGame"), produtos.getString("sumary"), produtos.getString("description"), produtos.getDouble("preco")});
            }
            
            tblProduto.setModel(model);
            
            
            
            //System.out.println(produtos.);

            
            database.dbDisconnect();
           
        } catch (Exception ex) {
            Logger.getLogger(frmScreenSendGame.class.getName()).log(Level.SEVERE, null, ex);
        }
 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtfPesquisar;
    private javax.swing.JTable tblProduto;
    // End of variables declaration//GEN-END:variables
}
