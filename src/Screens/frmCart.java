package Screens;

import DataBaseController.DBController;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmCart extends javax.swing.JFrame {

    private int idUser;
    private double subTotal;
    private double total;
    
    public frmCart(int idUser) {
        this.idUser = idUser;
        initComponents();
        listarProdutos();
        calcularTotal();
        calculaCupom();
    }

    private void listarProdutos(){
        DBController db = new DBController("database.db");
        
        try {
            db.dbConnect();
            
            ResultSet result = db.jogosDoCarrinho(this.idUser);
            
            DefaultTableModel model = new DefaultTableModel(new String []{"Id do produto", "Nome do jogo", "Id usuario", " Id jogo", "Valor"}, 0);
            
            while(result.next()){
                model.addRow(new Object[]{result.getInt("id_produto"), result.getString("name"), result.getInt("pkUser"), result.getInt("pkGame"), result.getDouble("value") });
            }
            
            tblCarrinho.setModel(model);
            
            db.dbDisconnect();
            
        } catch (Exception e) {
            System.out.println("Deu ruim galera!" + e.getMessage());
        }
    }
    
    private void calcularTotal(){
        DBController db = new DBController("database.db");
        this.subTotal = 0;
        try {
            db.dbConnect();
            
            ResultSet result = db.valorDoCarrinho(this.idUser);
            
            while(result.next()){
                this.subTotal += Double.parseDouble(result.getString("value"));
            }
            
            db.dbDisconnect();
            
            edtSubtotal.setText(String.format("R$: %.2f", this.subTotal));
            
        } catch (Exception e) {
            System.out.println("Deu ruim galera!" + e.getMessage());
        }
    }
    
    private int idDoDonoDoProduto(int idDoProduto){
        DBController db = new DBController("database.db");
        int id = 0;
        try {
            db.dbConnect();
            id = db.buscaProdutoPorId(idDoProduto);
            db.dbDisconnect();
        } catch (Exception e) {
            System.out.println("Erro ao buscar id do dono do produto!" + e.getMessage());
        }
        System.out.println(id);
        return id;
    }
    
    private void removerProdutoDoCarrinho(int idProduto){
        DBController db = new DBController("database.db");
        
        try {
            db.dbConnect();
            db.removerProduto(idProduto);
            db.dbDisconnect();
        } catch (Exception e) {
            
            System.out.println("Erro ao remover produto!" + e.getMessage());
            
        }
    }
    
    private int buscarCupom(String nomeCupom) throws Exception {
        DBController db = new DBController("database.db");
        int id = 0;
        try {
            db.dbConnect();
            id = db.buscaCupom(nomeCupom);
            db.dbDisconnect();
        } catch (Exception e) {
            System.out.println("Erro ao buscar cupom!" + e.getMessage());
            throw new Exception("Cupom invalido!");
        }
        return id;
    }
    
    private void calculaCupom(){
        String cupom = jtfCupom.getText();
        if(!cupom.equals("")){
            int valorCupom = 0;
            try {
                valorCupom = buscarCupom(cupom);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }

            edtDesconto.setText(valorCupom + "%");

            double desconto = this.subTotal * (Double.parseDouble(String.format("%d",valorCupom)) / 100);

            this.total = this.subTotal - desconto;

            edtTotal.setText(String.format("R$: %.2f", this.total));
            jtfCupom.setText("");
        } else {
            this.total = this.subTotal;
            edtDesconto.setText("0" + "%");
            edtTotal.setText(String.format("R$: %.2f", this.total));
           
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCarrinho = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        edtSubtotal = new javax.swing.JLabel();
        btnComprar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jtfCupom = new javax.swing.JTextField();
        btnAplicarCupom = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        edtDesconto = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        edtTotal = new javax.swing.JLabel();
        btnAtualizar = new javax.swing.JButton();
        btnRemoverCarrinho = new javax.swing.JButton();
        edtIdProduto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tblCarrinho.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblCarrinho);

        jLabel1.setText("Subtotal:");

        edtSubtotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        btnComprar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnComprar.setText("COMPRAR");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });

        jLabel3.setText("Cupom de desconto:");

        btnAplicarCupom.setText("Aplicar cupom");
        btnAplicarCupom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarCupomActionPerformed(evt);
            }
        });

        jLabel4.setText("Desconto:");

        edtDesconto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel5.setText("Total:");

        edtTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnComprar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jtfCupom, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(edtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnAplicarCupom))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(edtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                                            .addComponent(edtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(15, 15, 15))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(edtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfCupom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAplicarCupom)
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(edtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(edtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 332, Short.MAX_VALUE)
                .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnRemoverCarrinho.setText("Remover do carrinho");
        btnRemoverCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverCarrinhoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Id do produto:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(edtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoverCarrinho))
                    .addComponent(btnAtualizar)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAtualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRemoverCarrinho)
                            .addComponent(edtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoverCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverCarrinhoActionPerformed
        int idProduto = 0;
        try {
            idProduto = Integer.parseInt(edtIdProduto.getText());
            
            if (idProduto == 0){
                throw new Exception("Deu ruim!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Código invalido!");
        }
        
        int idDono = idDoDonoDoProduto(idProduto);
        
        if(this.idUser == idDono){
            // dono do produto ok
            removerProdutoDoCarrinho(idProduto);
            listarProdutos();
            calcularTotal();
            calculaCupom();
            edtIdProduto.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Código invalido!");
        }  
    }//GEN-LAST:event_btnRemoverCarrinhoActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        listarProdutos();
        calcularTotal();
        calculaCupom();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnAplicarCupomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarCupomActionPerformed
        // TODO add your handling code here:
        calculaCupom();
    }//GEN-LAST:event_btnAplicarCupomActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnComprarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAplicarCupom;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnRemoverCarrinho;
    private javax.swing.JLabel edtDesconto;
    private javax.swing.JTextField edtIdProduto;
    private javax.swing.JLabel edtSubtotal;
    private javax.swing.JLabel edtTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtfCupom;
    private javax.swing.JTable tblCarrinho;
    // End of variables declaration//GEN-END:variables
}
