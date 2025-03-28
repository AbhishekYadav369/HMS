package com.java.core;

import java.sql.*;

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
                System.out.println("Connected to the database successfully");
            }
        }catch (ClassNotFoundException e) {
            System.out.println("class not found :"+e.getMessage());}
        catch (Exception e) {
            System.out.println("Error connecting to the database: " + e.getMessage());}
    }

    // Close the database connection
    public void disConnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Disconnected from the database successfully");
            }
        } catch (SQLException e) {
            System.out.println("Error closing the database connection: " + e.getMessage());
        }
    }

    // Insert a record (Fixed SQL syntax)
    public int insert(String fName, String mName, String lName, String gFname, String gLname,String phone,String medical_history) {
        connect();
        final String query = "insert into patients(First_name,Middle_name,Last_name,Gardian_Fname,Gardian_Lname,Gardian_PhoneNo,Medical_history) " +
                "values (?,?,?,?,?,?,?)";
        try (PreparedStatement prepared = connection.prepareStatement(query)) {
            prepared.setString(1, fName);
            prepared.setString(2, mName);
            prepared.setString(3, lName);
            prepared.setString(4, gFname);
            prepared.setString(5, gLname);
            prepared.setString(6, phone);
            prepared.setString(7, medical_history);
            prepared.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println("Error inserting record: " + e.getMessage());
        } finally {
            disConnect();
        }
        return 0;
    }

    // Update a record (Fixed SQL syntax)
    public void update(String tableName, String column, String value, String conditionColumn, String conditionValue) {
        connect();
        final String query = "UPDATE " + tableName + " SET " + column + " = ? WHERE " + conditionColumn + " = ?";
        try (PreparedStatement prepared = connection.prepareStatement(query)) {
            prepared.setString(1, value);
            prepared.setString(2, conditionValue);
            prepared.executeUpdate();
            System.out.println("Record updated successfully");
        } catch (Exception e) {
            System.out.println("Error updating record: " + e.getMessage());
        } finally {
            disConnect();
        }
    }

    // Delete a record (Fixed SQL syntax)
    public void delete(String tableName, String conditionColumn, String conditionValue) {
        connect();
        final String query = "DELETE FROM " + tableName + " WHERE " + conditionColumn + " = ?";
        try (PreparedStatement prepared = connection.prepareStatement(query)) {
            prepared.setString(1, conditionValue);
            prepared.executeUpdate();
            System.out.println("Record deleted successfully");
        } catch (Exception e) {
            System.out.println("Error deleting record: " + e.getMessage());
        } finally {
            disConnect();
        }
    }

    // Read records (Fixed SQL syntax)
    public void read(String tableName, String conditionColumn, String conditionValue) {
        connect();
        final String query = "SELECT * FROM " + tableName + " WHERE " + conditionColumn + " = ?";
        try (PreparedStatement prepared = connection.prepareStatement(query)) {
            prepared.setString(1, conditionValue);
            ResultSet resultSet = prepared.executeQuery();
            while (resultSet.next()) {
                System.out.println("Record: " + resultSet.getString(1));
            }
        } catch (Exception e) {
            System.out.println("Error reading records: " + e.getMessage());
        } finally {
            disConnect();
        }
    }

    // Check user credentials (Fixed SQL syntax)


    public boolean doCheck(String tableName, String userId, String password) {
        connect();
        final String checkQuery = "SELECT username FROM \n"+tableName+"\n WHERE username=? AND pass=?";
        try (PreparedStatement prepared = connection.prepareStatement(checkQuery)) {
            prepared.setString(1, userId);
            prepared.setString(2, password);
            ResultSet resultSet = prepared.executeQuery();

            if (resultSet.next()) {
                return userId.equals(resultSet.getString(1));
            }
        } catch (Exception e) {
            System.out.println("Error checking credentials: " + e.getMessage());
        } finally {
            disConnect();
        }
        return false;
    }
}
