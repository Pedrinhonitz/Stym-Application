package DataBaseController;

import java.io.File;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.Arrays;

public class DBController {
    
    // Variaveis usadas na conexaão do Banco de Dados
    private String dbName;
    Connection dbConn;
    
    // Construtor da Classe
    public DBController(String dbName) {
        this.dbName = dbName;
    }
    
    // Conecta no Banco de Dados
    public void dbConnect() throws Exception{
        File f = new File(this.dbName);
        
        if(!f.exists()){
            throw new Exception("Arquivo de banco de dados não encontrado");
        }
        
        Class.forName("org.sqlite.JDBC");
        this.dbConn = DriverManager.getConnection("jdbc:sqlite:" + this.dbName);
    }
    
    // Desconecta do Banco de Dados
    public void dbDisconnect() throws SQLException{
        this.dbConn.close();   
    }
    
    // Verifica se já existe o E-mail ou o Nickname do Usuario
    public boolean comparationQueryCreatedAccount(String email, String nickname) throws Exception{
        String sel = "SELECT count(1) FROM users WHERE email='" + email + "'" + " OR nickname='" + nickname + "'";
        ResultSet rset = null;
        try {
            Statement stmt = this.dbConn.createStatement();
            rset = stmt.executeQuery(sel);
            
            if(stmt.executeQuery(sel).getInt("count(1)") == 0) {
               return true;
            }
        } catch (SQLException e) {
            throw new Exception("Error When Selecting From Database: " + e.getMessage());
        }
        return false;
    }
    
    // Verifica se o Usuario tem conta criada
    public boolean comparationQueryLogin(String email, String password) throws Exception{
        String sel = "SELECT count(1) FROM users WHERE email='" + email + "'" + " AND password='" + password + "'";
        ResultSet rset = null;
        try {
            Statement stmt = this.dbConn.createStatement();
            rset = stmt.executeQuery(sel);
            
            if(stmt.executeQuery(sel).getInt("count(1)") == 1) {
               return true;
            }
        } catch (SQLException e) {
            throw new Exception("Error When Selecting From Database: " + e.getMessage());
        }
        
        return false;
    }
    
    public void deleteGame(int pkGame, String description) throws Exception {
        String ins = "DELETE FROM products WHERE pkGame=" + pkGame +  " AND description='" + description + "';";
      
        PreparedStatement stmt;
        
        try{
            System.out.println("SQL: " + ins);
            stmt = this.dbConn.prepareStatement(ins);
            stmt.executeUpdate();
            
        }catch (SQLException e){
            throw new Exception("Error Delete Into Database: " + e.getMessage());
        }
    }
    
    // Verifica se o Usuario tem conta criada
    public boolean comparationQueryGame(int pkGame, String description, String sumary) throws Exception{        
        String sel = "SELECT count(1) FROM products WHERE pkGame=" + pkGame + " OR description='" + description + "' OR sumary='"  + sumary + "';";
        
        // String sel = "SELECT count(1) FROM users WHERE email='" + email + "'" + " AND password='" + password + "'";
        ResultSet rset = null;
       
        try {
            Statement stmt = this.dbConn.createStatement();
            rset = stmt.executeQuery(sel);
            
            if(stmt.executeQuery(sel).getInt("count(1)") == 1) {
               return false;
            }
        } catch (SQLException e) {
            throw new Exception("Error When Selecting From Database: " + e.getMessage());
        }
        
        return true;
    }
     
    // Utilizavel para Qualquer Select dentro do Banco de dados
    public ResultSet selectBasicDataBase(String query) throws Exception{
        String sel = query;
        ResultSet rset = null;
        
        try {
            Statement stmt = this.dbConn.createStatement();
            rset = stmt.executeQuery(sel);
        } catch (SQLException e) {
            throw new Exception("Error When Selecting From Database: " + e.getMessage());
        }
        
        return rset;
    }
   
