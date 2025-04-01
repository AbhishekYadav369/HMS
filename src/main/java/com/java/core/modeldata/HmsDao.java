package com.java.core.modeldata;

import com.java.core.beans.Medical;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HmsDao {

    Connection connection=null;
    private static final String connectionURL = "jdbc:mysql://localhost:3306/hospital_management_system";
    private static final String user = "root";
    private static final String password = "Abhi123.321";

    // Establish a database connection
    public void connect() {
        try {
            if (connection == null || connection.isClosed()) {
               Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(connectionURL, user, password);
            }
        }
        catch (ClassNotFoundException e) { System.out.println("class not found :"+e.getMessage());}
        catch (Exception e) { System.out.println("Error connecting to the database: " + e.getMessage());}
    }

    // Close the database connection
    public void disConnect() {
        try {
            if (connection != null && !connection.isClosed()){ connection.close();}
        } catch (SQLException e) { System.out.println("Error closing the database connection: " + e.getMessage());}
    }


    // Insert a record  into patients table patients
    public int insert(String fName,String mName, String lName, String gFirstName, String gLastName,String phone,String medical_history,String userId,String password) {
        connect();
        final String query = "insert into patients(First_name,Middle_name,Last_name,Gardian_Fname,Gardian_Lname,Gardian_PhoneNo,Medical_history,userId,pass) " +
                "values (?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement prepared = connection.prepareStatement(query)) {
            prepared.setString(1, fName);
            prepared.setString(2, mName);
            prepared.setString(3, lName);
            prepared.setString(4, gFirstName);
            prepared.setString(5, gLastName);
            prepared.setString(6, phone);
            prepared.setString(7, medical_history);
            prepared.setString(8, userId);
            prepared.setString(9, password);
            return prepared.executeUpdate();
        }
        catch (Exception e) { System.out.println("Error inserting record: " + e.getMessage());}
        finally { disConnect();}
        return 0;
    }

    // Update a record
    public int update(String tableName, String column, String value, String conditionColumn, String conditionValue) {
        connect();
        final String query = "UPDATE " + tableName + " SET " + column + " = ? WHERE " + conditionColumn + " = ?";
        try (PreparedStatement prepared = connection.prepareStatement(query)) {
            prepared.setString(1, value);
            prepared.setString(2, conditionValue);
            System.out.println("updated successfully by update method");
           return prepared.executeUpdate();
        }
        catch (Exception e) {  System.out.println("Error while updating record: " + e.getMessage());}
        finally { disConnect();}
        return 0;
    }

    // Delete a record
    public int delete(String tableName,String conditionColumn, String conditionValue) {
        connect();
        final String query = "DELETE FROM " + tableName + " WHERE " + conditionColumn + " = ?";
        try (PreparedStatement prepared = connection.prepareStatement(query)) {
            prepared.setString(1, conditionValue);
            System.out.println("Record deleted successfully by delete method");
            return prepared.executeUpdate();
        }
        catch (Exception e) { System.out.println("Error while deleting record: " + e.getMessage());}
        finally { disConnect();}
        return 0;
    }

    // Check user credentials basically helps in login using database
    public boolean doCheck(String tableName, String userId, String password) {
        connect();
        final String checkQuery = "SELECT userId,pass FROM \n"+tableName+"\n WHERE userId=? AND pass=?";
        try (PreparedStatement prepared = connection.prepareStatement(checkQuery)) {
            prepared.setString(1, userId);
            prepared.setString(2, password);
            ResultSet resultSet = prepared.executeQuery();
            if (resultSet.next()) {
                return userId.equals(resultSet.getString(1))&& password.equals(resultSet.getString(2));}
        }
        catch (Exception e) { System.out.println("Error checking credentials: " + e.getMessage());}
        finally { disConnect();}
        return false;
    }
}
