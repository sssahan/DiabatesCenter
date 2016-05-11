/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import domain.Employee;
import domain.Patient;
import domain.Report;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sachithra sahan
 */
public class DBOperation {
    private static DBOperation  dbo=null;
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet use = null;
    private final String url = "jdbc:mysql://localhost:3306/diabetes_center";
    private final String user = "root";
    private final String password = "sahan";
    private DBOperation(){
        
    }
    
    public static DBOperation getInstance(){//singleton pattern to access database object
        if(dbo==null){
            synchronized(DBOperation.class){
                dbo=new DBOperation();
            }
        }
        return dbo;
    }
    public void setConenction() throws SQLException{
        boolean reachable = false;
        try {            
            Class.forName("com.mysql.jdbc.Driver").newInstance();            
            con = DriverManager.getConnection(url, user, password);           
            reachable = con.isValid(30);           
            
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
           
        }
    }
    public void closeConnection() throws SQLException{
        try{
            con.close();
            pst.close();
            use.close();
        }catch(NullPointerException ex){}
    }
    public void addEmployee(Employee employee) throws SQLException{
        setConenction();
        pst = con.prepareStatement("INSERT INTO Employee VALUES(?,?,?,?,?,?)");
        pst.setInt(1,employee.getEmployeeID());
        pst.setString(2, employee.getName());
        pst.setString(3, employee.getPosition());
        pst.setString(4, employee.getNIC());
        pst.setString(5, employee.getUsername());
        pst.setString(6, employee.getPassword());
        pst.executeUpdate();
        //con.close();
        closeConnection();
    }
    public void addPatient(Patient patient) throws SQLException{
        setConenction();
        pst=con.prepareStatement("INSERT INTO Patient VALUES(?,?,?,?,?,?,?,?)");
        pst.setInt(1,patient.getPatientID());
        pst.setString(2, patient.getFirstName());
        pst.setString(3, patient.getLastName());
        pst.setString(4, patient.getGender());
        pst.setInt(5, patient.getAge());
        pst.setString(6, patient.getBloodGroup());
        pst.setString(7, patient.getAddress());
        pst.setString(8, patient.getPhoneNum());
        pst.executeUpdate();
        //con.close();
        closeConnection();
    }
    
    public void addTestResult(Report report) throws SQLException{
        setConenction();
        pst=con.prepareStatement("INSERT INTO Test VALUES(?,?,?,?,?,?)");
        pst.setInt(1, report.getTestID());
        pst.setString(2, report.getTestType());
        pst.setInt(3, report.getPatientID());
        pst.setString(4, report.getResult());
        pst.setInt(5, report.getEmployeeID());
        pst.setDate(6, report.getDate());
        pst.executeUpdate();
        closeConnection();
    }
}
