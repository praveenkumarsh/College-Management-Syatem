/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin_portal.connectstudentandinformation;

/**
 *
 * @author Praveen
 */
public class connect1 {
    public static int delete(String userid){
        int year = admin_portal.database_connection.retrieveSingleDetails.retrieveyear(userid);
        int d1 = admin_portal.database_connection.DaoStudent.delete(userid);
        int d2 = admin_portal.database_connection.DaoStudentInformation.delete(userid);
        int d3 = admin_portal.database_connection.DaoStudentAttendance.delete(year, userid);
        if(d1== 1){
            System.out.println("Userid Delete");
        }
        if(d2 == 1){
            System.out.println("Information Delete");
        }
        if(d3 == 1){
            System.out.println("Attendance Delete");
        }
        if(d1==1&&d2==1&&d3 == 1){
            return 1;
        }else{
            return 0;
        }
    }
    
    
}
