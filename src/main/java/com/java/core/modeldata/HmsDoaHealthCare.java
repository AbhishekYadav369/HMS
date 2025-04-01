package com.java.core.modeldata;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HmsDoaHealthCare extends HmsDao {

//this methods check health care login i.e credential verification
    public boolean doCheck(String userId, String password,String role) {
        super.connect();
        final String query = "SELECT id,userId FROM health_care WHERE userId=? AND pass=? AND health_role=?";
        try (PreparedStatement prepared = super.connection.prepareStatement(query)) {
            prepared.setString(1, userId);
            prepared.setString(2, password);
            prepared.setString(3, role);
            ResultSet resultSet = prepared.executeQuery();

            if (resultSet.next()) {
                return userId.equals(resultSet.getString(2));
            }
        } catch (Exception e) {
            System.out.println("Error checking credentials: " + e.getMessage());
        } finally {
            super.disConnect();
        }
        return false;
    }

    //this method is used for registering health care
    public int insert(String firstName, String middleName, String lName, String role, String phone, String salary,String userId,String pass) {
        super.connect();
        final String query = "insert into health_care(First_name,Middle_name,Last_name,health_role,Phone_number,salary,userId,pass) values(?,?,?,?,?,?,?,?)";
        try (PreparedStatement prepared = super.connection.prepareStatement(query)) {
            prepared.setString(1, firstName);
            prepared.setString(2, middleName);
            prepared.setString(3, lName);
            prepared.setString(4, role);
            prepared.setString(5,phone);
            prepared.setString(6,salary);
            prepared.setString(7,userId);
            prepared.setString(8,pass);
            return  prepared.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error inserting record: " + e.getMessage());
        } finally {
            disConnect();
        }
        return 0;
    }
}
