/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin_portal.database_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Praveen
 */
public class DaoStudentAttendance {

    public static int delete(int yr,String name) {
        int status1 = 1;
        int status = 1;
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
        try {
            Connection con = DB.getConnection();
            String query1 = "ALTER TABLE `"+year+"` DROP `"+name+"`;";
            PreparedStatement ps1 = con.prepareStatement(query1);
            status = ps1.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status1;
    }

}
