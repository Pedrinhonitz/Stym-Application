package DataBaseController;

import java.io.File;
import java.sql.*;

public class DBController {
    
    private String dbName;
    Connection dbConn;
    
    public DBController(String dbName) {
        this.dbName = dbName;
    }
    
    public void dbConnect() throws Exception{
        File f = new File(this.dbName);
        
        if(!f.exists()){
            throw new Exception("Arquivo de banco de dados não encontrado");
        }
        
        Class.forName("org.sqlite.JDBC");
        System.out.println("jdbc:sqlite:" + this.dbName);
        this.dbConn = DriverManager.getConnection("jdbc:sqlite:" + this.dbName);
    }
    
    public void dbDisconnect() throws SQLException{
        this.dbConn.close();   
    }
    
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
   
}
