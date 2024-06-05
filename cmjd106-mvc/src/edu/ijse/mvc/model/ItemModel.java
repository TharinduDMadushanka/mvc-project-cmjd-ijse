/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.model;

import edu.ijse.mvc.db.DBConnection;
import edu.ijse.mvc.dto.ItemDto;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
/**
 *
 * @author ASUS
 */
public class ItemModel {
    
    private final Connection connection;
    
    public ItemModel() throws ClassNotFoundException,SQLException {
        this.connection =DBConnection.getInstance().getConnetion();
    }
    
    public String saveItem(ItemDto itemdto) throws Exception{
        String sql ="INSERT INTO VALUES(?,?,?,?,?)";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,itemdto.getCode());
        statement.setString(2,itemdto.getDescription());
        statement.setString(3,itemdto.getPackSize());
        statement.setDouble(4,itemdto.getUnitPrize());
        statement.setInt(5,itemdto.getQoh());
        
        return statement.executeUpdate() >0 ? "Success" : "Fail";
    }
}
