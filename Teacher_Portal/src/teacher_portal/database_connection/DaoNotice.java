package teacher_portal.database_connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoNotice {

    public static int update(String ImpNotice, String Notice1, String Notice2, String Notice3,int clas) {
        int status = 0;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE notice SET ImpNotice=?,Notice1=?,Notice2=?,Notice3=? WHERE Sno=?");
            System.out.println("hello");
            ps.setString(1, ImpNotice);
            ps.setString(2, Notice1);
            ps.setString(3, Notice2);
            ps.setString(4, Notice3);
            ps.setInt(5, clas);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static boolean checkData(int clas) {
        boolean status = false;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from notice where Sno=?");
            ps.setInt(1, clas);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
}
