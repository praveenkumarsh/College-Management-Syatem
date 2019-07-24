package admin_portal.database_connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

public class DaoStudentInformation {

    public static int save(String userid, String name, String program, String discipline, int stage, String email, String dob, String fathername, String mothername, String address, int pno, String imgpath) {//, String address, String city, String contact, String imgpath) {
        int status = 0;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into studentinformation(userid,name,program,discipline,stage,emailid,dob,fathername,mothername,address,phoneno,profilephoto) values(?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, userid);
            ps.setString(2, name);
            ps.setString(3, program);
            ps.setString(4, discipline);
            ps.setInt(5, stage);
            ps.setString(6, email);
            ps.setString(7, dob);
            ps.setString(8, fathername);
            ps.setString(9, mothername);
            ps.setString(10, address);
            ps.setInt(11, pno);
            InputStream img = new FileInputStream(new File(imgpath));
            ps.setBlob(12, img);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int delete(String name) {
        int status = 0;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from studentinformation where userid=?");
            ps.setString(1, name);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static boolean validate(String name, String password) {
        boolean status = false;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from student where name=? and password=?");
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static boolean checkData(String userid) {
        boolean status = false;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from studentinformation where userid=?");
            ps.setString(1, userid);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static boolean checkData2(int clas) {
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

    public static int update(String userid, String name, String program, String discipline, int stage, String email, String dob, String fathername, String mothername, String address, int pno, String imgpath, InputStream istream) {
        String query = "";
        query = "UPDATE studentinformation SET userid=?,name=?,program=?,discipline=?,stage=?,emailid=?,dob=?,fathername=?,mothername=?,address=?,phoneno=?,profilephoto=? WHERE userid=?";
        int status = 0;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            System.out.println("hello");
            ps.setString(1, userid);
            ps.setString(2, name);
            ps.setString(3, program);
            ps.setString(4, discipline);
            ps.setInt(5, stage);
            ps.setString(6, email);
            ps.setString(7, dob);
            ps.setString(8, fathername);
            ps.setString(9, mothername);
            ps.setString(10, address);
            ps.setInt(11, pno);
            if (imgpath.equals("")) {
                ps.setBlob(12, istream);
            } else {
                InputStream img = new FileInputStream(new File(imgpath));
                ps.setBlob(12, img);
            }
            ps.setString(13, userid);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

}
