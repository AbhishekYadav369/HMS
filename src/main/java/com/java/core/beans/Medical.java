package com.java.core.beans;

import java.util.Date;

public class Medical {
    private String name;
    private String dose;
    private int quantity;
    private Date manDate;
    private Date expiryDate;
    private int price;
    public Medical(String name, String dose, int quantity, Date manDate, Date expiryDate, int price){
        this.name = name;
        this.dose = dose;
        this.quantity = quantity;
        this.manDate = manDate;
        this.expiryDate = expiryDate;
        this.price = price;
    }


    public String getDose() { return dose;}

    public Date getManDate() { return manDate;}

    public int getQuantity() { return quantity;}

    public int getPrice() { return price;}

    public Date getExpiryDate() { return expiryDate;}

    public String getName() { return name;}

    public void setDose(String dose) { this.dose = dose;}

    public void setExpiryDate(Date expiryDate) { this.expiryDate = expiryDate;}

    public void setManDate(Date manDate) { this.manDate = manDate;}

    public void setName(String name) { this.name = name;}

    public void setPrice(int price) { this.price = price;}

    public void setQuantity(int quantity) { this.quantity = quantity;}

    @Override
    public String toString() {
        return "\t Medicine: {" +"name = "+ name+", dose =" + dose + ", quantity =" + quantity +
                ", Manufactring Date =" + manDate + ", expiryDate =" + expiryDate +
                ", price =" + price + '}';
    }
}

