package com.java.core.modeldata;

import com.java.core.beans.HealthCare;
import com.java.core.beans.Medical;
import com.java.core.beans.Patients;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HmsDaoRead extends HmsDao {
    // Read records use  collection api
    public List<Medical> medicineRead(String tableName) {
        super.connect();
        final String query = "SELECT DISTINCT * FROM medical;";
        try (PreparedStatement prepared = super.connection.prepareStatement(query)) {
            ResultSet rs = prepared.executeQuery();
            List<Medical> lists=new ArrayList<Medical>();

            while (rs.next()) {
                lists.add(new Medical(rs.getString("med_name"),rs.getString("med_dose"),
                        rs.getInt("quantity"),rs.getDate("med_manufacture_date"),
                        rs.getDate("med_expiry_date"),rs.getInt("price")));

            }
            System.out.println("Record read successfully by read method");
            return lists;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        catch (Exception e) { System.out.println("Error reading records: " + e.getMessage());}
        finally { disConnect();}
        return null;
    }

    public List<Patients> patientRead(String userId) {
        super.connect();
        final String query = "SELECT DISTINCT * FROM patients where userId =?;";
        try (PreparedStatement prepared = super.connection.prepareStatement(query)) {
            prepared.setString(1, userId);
            ResultSet rs = prepared.executeQuery();
            List<Patients> lists=new ArrayList<Patients>();
                while (rs.next()) {
                    lists.add(new Patients(
                            rs.getString("First_name"),                    // First name
                            rs.getString("Middle_name"),                   // Middle name
                            rs.getString("Last_name"),                     // Last name
                            rs.getString("Gardian_Fname"),                 // Guardian's first name
                            rs.getString("Gardian_Lname"),                 // Guardian's last name
                            rs.getString("Gardian_PhoneNo"),               // Guardian's phone number
                            rs.getString("Medical_history")));
                }
            System.out.println("Record read successfully by read method");
            return lists;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        catch (Exception e) { System.out.println("Error reading records: " + e.getMessage());}
        finally { disConnect();}
        return null;
    }

    public List<HealthCare> healthCareRead(String userId,String role) {
        super.connect();
        final String query = "SELECT DISTINCT * FROM health_care where userId =? AND health_role =?;";
        try (PreparedStatement prepared = super.connection.prepareStatement(query)) {
            prepared.setString(1, userId);
            prepared.setString(2, role);
            ResultSet rs = prepared.executeQuery();
            List<HealthCare> lists=new ArrayList<HealthCare>();
            while (rs.next()) {
                lists.add(new HealthCare(
                        rs.getString("First_name"),                    // First name
                        rs.getString("Middle_name"),                   // Middle name
                        rs.getString("Last_name"),                     // Last name
                        rs.getString("Phone_number"),
                        rs.getInt("Salary"),
                        rs.getString("health_role")));
            }
            System.out.println("Record read successfully by read method");
            return lists;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        catch (Exception e) { System.out.println("Error reading records: " + e.getMessage());}
        finally { disConnect();}
        return null;
    }

}
