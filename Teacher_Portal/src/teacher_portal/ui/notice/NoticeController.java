package teacher_portal.ui.notice;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import teacher_portal.database_connection.DaoNotice;
//import teacher_portal.database_connection.DB;
import teacher_portal.database_connection.DB;
import teacher_portal.database_connection.DaoTeacher;
//import student_portal.ui.alert.alertpane;
//import student_portal.ui.alert.alertpane;

public class NoticeController implements Initializable {

    @FXML
    private JFXTextArea prevnotice1;
    @FXML
    private JFXTextArea prevnotice2;
    @FXML
    private JFXTextArea prevnotice3;
    @FXML
    private JFXTextArea impnote;
    @FXML
    private JFXButton firstbutton;
    @FXML
    private JFXButton secondbutton;
    @FXML
    private JFXButton thirdbutton;
    @FXML
    private JFXButton fourthbutton;
    @FXML
    private Label yrlabel;
    @FXML
    private JFXButton updatenoticebutton;
    @FXML
    private Label labelinfo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    void retievenotice(int sid) {
        if (sid == 0) {
            System.out.println("class can't be blank");
//            student_portal.ui.alert.alertpane ap = new alertpane("Dear " + usr + " Please update your Class First In dashBoard");
        } else {
            System.out.println("Executing Script");
            int id = sid;
            if (DaoNotice.checkData(id)) {
                try {
                    int status = 0;
                    System.out.println("Connecting to database");
                    try (Connection co = DB.getConnection()) {
                        PreparedStatement ps = co.prepareStatement("select * from notice where Sno=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        System.out.println("Connected");
                        ps.setInt(1, id);
                        ResultSet rs = ps.executeQuery();
                        rs.beforeFirst();
                        rs.next();
                        impnote.setText(rs.getString(1));
                        prevnotice1.setText(rs.getString(2));
                        prevnotice2.setText(rs.getString(3));
                        prevnotice3.setText(rs.getString(4));
                    }
                } catch (SQLException ex) {
                    System.out.println("Exception Caught");
                }
            } else {
                System.out.println("Error: Record Not Found");
            }
        }
    }

    @FXML
    private void handlefirstyear(ActionEvent event) {
        int year = 1;
        yrlabel.setText(String.valueOf(year));
        retievenotice(year);
        
    }

    @FXML
    private void handlefsecondyear(ActionEvent event) {
        int year = 2;
        yrlabel.setText(String.valueOf(year));
        retievenotice(year);
    }

    @FXML
    private void handlethirdyear(ActionEvent event) {
        int year = 3;
        yrlabel.setText(String.valueOf(year));
        retievenotice(year);
    }

    @FXML
    private void handlefourthyear(ActionEvent event) {
        int year = 4;
        yrlabel.setText(String.valueOf(year));
        retievenotice(year);
    }

    @FXML
    private void handleupdatenotice(ActionEvent event) {
        int year = Integer.parseInt(yrlabel.getText());
        String impnotices = impnote.getText();
        String prevnotices1 = prevnotice1.getText();
        String prevnotices2 = prevnotice2.getText();
        String prevnotices3 = prevnotice3.getText();
        updatenoticeindatabase(year,impnotices,prevnotices1,prevnotices2,prevnotices3);
    }

    private void updatenoticeindatabase(int year, String impnotices, String prevnotices1, String prevnotices2, String prevnotices3) {
        int check = DaoNotice.update(impnotices, prevnotices1 , prevnotices2, prevnotices3, year);
        if(check == 1){
            labelinfo.setText("Updated Successfully");
            System.out.println("Updated");
        }else{
            labelinfo.setText("Error Occur While Updating");
            System.out.println("Can't Update");
        }
    }

}
