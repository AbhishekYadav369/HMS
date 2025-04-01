package com.java.core.beans;

public class HealthCare {
    private String firstName;
    private String middleName;
    private String lastName;
    private String number;
    private int salary;
    private String role;
    public HealthCare(String firstName, String middleName, String lastName, String number, int salary, String role) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.number = number;
        this.salary =  salary;
        this.role = role;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "HealthCare{" + "firstName='" + firstName + '\'' + ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' + ", number='" + number + '\'' +
                ", salary=" + salary + ", role='" + role + '\'' + '}';
    }
}


