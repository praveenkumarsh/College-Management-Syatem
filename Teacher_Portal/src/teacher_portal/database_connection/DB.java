//For Link With MySQL


package teacher_portal.database_connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Praveen
 */

public class DB {
    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String host = "localhost";
            String port = "3306";
            String dbname = "collegemanagement";
            String url="jdbc:mysql://"+host+":"+port+"/"+dbname+"?allowPublicKeyRetrieval=true&useSSL=false";
            String user="root";
            String password="";
            con=DriverManager.getConnection(url, user, password);
        } catch(Exception e){
            System.out.println(e);
        }
        return con;
        
    }
}
