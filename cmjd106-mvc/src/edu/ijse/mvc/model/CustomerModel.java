/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.model;

import edu.ijse.mvc.db.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;


/**
 *
 * @author ASUS
 */
public class CustomerModel {
    private Connection connection1;
    
   public CustomerModel() throws ClassNotFoundException, SQLException {
        this.connection1 =  DBConnection.getInstance().getConnection();
    }
}
