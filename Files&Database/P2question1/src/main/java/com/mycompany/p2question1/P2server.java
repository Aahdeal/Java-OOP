
package com.mycompany.p2question1;

/**
 *
 * @author aadik
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class P2server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8090)) {
            System.out.println("Server listening on port 8090");

            while (true) {
                Socket cSocket = serverSocket.accept();
                System.out.println("Connected to Client: " + 
                        cSocket.getInetAddress().getHostAddress());

                Thread cThread = 
                        new Thread(new cHandler(cSocket));
                cThread.start();
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    private static class cHandler implements Runnable {
        private Socket cSocket;

        public cHandler(Socket cSocket) {
            this.cSocket = cSocket;
        }

        @Override
        public void run() {
            try (
                BufferedReader input = 
                        new BufferedReader(new InputStreamReader(
                                cSocket.getInputStream()));
                PrintWriter output = 
                        new PrintWriter(cSocket.getOutputStream(), 
                                true)
            ) {
                String campusName = input.readLine();
                System.out.println("Received campus name: " + campusName);

                String lecturerName = queryLecturerName(campusName);

                output.println(lecturerName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String queryLecturerName(String campusName) {

            String url = "jdbc:mysql://localhost:3306/lecturers";
            String username = "root";
            String password = "";

            String selectQuery = "SELECT * FROM lecturerdetails WHERE Campus = ?";

            try (
                Connection connection = 
                        DriverManager.getConnection(url, 
                                username, password);
                PreparedStatement preparedStatement = 
                        connection.prepareStatement(selectQuery)
            ) {
                preparedStatement.setString(1, campusName);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String surname = resultSet.getString("surname");
                    String fullname = name +" "+surname;
                    
                    return fullname;
                }
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
            return "Lecturer not found";
        }
    }
}

    

