
package com.mycompany.p2question1;

/**
 *
 * @author MD.2022.C9B1P8
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class question2{
    HashMap<String, String> hashMap = new HashMap<>();
    
    //database connection details
    final String DATABASE_URL = "jdbc:mysql://localhost:3306/lecturers";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    private Connection connection; // manages connection
    
    //SQL CODE
    String createQuery = 
                "CREATE TABLE lecturerdetails (" +
                "lecturerID INT AUTO_INCREMENT PRIMARY KEY," +
                "Name VARCHAR(45)," +
                "Surname VARCHAR(45)," +
                "Campus VARCHAR(45)" +
                ")";
    
    String dropTable = "DROP TABLE IF EXISTS lecturerDetails";
    
    String insertQuery = 
            "INSERT INTO lecturerdetails (Name, Surname, Campus) "
            + "VALUES (?, ?, ?)";
    
    String getLecturers = "SELECT * FROM lecturerdetails";
    
    //connects to database
    public question2(){
        
        try {
         connection = 
            DriverManager.getConnection(DATABASE_URL, 
                    USERNAME, PASSWORD);
            
            
        }
        catch (SQLException sqlException) {
         sqlException.printStackTrace();
         System.exit(1);
      }
    }
    
    //creates table
    public void createTable(){
                
        try {
         connection = 
            DriverManager.getConnection(DATABASE_URL, 
                    USERNAME, PASSWORD);
         //execute SQL code   
         PreparedStatement preparedStatement = 
                 connection.prepareStatement(createQuery);
         preparedStatement.executeUpdate(dropTable);
         preparedStatement.executeUpdate(createQuery);
        }
        catch (SQLException sqlException) {
         sqlException.printStackTrace();
         System.exit(1);
      }
    }
    
    //select lecturer to display
    public List<String> selectLecturer(){
        
        try{
            PreparedStatement selectL = 
                    connection.prepareStatement(getLecturers);
            try(ResultSet resultSet = selectL.executeQuery()){
                List<String> results = new ArrayList<String>();
                
                System.out.printf("%-20s%-20s%-20s%-20s%n",
                        "Lecturer ID","Name","Surname",
                        "Campus");
                while (resultSet.next()) {
                    int lecturerID = resultSet.getInt("lecturerID");
                    String name = resultSet.getString("name");
                    String surname = resultSet.getString("surname");
                    String campus = resultSet.getString("campus");
                    
                   
                    System.out.printf("%-20d%-20s%-20s%-20s%n",
                            lecturerID,name,surname,campus);
         } 

         return results;
                
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return null;       
    }
    
    //Add lecturers to table
    public int AddLecturer(String Name, String Surname, String Campus){
        try{
            PreparedStatement preparedStatement = 
                    connection.prepareStatement(insertQuery);
            
            preparedStatement.setString(1, Name);
            preparedStatement.setString(2, Surname);
            preparedStatement.setString(3, Campus);
            
            return preparedStatement.executeUpdate();
        
    }
        catch(SQLException sqlException){}
        return 0;
    }
}
    
