/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.model;

import java.sql.Connection;
import edu.ijse.mvc.db.DBConnection;
/**
 *
 * @author ASUS
 */
public class OrderModel {
    
    private Connection connection;
    
    public OrderModel() throws Exception{
    
        connection=DBConnection.getInstance().getConnection();
    }
}