    // Utilizavel para Qualquer Insert dentro do Banco de dados
    public void insertBasicDataBase(String query) throws Exception{
        String ins = query;
        
        PreparedStatement stmt;
        
        try{
            stmt = this.dbConn.prepareStatement(ins);
            stmt.executeUpdate();
            
        }catch (SQLException e){
            throw new Exception("Error Inserting Into Database: " + e.getMessage());
        }
    }
    
    // Utilizavel para Qualquer Delete dentro do Banco de dados
    public void deleteBasicDataBase(String query) throws Exception{
        String ins = query;
        
        PreparedStatement stmt;
        
        try{
            stmt = this.dbConn.prepareStatement(ins);
            stmt.executeUpdate();
            
        }catch (SQLException e){
            throw new Exception("Error Delete Into Database: " + e.getMessage());
        }
    }
    
    // Insere um novo usuario no Banco de Dados
    public void insertUserDataBase(String email, String password, String name, String nickname) throws Exception{
        String ins = "INSERT INTO users (email, password, name, nickname) VALUES (?, ?, ?, ?)";
        
        PreparedStatement stmt;
        
        try{
            stmt = this.dbConn.prepareStatement(ins);
            stmt.setString(1, email);
            stmt.setString(2, password);
            stmt.setString(3, name);
            stmt.setString(4, nickname);
            stmt.executeUpdate();
            
        }catch (SQLException e){
            throw new Exception("Error Inserting User Into Database: " + e.getMessage());
        }
    }
    
    // Deleta um Usuario do Banco de Dados
    public void deleteUserDataBase(String email, String password, String name, String nickname) throws Exception{
        String ins = "DELETE FROM users WHERE email = (?) AND password = (?) AND name = (?), AND nickname = (?)";
        
        PreparedStatement stmt;
        
        try{
            stmt = this.dbConn.prepareStatement(ins);
            stmt.setString(1, email);
            stmt.setString(2, password);
            stmt.setString(3, name);
            stmt.setString(4, nickname);
            stmt.executeUpdate();
            
        }catch (SQLException e){
            throw new Exception("Error DELETE User Into Database: " + e.getMessage());
        }
    }
    
    // Insere um novo Jogo no Banco de Dados
    public void insertGameDataBase(int pkGame, double price, String description, String sumary) throws Exception{
        
        String ins;
        ins = "INSERT INTO products(pkGame, preco, description, sumary) VALUES (?, ?, ?, ?)";
        System.out.println("Entrou");
        System.out.println("SQL: " + ins);
        PreparedStatement stmt;
        
        try{
            stmt = this.dbConn.prepareStatement(ins);
            stmt.setInt(1, pkGame);
            stmt.setDouble(2, price);
            stmt.setString(3, description);
            stmt.setString(4, sumary);
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new Exception("Error Inserting Products Into Database: " + e.getMessage());
        }
    }
    
    // Busca os jogos que estão no carrinho do usuario pelo id do usuario logado.
    public ResultSet jogosDoCarrinho(int pkUser) throws Exception {
        String ins = "SELECT * FROM cart WHERE pkUser = (" + pkUser + ")";
        ResultSet result = null;
        
        try {
            Statement stmt = this.dbConn.createStatement();
            result = stmt.executeQuery(ins);
        } catch (Exception e) {
            throw new Exception("Erro ao buscar jogos no carrinho: " + e.getMessage());
        }
        
        return result;
    }
    
    // Busca o valor dos produtos que estão no carrinho de um determinado usuario.
    public ResultSet valorDoCarrinho(int pkUser) throws Exception {
        String ins = "SELECT value FROM cart WHERE pkUser = (" + pkUser + ")";
        ResultSet result = null;
        
        try {
            Statement stmt = this.dbConn.createStatement();
            result = stmt.executeQuery(ins);
        } catch (Exception e) {
            throw new Exception("Erro ao buscar valor dos jogos no carrinho: " + e.getMessage());
        }
        
        return result;
    }

