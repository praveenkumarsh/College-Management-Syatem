package admin_portal.database_connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import admin_portal.database_connection.DB;

public class DaoTeacherInformation {

    public static boolean checkData(String userid) {
        boolean status = false;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from teacherinformation where userid=?");
            ps.setString(1, userid);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int update(String userid, String name, String email, String dob, String fathername, String mothername, String address, int pno, String imgpath, InputStream istream) {
        String query = "";
        query = "UPDATE teacherinformation SET userid=?,name=?,emailid=?,dob=?,fathername=?,mothername=?,address=?,phoneno=?,profilephoto=? WHERE userid=?";
        int status = 0;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            System.out.println("hello");
            ps.setString(1, userid);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, dob);
            ps.setString(5, fathername);
            ps.setString(6, mothername);
            ps.setString(7, address);
            ps.setInt(8, pno);
            if (imgpath.equals("")) {
                ps.setBlob(9, istream);
            } else {
                InputStream img = new FileInputStream(new File(imgpath));
                ps.setBlob(9, img);
            }
            ps.setString(10, userid);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

}
