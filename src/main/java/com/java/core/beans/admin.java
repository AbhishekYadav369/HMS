package com.java.core.beans;

public class admin {
    private int id;
    private String name;
    private String password;
    public admin(int id,String name,String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getPassword() { return password;}

    public void setPassword(String password) { this.password = password;}

    public String getName() { return name;}

    public void setName(String name) { this.name = name;}

    public int getId() { return id;}

    public void setId(int id) { this.id = id;}

    @Override
    public String toString() {
        return "admin{" + "id=" + id + ", name='" + name + '\'' +
                ", password='" + password + '\'' + '}';
    }
}
