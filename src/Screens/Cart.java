package Screens;

import DataBaseController.DBController;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Cart {
    private int idUser;
    private int quantidadeDeProdutos;
    private double valorTotal;
    private ArrayList<Products> listaDeProdutos;

    public Cart(int idUser) {
        this.idUser = idUser;
    }

    
    public void listarProdutos(){
        DBController db = new DBController("database.db");
        
        try {
            db.dbConnect();
            
            ResultSet result = db.jogosDoCarrinho(this.idUser);
            
            System.out.println(result.toString());
            
        } catch (Exception e) {
            System.out.println("Deu ruim galera!");
        }
    }
}
