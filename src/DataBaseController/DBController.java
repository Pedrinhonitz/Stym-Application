package DataBaseController;

import java.io.File;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

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
   
}
