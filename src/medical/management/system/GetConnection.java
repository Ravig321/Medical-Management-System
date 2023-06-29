/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medical.management.system;

import java.sql.*;

/**
 *
 * @author Ravi Kant Gupta
 */
public class GetConnection {
    
    private Connection conn = null;
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","password");
        }catch(Exception e){
            System.out.println(e);
        }
        finally{
            return conn;
        }
    }
    
 
    
}
