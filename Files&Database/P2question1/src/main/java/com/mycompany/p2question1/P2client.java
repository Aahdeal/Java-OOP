
package com.mycompany.p2question1;

/**
 *
 * @author aadik
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class P2client {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 8090;

        try (
            Socket socket = new Socket(serverAddress, serverPort);
                
            BufferedReader input = 
                    new BufferedReader(new InputStreamReader(
                            socket.getInputStream()));
            PrintWriter output = 
                    new PrintWriter(socket.getOutputStream(), 
                            true);

            BufferedReader userInput = 
                    new BufferedReader(new InputStreamReader(System.in))
        ) 
        {
            System.out.print("Enter the name of the campus: ");
            String campusName = userInput.readLine();

            output.println(campusName);

            String name = input.readLine();

            System.out.println("Lecturer name for campus '" + 
                    campusName + "': " + name);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
