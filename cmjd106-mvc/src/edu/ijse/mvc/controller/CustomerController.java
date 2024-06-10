/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.controller;

import edu.ijse.mvc.dto.CustomerDto;
import edu.ijse.mvc.model.CustomerModel;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class CustomerController {
    private CustomerModel customerModel;
    
    public CustomerController() throws Exception{
        this.customerModel=new CustomerModel();
    }
    
    public String saveCustomer(CustomerDto customerDto) throws Exception{
        String resp =customerModel.saveCustomer(customerDto);
        return resp;
    }
    
    public ArrayList<CustomerDto> getAllCustomer()throws Exception{
        ArrayList<CustomerDto> customerDtos=customerModel.getAllCustomer();
        return customerDtos;
    }
    public CustomerDto searchCustomer(String custId)throws Exception{
        CustomerDto customerDto=customerModel.getCustomer(custId);
        return customerDto;
    }
}