    // Busca id do usuario pelo seu email.
    public int buscarIdPorEmail(String email) throws Exception {
        String ins = "SELECT rowid FROM users WHERE email = '"+ email + "'";
        ResultSet result = null;
        
        try {
            Statement stmt = this.dbConn.createStatement();
            result = stmt.executeQuery(ins);
        } catch (Exception e) {
            throw new Exception("Erro ao buscar id do usuario: " + e.getMessage());
        }
        
        return result.getInt("rowid");
    }
    
    // Busca informações do produto e se o produto existe pelo seu pkGame.
    public String [] buscarJogo(int pkGame) throws Exception {
        String ins = "SELECT preco, description FROM products WHERE pkGame = " + pkGame;
        ResultSet result = null;
        String[] response = null;
        
        try {
            Statement stmt = this.dbConn.createStatement();
            result = stmt.executeQuery(ins);
            
            while(result.next()){
                response = new String[] {result.getString("description"), result.getString("preco")};
            }
            
        } catch (Exception e) {
            throw new Exception("Erro ao buscar produto pelo seu pkGame: " + e.getMessage());
        }
        
        return response;
    }
    
    // Inserir jogo no carrinho.
    public void inserirJogoNoCarrinho(int pkUser, int pkGame, String name, double value) throws Exception {
        String ins;
        ins = "INSERT INTO cart (name, pkUser, pkGame, value) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt;
        
        try{
            stmt = this.dbConn.prepareStatement(ins);
            stmt.setString(1, name);
            stmt.setInt(2, pkUser);
            stmt.setInt(3, pkGame);
            stmt.setDouble(4, value);
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new Exception("Erro ao inserir produto no carrinho: " + e.getMessage());
        }
    }
    
    // Busca o produto pelo seu id_produto e retorna o id do usuario que é o dono desse produto.
    public int buscaProdutoPorId(int id) throws Exception {
        String ins = "SELECT pkUser FROM cart WHERE id_produto = '"+ id + "'";
        ResultSet result = null;
        int response = 0;
        
        try {
            Statement stmt = this.dbConn.createStatement();
            result = stmt.executeQuery(ins);
            while(result.next()){
                response = result.getInt("pkUser");
            }
        } catch (Exception e) {
            throw new Exception("Erro ao buscar produto por id: " + e.getMessage());
        }
        
        return response;
    }
    
    // Remove o produto pelo seu id_produto.
    public void removerProduto(int idProduto) throws Exception {
        String ins = "DELETE FROM cart WHERE id_produto = '" + idProduto + "'";
        PreparedStatement stmt;
        try {
            stmt = this.dbConn.prepareStatement(ins);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Erro remover produto do carrinho: " + e.getMessage());
        }
    }
    
    // Busca valor do cupom pelo seu nome.
    public int buscaCupom(String nomeCupom) throws Exception {
        String ins = "SELECT valor FROM desconto WHERE nome = '"+ nomeCupom + "'";
        ResultSet result = null;
        
        try {
            Statement stmt = this.dbConn.createStatement();
            result = stmt.executeQuery(ins);
        } catch (Exception e) {
            throw new Exception("Erro ao buscar produto por id: " + e.getMessage());
        }
        
        return result.getInt("valor");
    }
    
    public boolean verificaIdJogo(int idJogo, int idUser) throws Exception{
        String ins = "SELECT pkGame FROM cart WHERE pkGame = '"+ idJogo + "' AND pkUser = '" + idUser + "'";
        ResultSet result = null;
        boolean response = false;
        try {
            Statement stmt = this.dbConn.createStatement();
            result = stmt.executeQuery(ins);
            while(result.next()){
                if(result.getInt("pkGame") == idJogo){
                    response = true;
                }
            }
        } catch (Exception e) {
            throw new Exception("Erro ao verificar jogo por id: " + e.getMessage());
        }
        
        return response;
    }
    
    public void limparCarrinho(int idUser) throws Exception{
        String ins = "DELETE FROM cart WHERE pkUser = '" + idUser + "'";
        PreparedStatement stmt;
        try {
            stmt = this.dbConn.prepareStatement(ins);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Erro ao limpar o carrinho: " + e.getMessage());
        }
    }
}
