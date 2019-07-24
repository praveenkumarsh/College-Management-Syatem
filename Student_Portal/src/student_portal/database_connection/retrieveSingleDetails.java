/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_portal.database_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Praveen
 */
public class retrieveSingleDetails {
    public static String userid = student_portal.ui.login.LoginPortalController.user;
    public static String name = retrievefullname();
    public static int year = retrieveyear();
    //retrieve clas
    //retrieve full name
    public static String retrievefullname(){
        String name = "";
        if (DaoStudentInformation.checkData(userid)) {
                try {
                    int status = 0;
                    System.out.println("Connecting to database");
                    Connection con = DB.getConnection();
                    PreparedStatement ps = con.prepareStatement("select * from studentinformation where userid=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    System.out.println("Connected");
                    ps.setString(1, userid);
                    ResultSet rs = ps.executeQuery();
                    rs.beforeFirst();
                    rs.next();
                    name = (rs.getString(2));
                    con.close();
                } catch (SQLException ex) {
                }
            } else {
                System.out.println("Error: Record Not Found");
            }
        return name;
    }
    
    public static int retrieveyear(){
        int clas = 0;
        if (DaoStudentInformation.checkData(userid)) {
                try {
                    int status = 0;
                    System.out.println("Connecting to database");
                    Connection con = DB.getConnection();
                    PreparedStatement ps = con.prepareStatement("select * from studentinformation where userid=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    System.out.println("Connected");
                    ps.setString(1, userid);
                    ResultSet rs = ps.executeQuery();
                    rs.beforeFirst();
                    rs.next();
                    clas = (rs.getInt(5));
                    con.close();
                } catch (SQLException ex) {
                }
            } else {
                System.out.println("Error: Record Not Found");
            }
        return clas;
    }
    
}
