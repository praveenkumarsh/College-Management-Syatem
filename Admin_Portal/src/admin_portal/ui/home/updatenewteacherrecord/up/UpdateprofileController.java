/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin_portal.ui.home.updatenewteacherrecord.up;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import admin_portal.database_connection.DB;
import admin_portal.database_connection.DaoTeacherInformation;
//import teacher_portal.ui.alert.alertpane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Praveen
 */
public class UpdateprofileController implements Initializable {

    @FXML
    private Label dashboardmain;
    @FXML
    private ImageView studentphoto;
    @FXML
    private JFXTextField userid;
    @FXML
    private JFXTextField emailid;
    @FXML
    private JFXTextField dob;
    @FXML
    private JFXTextField fathername;
    @FXML
    private JFXTextField mothername;
    @FXML
    private JFXTextField phoneno;
    @FXML
    private JFXTextArea address;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXButton uploadbutton;

    String picpath = "";
    InputStream istream = null;
    @FXML
    private Label labelinfo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Stage stage = new Stage(StageStyle.DECORATED);
        start(stage);
        String userid = admin_portal.ui.home.updatenewteacherrecord.UpnewteacherrecController.userid;
        retirevealldetails(userid);
        // TODO
    }

    @FXML
    private void handleupdateprofile(ActionEvent event) {
        String userID1 = userid.getText();
        String uname1 = username.getText();
        String emailid1 = emailid.getText();
        String dob1 = this.dob.getText();
        String fathername1 = this.fathername.getText();
        String mothername1 = this.mothername.getText();
        String address1 = this.address.getText();
        int pno1 = Integer.parseInt(this.phoneno.getText());
        String imgpath1 = picpath;
        int x = DaoTeacherInformation.update(userID1, uname1, emailid1, dob1, fathername1, mothername1, address1, pno1, imgpath1,istream);
        if(x == 1){
            labelinfo.setText("Updated Successfully");
            System.out.println("Updated Successfully");
        }else{
            labelinfo.setText("Error occur while uploading");
            System.out.println("Error occur while uploading");
        }
    }

    private void retirevealldetails(String usrid) {
        if (usrid.equals("")) {
            System.out.println("Userid can't be blank");
        } else {
            System.out.println("Executing Script");
            if (DaoTeacherInformation.checkData(usrid)) {
                try {
                    int status = 0;
                    System.out.println("Connecting to database");
                    Connection con = DB.getConnection();
                    PreparedStatement ps = con.prepareStatement("select * from teacherinformation where userid=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    System.out.println("Connected");
                    ps.setString(1, usrid);
                    ResultSet rs = ps.executeQuery();
                    rs.beforeFirst();
                    rs.next();
                    userid.setText(rs.getString(1));
                    username.setText(rs.getString(2));
                    emailid.setText(rs.getString(3));
                    System.out.println("date retrieved");
                    dob.setText(rs.getString(4));
                    System.out.println("set");
                    fathername.setText(rs.getString(5));
                    mothername.setText(rs.getString(6));
                    address.setText(rs.getString(7));
                    phoneno.setText(String.valueOf(rs.getInt(8)));
                    byte[] pic = rs.getBytes(9);
                    InputStream myInputStream = new ByteArrayInputStream(pic);
                    istream = myInputStream;
                    Image img = new Image(myInputStream);
                    studentphoto.setImage(img);
                    con.close();
                } catch (SQLException ex) {
                    System.out.println("Exception Caught");
                }
            } else {
                System.out.println("Error: Record Not Found");
            }
        }
    }

    @FXML
    private void handleuploadimage(MouseEvent event) {
    }

    public void start(Stage stage) {
        try {
            FileChooser fil_chooser = new FileChooser();
            fil_chooser.setTitle("Select File");
            fil_chooser.setInitialDirectory(new File("e:\\"));
//            Label label = new Label("no files selected");
            EventHandler<ActionEvent> event
                    = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    // get the file selected 
                    File file = fil_chooser.showOpenDialog(stage);
                    if (file != null) {
                        picpath = file.getAbsolutePath();
                        InputStream myInputStream = null;
                        try {
                            myInputStream = new FileInputStream(picpath);
                            
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(UpdateprofileController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        Image img = new Image(myInputStream);
                        studentphoto.setImage(img);
                    }
                }
            };
            uploadbutton.setOnAction(event);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
