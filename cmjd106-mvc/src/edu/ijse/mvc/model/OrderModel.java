/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.model;

import java.sql.Connection;
import edu.ijse.mvc.db.DBConnection;
import edu.ijse.mvc.dto.OrderDetailDto;
import edu.ijse.mvc.dto.OrderDto;
import java.util.ArrayList;
import java.sql.PreparedStatement;
/**
 *
 * @author ASUS
 */
public class OrderModel {
    
    private Connection connection;
    
    public OrderModel() throws Exception{
    
        connection=DBConnection.getInstance().getConnection();
    }
    
    public String placeOrder(OrderDto orderDto, ArrayList<OrderDetailDto> orderDetailDtos) throws Exception{
    
        try {
            connection.setAutoCommit(false);// disable auto save data
            
            String orderSql = "INSERT INTO orders VALUES(?,?,?)";
            PreparedStatement orderStatement = connection.prepareStatement(orderSql);
            orderStatement.setString(1, orderDto.getOrderId());
            orderStatement.setString(2,orderDto.getDate());
            orderStatement.setString(3, orderDto.getCustId());
            
            boolean isOrderSaved = orderStatement.executeUpdate() > 0;
            
            if(isOrderSaved){
            
                boolean isOrderDetailsSaved= true;
                
                String orderDetailSql = "INSERT INTO orderdetail VALUES(?,?,?,?)";
                for(OrderDetailDto orderDetailDto : orderDetailDtos){
                
                    PreparedStatement orderDetailsStatement = connection.prepareStatement(orderSql);
                    orderDetailsStatement.setString(1,orderDto.getOrderId());
                    orderDetailsStatement.setString(2,orderDetailDto.getItemCode());
                    orderDetailsStatement.setInt(3,orderDetailDto.getQty());
                    orderDetailsStatement.setInt(4,orderDetailDto.getDiscount());
                    
                    if(!(orderDetailsStatement.executeUpdate()>0)){
                    
                        isOrderDetailsSaved = false;
                    }
                }
                
                if(isOrderDetailsSaved){
                
                    boolean isItemUpdated = true;
                    
                    String itemUpdateSql = "UPDATE item SET QtyOnHand= QtyOnHand - ? WHERE ItemCode = ?";
                    
                    for(OrderDetailDto orderDetailDto : orderDetailDtos){
                    
                        PreparedStatement itemStatement = connection.prepareStatement(itemUpdateSql);
                        itemStatement.setInt(1, orderDetailDto.getQty());
                        itemStatement.setString(2, orderDetailDto.getItemCode());
                        
                        if(!(itemStatement.executeUpdate() > 0)){
                        
                            isItemUpdated = false;
                        }
                    }
                    
                    if(isItemUpdated){
                    
                        connection.commit();
                        return "Success";
                    }else{
                    
                        connection.rollback();
                        return "Item update error";
                    }
                    
                }else{                
                    connection.rollback();
                    return "Order detail Save error";
                }
                
            }else{            
                connection.rollback();
                return "Order save error";
            }
            
        } catch (Exception e) {
            connection.rollback(); // when disable program roll back all data
            e.printStackTrace();
        } finally {
            connection.setAutoCommit(true);
        }
        
    }
}
