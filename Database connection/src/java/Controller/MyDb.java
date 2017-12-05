/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author oskar
 */
public class MyDb {
    
    public Connection con;
    
    public Connection getCon(){
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con =  DriverManager.getConnection("jdbc:mysql://10.114.34.143/lorembox","dbuser","loremipsum");
            System.out.println("Connected to database");
            
        } catch (ClassNotFoundException e) {
            
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        } catch (SQLException e) {
            
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
        return con;
        }
}
    

