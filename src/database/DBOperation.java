/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import domain.Doctor;
import domain.Employee;
import domain.LabTechnician;
import domain.Manager;
import domain.MedicalAssistant;
import domain.Medicine;
import domain.Patient;
import domain.Receptionist;
import domain.Report;
import domain.Treatment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sachithra sahan
 */
public class DBOperation {
    private static DBOperation  dbo=null;
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet resultSet = null;
    private final String url = "jdbc:mysql://192.168.173.1:3306/diabetes_center";
    private final String user = "sahan";
    private final String password = "sahan";
    public static boolean conError=false;
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
    public boolean setConenction() throws SQLException{
        boolean reachable = false;
        try {            
            Class.forName("com.mysql.jdbc.Driver").newInstance();            
            con = DriverManager.getConnection(url, user, password);            
            conError=false;
            reachable = con.isValid(30);            
            return true;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {            
            conError=true;
            return false;
        }catch(Exception ex){
            conError=true;
            return false;
        }
    }
    public void closeConnection() throws SQLException{
        try{
            con.close();
            pst.close();
            resultSet.close();
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
        pst.setDate(5, patient.getDate());
        pst.setString(6, patient.getBloodGroup());
        pst.setString(7, patient.getAddress());
        pst.setString(8, patient.getPhoneNum());
        pst.executeUpdate();
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
    
    public void addTreatment(Treatment treatment) throws SQLException{
        setConenction();
        pst=con.prepareStatement("INSERT INTO Treatment VALUES(?,?,?,?,?)");
        pst.setInt(1, treatment.getTreatmentID());
        pst.setInt(2, treatment.getPatientID());
        pst.setInt(3, treatment.getEmployeeID());
        pst.setString(4, treatment.getDetails());
        pst.setDate(5, treatment.getDate());
        pst.executeUpdate();
        closeConnection();
    }
    
    public void addMedicineReport(Medicine medicine) throws SQLException{
        setConenction();
        for (int i = 0; i < medicine.getDosage().size(); i++) {
            pst=con.prepareStatement("INSERT INTO Medicine VALUES(?,?,?,?)");
            pst.setInt(1, medicine.getTreatmentID());
            pst.setInt(2, medicine.getPatientID());
            pst.setString(3, medicine.getMadicineType().get(i));
            pst.setString(4, medicine.getDosage().get(i));
            pst.executeUpdate();
        }
        
        closeConnection();
    }
    
    public void updateEmployee(Employee employee) throws SQLException{
        setConenction();
        pst=con.prepareStatement("UPDATE Employee SET name=?, position=?, NIC=?, username=?, password=? WHERE EID=? ");
        pst.setInt(6, employee.getEmployeeID());
        pst.setString(1, employee.getName());
        pst.setString(2, employee.getPosition());
        pst.setString(3, employee.getNIC());
        pst.setString(4, employee.getUsername());
        pst.setString(5, employee.getPassword());
        pst.executeUpdate();
        closeConnection();
        
    }
    
    public void removeEmployee(int eid) throws SQLException{
        setConenction();
        pst=con.prepareStatement("DELETE FROM Employee WHERE EID=?");
        pst.setInt(1, eid);
        pst.executeUpdate();
        closeConnection();
    }
    
    public boolean isValidPatient(int pid) throws SQLException{
        int id;
        setConenction();
        pst=con.prepareStatement("SELECT PID FROM Patient");
        resultSet=pst.executeQuery();
        while(resultSet.next()){
            id = resultSet.getInt(1);
            if(id==pid){
                return true;
            }
        }
        closeConnection();
        return false;
        
    }
    public boolean isValidEmployee(String user, String pwd) throws SQLException{
        String username,passwordE;
        setConenction();
        pst=con.prepareStatement("SELECT username,password FROM Employee");
        resultSet=pst.executeQuery();
        while(resultSet.next()){
            username=resultSet.getString(1);
            passwordE=resultSet.getString(2);
            if(username.equals(user) && passwordE.equals(pwd)){
                return true;
            }
        }
        closeConnection();
        return false;

    }
    
    public boolean isValidEmployee(String eid) throws SQLException{
        String id;
        setConenction();
        pst=con.prepareStatement("SELECT EID FROM Employee");
        resultSet=pst.executeQuery();
        while(resultSet.next()){
            id=resultSet.getString(1);
            if(eid.equals(id) ){
                return true;
            }
        }
        closeConnection();
        return false;
        
    }
    
    public boolean isAdmin(String user, String pwd){
         try {
            if(!setConenction())
                return false;
            pst = con.prepareStatement("SELECT * FROM Employee WHERE EID = 1 AND username = ? AND password = ?");   
            pst.setString(1,user);
            pst.setString(2,pwd);
            resultSet = pst.executeQuery();

            if(resultSet.next()){                   
                return true;        
            }             
            closeConnection();
            
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    public String getPosition(String user, String pwd) throws SQLException{
        String position;
        setConenction();
        pst=con.prepareStatement("SELECT position FROM Employee WHERE username=? AND password=?");
        
        pst.setString(1, user);
        pst.setString(2, pwd);
        resultSet=pst.executeQuery();
        while(resultSet.next()){
            position=resultSet.getString(1);
            return position;
        }
        return null;
        
    }
    
    public int getEmployeeID(String user,String pwd) throws SQLException{
        int eid=0;
        setConenction();
        pst=con.prepareStatement("SELECT EID FROM Employee WHERE username=? AND password=?");
        pst.setString(1, user);
        pst.setString(2, pwd);
        resultSet=pst.executeQuery();
        if(resultSet.next()){
            eid=resultSet.getInt(1);
            return eid;
        }
        
        return eid;
    }
    
    public int getLastPID() throws SQLException{
        int lastPID=0;
        setConenction();
        pst=con.prepareStatement("SELECT MAX(PID) FROM Patient");
        resultSet=pst.executeQuery();
        while(resultSet.next()){
            lastPID=resultSet.getInt(1);
        }
        return lastPID;
    }
    
    public int getLastEID() throws SQLException{
        int lastEID=0;
        setConenction();
        pst=con.prepareStatement("SELECT MAX(EID) FROM Employee");
        resultSet=pst.executeQuery();
        while(resultSet.next()){
            lastEID=resultSet.getInt(1);
        }
        return lastEID;
    }
    
    public int getLastTestID() throws SQLException{
        int lastID=0;
        setConenction();
        pst=con.prepareStatement("SELECT MAX(test_id) FROM Test");
        resultSet=pst.executeQuery();
        while(resultSet.next()){
            lastID=resultSet.getInt(1);
        }
        return lastID;
    }
    
    public int getLastTreatmentID() throws SQLException{
        int lastID=0;
        setConenction();
        pst=con.prepareStatement("SELECT MAX(treatment_id) FROM Treatment");
        resultSet=pst.executeQuery();
        while(resultSet.next()){
            lastID=resultSet.getInt(1);
        }
        return lastID;
    }
    
    public ArrayList<String> getResultList(String pid,String test) throws SQLException{
        ArrayList<String> resultList=new ArrayList();
        setConenction();
        pst=con.prepareStatement("SELECT result FROM Test WHERE PID=? AND test_type=? ORDER BY date DESC LIMIT 10");
        pst.setString(1, pid);
        pst.setString(2, test);
        resultSet=pst.executeQuery();
        while(resultSet.next()){
            resultList.add(resultSet.getString(1));
        }
        closeConnection();
        return resultList;
    }
    
    public ArrayList<String> getDateList(String pid,String test) throws SQLException{
        ArrayList<String> dateList=new ArrayList();
        setConenction();
        pst=con.prepareStatement("SELECT date FROM Test WHERE PID=? AND test_type=? ORDER BY date DESC LIMIT 10");
        pst.setString(1, pid);
        pst.setString(2, test);
        resultSet=pst.executeQuery();
        while(resultSet.next()){
            dateList.add(resultSet.getString(1));
        }
        closeConnection();
        return dateList;
    }
    
    public ArrayList<String> getMedicineList(String pid) throws SQLException{
        ArrayList<String> medicineList=new ArrayList();
        setConenction();
        pst=con.prepareStatement("SELECT medicine_type,dosage FROM Medicine WHERE treatment_id=(SELECT max(treatment_id) FROM Treatment WHERE PID=?);");
        pst.setString(1, pid);
        resultSet=pst.executeQuery();
        while(resultSet.next()){
            medicineList.add(resultSet.getString(1));
            medicineList.add(resultSet.getString(2));
        }
        closeConnection();
        return medicineList;
    }
    
    public String getDetails(String pid) throws SQLException{
        String detail=null;
        setConenction();
        pst=con.prepareStatement("SELECT details FROM Treatment WHERE treatment_id=(SELECT max(treatment_id) FROM Treatment WHERE PID=?);");
        pst.setString(1, pid);
        resultSet=pst.executeQuery();
        while(resultSet.next()){
            detail=resultSet.getString(1);
        }
        closeConnection();
        return detail;
    }
    
    public Patient getPatient(String pid) throws SQLException{
        Patient patient=new Patient();
        setConenction();
        pst=con.prepareStatement("SELECT * FROM Patient WHERE PID=?");
        pst.setString(1, pid);
        resultSet=pst.executeQuery();
        while(resultSet.next()){
            patient.setFirstName(resultSet.getString(2));
            patient.setLastName(resultSet.getString(3));
            patient.setGender(resultSet.getString(4));
            patient.setDate(resultSet.getDate(5));
            patient.setBloodGroup(resultSet.getString(6));
            patient.setAddress(resultSet.getString(7));
            patient.setPhoneNum(resultSet.getString(8));
        }
        return patient;
    }
    
    public String getPosition(String eid) throws SQLException{
        String position;
        setConenction();
        pst=con.prepareStatement("SELECT position FROM Employee WHERE EID=?");
        pst.setString(1, eid);
        resultSet=pst.executeQuery();
        while(resultSet.next()){
            position=resultSet.getString(1);
            return position;
        }
        return null;
        
    }
    
    public Employee getEmployee(String eid) throws SQLException{
        Employee employee=null;
        String position=getPosition(eid);
        setConenction();
        pst=con.prepareStatement("SELECT * FROM Employee WHERE EID=?");
        pst.setString(1, eid);
        resultSet=pst.executeQuery();
        if(null != position)switch (position) {
            case "Doctor":
                employee=new Doctor();
                while(resultSet.next()){
                    employee.setNIC(resultSet.getString(4));
                    employee.setName(resultSet.getString(2));
                    employee.setPosition(resultSet.getString(3));
                    employee.setEmployeeID(resultSet.getInt(1));
                    employee.setUsername(resultSet.getString(5));
                }
                break;
            case "Receptionist":
                employee=new Receptionist();
                while(resultSet.next()){
                    employee.setNIC(resultSet.getString(4));
                    employee.setName(resultSet.getString(2));
                    employee.setPosition(resultSet.getString(3));
                    employee.setEmployeeID(resultSet.getInt(1));
                    employee.setUsername(resultSet.getString(5));
                }
                break;
            case "Lab Technician":
                employee=new LabTechnician();
                while(resultSet.next()){
                    employee.setNIC(resultSet.getString(4));
                    employee.setName(resultSet.getString(2));
                    employee.setPosition(resultSet.getString(3));
                    employee.setEmployeeID(resultSet.getInt(1));
                    employee.setUsername(resultSet.getString(5));
                }
                break;
            case "Medical Assistant":
                employee=new MedicalAssistant();
                while(resultSet.next()){
                    employee.setNIC(resultSet.getString(4));
                    employee.setName(resultSet.getString(2));
                    employee.setPosition(resultSet.getString(3));
                    employee.setEmployeeID(resultSet.getInt(1));
                    employee.setUsername(resultSet.getString(5));
                }
                break;
            case "Manager":
                employee=new Manager();
                while(resultSet.next()){
                    employee.setNIC(resultSet.getString(4));
                    employee.setName(resultSet.getString(2));
                    employee.setPosition(resultSet.getString(3));
                    employee.setEmployeeID(resultSet.getInt(1));
                    employee.setUsername(resultSet.getString(5));
                }
                break;
        }
        closeConnection();
        return employee;
    }
    
    public boolean checkEmployeeNIC(String nic) throws SQLException{
        setConenction();             
        pst = con.prepareStatement("SELECT * FROM Employee WHERE NIC=?");
        pst.setString(1, nic);
        resultSet = pst.executeQuery();
        while(resultSet.next()){ 
            if(resultSet.getString(1).equals(nic)){
                return true;
            }
            
        }    
        con.close(); 
        return false;
    }
}
