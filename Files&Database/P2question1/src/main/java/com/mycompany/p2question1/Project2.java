
package com.mycompany.p2question1;

// import declarations
import java.io.IOException;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author MD.2022.C9B1P8
 */
public class Project2 {
    public static void main(String[] args){
        
        System.out.println("Welcome to Lecturer Details Application:");
        
        //Create scanner for program input
        Scanner i = new Scanner(System.in);
        HashMap<String, String> map = new HashMap<>();            
        LecturerMap LM = new LecturerMap(map); //create object
        
        boolean program = true;
            
            //open text file
            try(Scanner input = 
                    new Scanner(Paths.get("lecturerNames.txt"))){
                
            System.out.println("Reading file...");
            
             
            int c = 0;
            //read file 
            while (input.hasNext()){
            String x = input.next();    
            String[] split = x.split(",");
            if (split.length>=2){
                //split name and surname
                LM.hashMap.put(split[0].trim(), split[1].trim());
                c++;
            }
            else;
            }
            
        
            System.out.println("Lecturer Hash Map:\n");
            mapforDisplay(LM.getHashMap()); //display method
            
            }catch(IOException | IllegalStateException e){e.printStackTrace();} 
            
            //program loop
            do{
                
            System.out.println(
                    "\nEnter 1 to Find and Delete your lecturer\n"+
                            "Enter 2 to add Lecturers to Database\n"+
                            "Enter 3 to Rerun Application\n"+
                            "Enter other number to end program.");
            int ui = i.nextInt();
            
            switch(ui){
                case 1: //delete lecturer method
                    DeleteLecturer(LM.getHashMap()); 
                    
                    break;
                case 2: 
                    //Generates campus for individual lecturers
                    String[] lecturerList = new String[9];
                    GenerateCampus(LM.getHashMap(), lecturerList);   
                    question2 q2 = new question2();
                    
                    //connect to database and create table
                    q2.createTable();  
                    int count = 0;
                    // add lecturers
                    for(String key : LM.getHashMap().keySet()){
                        q2.AddLecturer(key, 
                                LM.getHashMap().get(key), 
                                lecturerList[count]);
                        count++;
                    }
                    
                    System.out.println("\nConnected to Database.");
                    System.out.println("Lecturers Added to Database.\n");
             System.out.println("Getting Lecturers stored in database...\n");
                    // display lecturers
                    q2.selectLecturer();
                        
                    program = false;
                      
                case 3: 
                    program = true; //repeat program
                    break;
                default: 
                    program = false; //end program
                    break;
                
            }        
        }while(program);
        
    }
    
    //display for loop
    public static void mapforDisplay(Map<String, String> map){
        for(String key : map.keySet()){
            System.out.printf("{%s=%s}%n",key,map.get(key));
        }
    }
    
    //Delete lecturer method
    public static void DeleteLecturer(HashMap<String, String> map){
        System.out.println("Please enter the name of your lecturer:");
        Scanner userInput = new Scanner(System.in);
        String uI = userInput.next();
        
        System.out.println();
        
        if (map.containsKey(uI)) {
            map.remove(uI);
            mapforDisplay(map);
            System.out.println("\nLecturer Successfully Deleted!");}
        else {map.remove("arsene");
        mapforDisplay(map);
        System.out.println("\nLecturer Arsene Deleted!");}
        }
    
    //Campus generator
 public static void GenerateCampus(HashMap<String, String> map, String[] list){
        
        //Array containing campus names
        String[] campusNames = 
        {"Port Elizabeth","Vanderbijlpark","Midrand","Bedfordview",
            "Bloemfontein","Claremont","Tyger Valley","East London",
            "Potchefstroom","Nelspruit","Umhlanga","Pretoria"};

        SecureRandom rnd = new SecureRandom();
        //loop to campus
        for (int i = 0; i <= map.size()+1;i++){
            int x = rnd.nextInt(12);
            if (campusNames[x] == ""){
                x = rnd.nextInt(12);
                list[i] = campusNames[x];
                campusNames[x] = ""; 
            }
            else {
                list[i] = campusNames[x];
                campusNames[x] = ""; 
            } 
        }
    }
    
}
