/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_portal.database_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Praveen
 */
public class DaoStudentAttendance {

    public static int save(int yr, String name) {//, String address, String city, String contact, String imgpath) {
        int status = 0;
        int status1 = 1;
        String year = "";
        if(yr == 1){
            year = "firstyear";
        }else if(yr == 2){
            year = "secondyear";
        }else if(yr==3){
            year = "thirdyear";
        }else if(yr == 4){
            year = "forthyear";
        }
        try {
            Connection con = DB.getConnection();
            String query = "ALTER TABLE `"+year+"` ADD `"+name+"` INT(2) NOT NULL DEFAULT '0' AFTER `subcode`;";
            PreparedStatement ps1 = con.prepareStatement(query);
            status = ps1.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status1;
    }

}
