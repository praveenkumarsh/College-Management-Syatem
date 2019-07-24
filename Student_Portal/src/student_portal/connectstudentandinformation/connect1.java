/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_portal.connectstudentandinformation;

/**
 *
 * @author Praveen
 */
public class connect1 {
    public static int save(String userid,String password,String emailid){
        int year = student_portal.ui.register.RegisterController.curryear;
        int d1 = student_portal.database_connection.DaoStudent.save(userid, password, emailid);
        int d2 = student_portal.database_connection.DaoStudentInformation.save(userid, "", "", "", year, emailid, "0000-00-00", "", "", "", 0, "./src/student_portal/ui/login/user.png");
        int d3 = student_portal.database_connection.DaoStudentAttendance.save(year, userid);
        if(d1==1&&d2==1&&d3 == 1){
            return 1;
        }else{
            return 0;
        }
//return d1;
    }
}
