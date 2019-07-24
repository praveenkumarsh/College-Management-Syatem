/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_portal.database_connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Praveen
 */
public class DBAttendance {
    public static Connection getConnection(int yr){
        String year = "";
        if (yr == 0) {
            
        } else if (yr == 1) {
            year = "firstyear";
        } else if (yr == 2) {
            year = "secondyear";
        } else if (yr == 3) {
            year = "thirdyear";
        } else if (yr == 4) {
            year = "forthyear";
        }
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String host = "localhost";
            String port = "3306";
            String dbname = year;
            String url="jdbc:mysql://"+host+":"+port+"/"+dbname+"?allowPublicKeyRetrieval=true&useSSL=false";
            String user="root";
            String password="";
            con=DriverManager.getConnection(url, user, password);
        } catch(Exception e){
            System.out.println(e);
        }
        return con;
        
    }
}
