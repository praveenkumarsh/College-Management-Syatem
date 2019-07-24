package student_portal.ui.notice;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import student_portal.database_connection.DB;
import student_portal.database_connection.DaoNotice;

public class NoticeController implements Initializable {

    @FXML
    private Label prevnotice1;
    @FXML
    private Label prevnotice2;
    @FXML
    private Label prevnotice3;
    @FXML
    private Label impnote;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String usr = student_portal.database_connection.retrieveSingleDetails.userid;
        int clas = student_portal.database_connection.retrieveSingleDetails.retrieveyear();
        if (clas == 0) {

        } else {
            System.out.println("class " + clas);
            retievenotice(clas, usr);
        }
    }

    void retievenotice(int sid, String usr) {
        if (sid == 0) {
            System.out.println("class can't be blank");
        } else {
            System.out.println("Executing Script");
            int id = sid;
            if (DaoNotice.checkData(id)) {
                try {
                    int status = 0;
                    System.out.println("Connecting to database");
                    Connection con = DB.getConnection();
                    PreparedStatement ps = con.prepareStatement("select * from notice where Sno=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    System.out.println("Connected");
                    ps.setInt(1, id);
                    ResultSet rs = ps.executeQuery();
                    rs.beforeFirst();
                    rs.next();
                    impnote.setText(rs.getString(1));
                    prevnotice1.setText(rs.getString(2));
                    prevnotice2.setText(rs.getString(3));
                    prevnotice3.setText(rs.getString(4));
                    con.close();
                } catch (SQLException ex) {
                    System.out.println("Exception Caught");
                }
            } else {
                System.out.println("Error: Record Not Found");
            }
        }
    }

}
