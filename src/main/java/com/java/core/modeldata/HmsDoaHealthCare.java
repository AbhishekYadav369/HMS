package com.java.core;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HmsDoaHealthCare extends HmsDao{

    public boolean doCheck(String userId, String password,String role) {
        super.connect();
        final String query = "SELECT username FROM health_care_login WHERE username=? AND pass=? AND h_role=?";
        try (PreparedStatement prepared = super.connection.prepareStatement(query)) {
            prepared.setString(1, userId);
            prepared.setString(2, password);
            prepared.setString(3, role);
            ResultSet resultSet = prepared.executeQuery();

            if (resultSet.next()) {
                return userId.equals(resultSet.getString(1));
            }
        } catch (Exception e) {
            System.out.println("Error checking credentials: " + e.getMessage());
        } finally {
            super.disConnect();
        }
        return false;
    }
    public int insert(String fName, String mName, String lName, String role, String phone, String salary) {
        super.connect();
        final String query = "insert into health_care(First_name,Middle_name,Last_name,H_role,Phone_number,salary) values(?,?,?,?,?,?)";
        try (PreparedStatement prepared = super.connection.prepareStatement(query)) {
            prepared.setString(1, fName);
            prepared.setString(2, mName);
            prepared.setString(3, lName);
            prepared.setString(4, role);
            prepared.setString(5,phone);
            prepared.setString(6,salary);
            prepared.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println("Error inserting record: " + e.getMessage());
        } finally {
            disConnect();
        }
        return 0;
    }
}
