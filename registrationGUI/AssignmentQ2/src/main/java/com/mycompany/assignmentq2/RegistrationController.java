package com.mycompany.assignmentq2;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import javafx.event.ActionEvent;

public class RegistrationController {    
   
    class User{
        String uName;
        String uDOB;
        String uAge;
    }
    
   ArrayList<User> uDetails = new ArrayList<User>();
    
    @FXML
    private TextField userName;
    @FXML
    private TextField userDOB;
    @FXML
    private TextField userAge;
    @FXML
    private Label output;
    
    
    @FXML
    private void createButtonPressed(ActionEvent event){
        try{
            User u = new User();
        
            u.uName = userName.getText();
            u.uDOB = userDOB.getText();
            u.uAge = userAge.getText();
            
            uDetails.add(u);
            
            output.setText("User has been successfully registered at position " + uDetails.size());
        }
        catch(IllegalArgumentException ae){
            userName.setText("Enter Name:");
            userDOB.setText("Enter DOB:");
            userAge.setText("Enter Age:");        
        }
    }
    
    @FXML
    private void searchButtonPressed(ActionEvent search){
        String Name;
        Name = userName.getText();
        
        for (int c = 1; c < uDetails.size(); c++){
            if (Name.equals(uDetails.get(c).uName)){
                output.setText("User" + uDetails.get(c).uName + "is registered and is " + uDetails.get(c).uAge + " years old");
            }
            else {
                output.setText("User is not registered.");
            }    
        }   
    }
   
    
    }

