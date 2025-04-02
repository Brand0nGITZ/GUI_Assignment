/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author yapji
 */
package dao;

import model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List; 


public class ProductDAO {
    
    private static final String host = "jdbc:derby://localhost:1527/myderbyDB";
    private static final String user =  "brandon";
    private static final String password = "brandon";
    
    public List<Product> getAllProducts() {
         List<Product> products = new ArrayList<>();
         String selectAll = "SELECT * FROM PRODUCTS ";
        
        try (Connection conn = DriverManager.getConnection(host, user , password)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectAll);
            
             while (rs.next()) {
            Product product = new Product();
            rs.getInt("PRODUCT_ID");
            rs.getString("NAME");
            rs.getDouble("PRICE");
            rs.getString("DESCRIPTION");
            rs.getString("IMAGE_URL");
            rs.getInt("STOCK_QUANTITY");
            rs.getString("CATEGORY");
            rs.getString("CREATED_AT");
            rs.getString("UPDATED_AT"); 
            
            products.add(product);
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
         return products;
       
        
    }
    

    
    
    
    
}
