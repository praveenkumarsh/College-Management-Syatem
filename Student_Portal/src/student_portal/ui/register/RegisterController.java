package student_portal.ui.register;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import student_portal.database_connection.DaoStudent;
import student_portal.ui.alert.alertpane;

public class RegisterController implements Initializable {

    private final static Logger LOGGER = LogManager.getLogger(RegisterController.class.getName());
    student_portal.ui.alert.alertpane ap;
    @FXML
    private JFXTextField userid;
    @FXML
    private JFXTextField emailid;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXPasswordField repassword;
    @FXML
    private Label errortext;
    @FXML
    private AnchorPane apane2;
    @FXML
    private JFXTextField currentyear;
    
    public static int curryear = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        student_portal.ui.alert.alertpane ap;
    }

    @FXML
    private void signupformsubmit(ActionEvent event) {
        System.out.println("Adding student Operation Started");
        String name = userid.getText();
        String passwrd = this.password.getText();
        String email = emailid.getText();
        curryear = Integer.parseInt(currentyear.getText());
        String repasswrd = this.repassword.getText();
        if (!passwrd.equals(repasswrd)) {
            repassword.getStyleClass().add("wrong-credentials");
            password.getStyleClass().add("wrong-credentials");
        } else {
            if (name == null || name.trim().equals("")) {
                userid.getStyleClass().add("wrong-credentials");
            } else {
                if (!DaoStudent.checkData(name)) {
                    int i = student_portal.connectstudentandinformation.connect1.save(name, passwrd, email);
                    if (i > 0) {
                        LOGGER.log(Level.INFO, "Student successfully Added {}", name);
                        System.out.println("Student Sucessfully Added");
                        ap = new alertpane("Student Successfully Added", "", "Alert");
                    } else {
                        System.out.println("Error: Unable to add");
                        ap = new alertpane("Sorry, unable to add!", "", "Alert");
                    }
                } else {
                    System.out.println("Error: Id Existed Already");
                    ap = new alertpane("Sorry, Student id already exist", "", "Alert");
                }
            }
            System.out.println("Signup Completed");
        }
    }

    @FXML
    private void exitregisterform(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/student_portal/ui/login/LoginPortal.fxml"));
        apane2.getChildren().setAll(pane);
        student_portal.ui.main.Student_Portal.stag.setTitle("Portal Login");
    }

}
