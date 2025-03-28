package com.java.core;

public class Medical {
    private String name;
    private String dose;
    private int quantity;
    private String manufacutringDate;
    private String expiryDate;
    private int price;
    public Medical(String name,String dose,int quantity,String manufacutringDate,String expiryDate,int price){
        this.name = name;
        this.dose = dose;
        this.quantity = quantity;
        this.manufacutringDate = manufacutringDate;
        this.expiryDate = expiryDate;
        this.price = price;
    }

    public String getDose() { return dose;}

    public String getManufacutringDate() { return manufacutringDate;}

    public int getQuantity() { return quantity;}

    public int getPrice() { return price;}

    public String getExpiryDate() { return expiryDate;}

    public String getName() { return name;}

    public void setDose(String dose) { this.dose = dose;}

    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate;}

    public void setManufacutringDate(String manufacutringDate) { this.manufacutringDate = manufacutringDate;}

    public void setName(String name) { this.name = name;}

    public void setPrice(int price) { this.price = price;}

    public void setQuantity(int quantity) { this.quantity = quantity;}

    @Override

    public String toString() {
        return "Medical{" +
                "dose='" + dose + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", manufacutringDate='" + manufacutringDate + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", price=" + price +
                '}';
    }
}

