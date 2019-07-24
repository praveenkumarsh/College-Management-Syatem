package admin_portal.database_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class retrieveSingleDetails {
    public static String userid = admin_portal.ui.login.LoginPortalController.user;
    public static String name = "Administrator";
    
    public static int retrieveyear(String userid){
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
