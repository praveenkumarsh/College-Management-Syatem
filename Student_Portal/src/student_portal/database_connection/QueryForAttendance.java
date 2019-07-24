
package student_portal.database_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class QueryForAttendance {

    public static int gettotal(int yr, String name, String sub) {
        Connection con = DB.getConnection();
        int ans = 0;
        ResultSet rs = null;
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
            String query1 = "SELECT COUNT('" + name + "') FROM "+year+" WHERE subcode = '"+sub+"';";
            PreparedStatement ps1 = con.prepareStatement(query1);
            rs = ps1.executeQuery();
            if (rs.next()) {
                ans = rs.getInt(1);
                System.out.println("numberOfRows= " + ans);
            } else {
                System.out.println("error: could not get the record counts");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ans;
    }

    public static int getpresent(int yr, String userid, String sub) {
        Connection con = DB.getConnection();
        int ans = 0;
        ResultSet rs = null;
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
            String query1 = "SELECT COUNT(`" + userid + "`) FROM "+year+" where subcode = '"+sub+"' AND `"+ userid + "` =1;";
            System.out.println(query1);
            PreparedStatement ps1 = con.prepareStatement(query1);
            rs = ps1.executeQuery();
            if (rs.next()) {
                ans = rs.getInt(1);
                System.out.println("numberOfPresentDays= " + ans);
            } else {
                System.out.println("error: could not get the record counts");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ans;
    }
}
