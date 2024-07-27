/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.assignmentquestion1;

/**
 *
 * @author aadil
 */

import java.util.Scanner;
import java.security.SecureRandom;

public class AssignmentQuestion1 {
    private double numOne;
    private double numTwo;
    public double answer;
    

    public qGen(double n1, double n2, double ans){
        SecureRandom rnd = new SecureRandom();
        n1 = rnd.nextDouble();
        n2 = rnd.nextDouble();
        ans = n1*n2;
        
        this.numOne = n1;
        this.numTwo = n2;
        this.answer = ans;
        
    }
    public static void main(String[] args) {
        System.out.println("Welcome to The Multiplaction Learning Program!");
        
    }
}
