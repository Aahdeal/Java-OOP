
package com.mycompany.p2question1;

// import HashMap to store lecturers
import java.util.HashMap;

/**
 *
 * @author MD.2022.C9B1P8
 *
 */
// Lecturer class to store hashmap containing lecturer names
public class LecturerMap {
    HashMap<String, String> hashMap;
    
    public LecturerMap(HashMap<String, String> hashMap){
        this.hashMap = hashMap;
    }
    
    //getter
    public HashMap<String, String> getHashMap() {
        return hashMap;
    }
    //setter
    public void setHashMap(HashMap<String, String> hashMap) {
        this.hashMap = hashMap;
    }
    
    
}
