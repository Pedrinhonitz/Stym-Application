package Screens;

import DataBaseController.DBController;
import java.sql.ResultSet;

/**
 *
 * @author nitz
**/

public class User {
    
    private boolean ativo;
    private int rowid;
    private String email;
    private String password;
    private String name;
    private String nickname;
    
    public User(String email, String password) throws Exception {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }
    
    public int getRowid() {
        return this.rowid;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String getNickname() {
        return this.nickname;
    }
    
}
