/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.dto;

/**
 *
 * @author ASUS
 */
public class ItemDto {
    private String code;
    private String Description;
    private String packSize;
    private double unitPrize;
    private int qoh;

    public ItemDto() {
    }
    
    
    public ItemDto(String code, String Description, String packSize, double unitPrize, int qoh) {
        this.code = code;
        this.Description = Description;
        this.packSize = packSize;
        this.unitPrize = unitPrize;
        this.qoh = qoh;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * @return the packSize
     */
    public String getPackSize() {
        return packSize;
    }

    /**
     * @param packSize the packSize to set
     */
    public void setPackSize(String packSize) {
        this.packSize = packSize;
    }

    /**
     * @return the unitPrize
     */
    public double getUnitPrize() {
        return unitPrize;
    }

    /**
     * @param unitPrize the unitPrize to set
     */
    public void setUnitPrize(double unitPrize) {
        this.unitPrize = unitPrize;
    }

    /**
     * @return the qoh
     */
    public int getQoh() {
        return qoh;
    }

    /**
     * @param qoh the qoh to set
     */
    public void setQoh(int qoh) {
        this.qoh = qoh;
    }

    @Override
    public String toString() {
        return "ItemDto{" + "code=" + code + ", Description=" + Description + ", packSize=" + packSize + ", unitPrize=" + unitPrize + ", qoh=" + qoh + '}';
    }
    
}
