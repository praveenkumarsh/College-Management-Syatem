package student_portal.ui.dashboard;

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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import student_portal.database_connection.DB;
import student_portal.database_connection.DaoStudentInformation;
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
    private JFXTextField program;
    @FXML
    private JFXTextField discipline;
    @FXML
    private JFXTextField stage;
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
    private Label infolabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Stage stag = new Stage(StageStyle.DECORATED);
        start(stag);
        String id = student_portal.database_connection.retrieveSingleDetails.userid;
        retirevealldetails(id);
        // TODO
    }

    @FXML
    private void handleupdateprofile(ActionEvent event) {
        String userID1 = userid.getText();
        String uname1 = username.getText();
        String program1 = this.program.getText();
        String discipline1 = this.discipline.getText();
        int stage1 = Integer.parseInt(this.stage.getText());
        String emailid1 = emailid.getText();
        String dob1 = this.dob.getText();
        String fathername1 = this.fathername.getText();
        String mothername1 = this.mothername.getText();
        String address1 = this.address.getText();
        int pno1 = Integer.parseInt(this.phoneno.getText());
        String imgpath1 = picpath;
        int x = DaoStudentInformation.update(userID1, uname1, program1, discipline1, stage1, emailid1, dob1, fathername1, mothername1, address1, pno1, imgpath1, istream);
        if (x == 1) {
            infolabel.setText("Successfully Updated");
        } else {
            infolabel.setText("Error Occurred While Updating");
        }
    }

    private void retirevealldetails(String usrid) {
        if (usrid.equals("")) {
            infolabel.setText("Userid can't be blank");
            System.out.println("Userid can't be blank");
        } else {
            System.out.println("Executing Script");
            if (DaoStudentInformation.checkData(usrid)) {
                try {
                    int status = 0;
                    System.out.println("Connecting to database");
                    Connection con = DB.getConnection();
                    PreparedStatement ps = con.prepareStatement("select * from studentinformation where userid=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    System.out.println("Connected");
                    ps.setString(1, usrid);
                    ResultSet rs = ps.executeQuery();
                    rs.beforeFirst();
                    rs.next();
                    userid.setText(rs.getString(1));
                    username.setText(rs.getString(2));
                    program.setText(rs.getString(3));
                    discipline.setText(rs.getString(4));
                    int s = rs.getInt(5);
                    stage.setText(String.valueOf(rs.getInt(5)));
                    emailid.setText(rs.getString(6));
//                    Date d = rs.getDate(7);
                    System.out.println("date retrieved");
                    dob.setText(rs.getString(7));
                    System.out.println("set");
                    fathername.setText(rs.getString(8));
                    mothername.setText(rs.getString(9));
                    address.setText(rs.getString(10));
                    phoneno.setText(String.valueOf(rs.getInt(11)));
                    byte[] pic = rs.getBytes(12);
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
            EventHandler<ActionEvent> event
                    = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
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
