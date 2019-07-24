package teacher_portal.ui.login;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
//import student_portal.database_connection.DaoStudent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import teacher_portal.database_connection.DaoTeacher;

public class LoginPortalController implements Initializable {

    private final static Logger LOGGER = LogManager.getLogger(LoginPortalController.class.getName());
    
    private Label label;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private Label forgotpassword;
    @FXML
    private AnchorPane apane;

    public static String user = "";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        teacher_portal.database_connection.retrieveSingleDetails.userid = user;
    }

    @FXML
    private void handleForgotPassword(MouseEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setContentText("Please Contact To System Administrator");
        alert.setTitle("Forgot Password ?");
        alert.setHeaderText("");
        alert.showAndWait();
    }

    private void closeStage() {
        ((Stage) username.getScene().getWindow()).close();
    }

    void loadMain() {
        try {
            teacher_portal.database_connection.retrieveSingleDetails.userid = user;
            System.out.println("enter");
            Parent parent = FXMLLoader.load(getClass().getResource("/teacher_portal/ui/main/main.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Teacher Portal");
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
    }

    @FXML
    private void handleLoginButtonAction(ActionEvent event) {
        String uname = username.getText();
        String pword = password.getText();
        
        user = uname;
        if (DaoTeacher.validate(uname, pword)) {
            closeStage();
            loadMain();
            LOGGER.log(Level.INFO, "User successfully logged in {}", uname);
        } else {
            username.getStyleClass().add("wrong-credentials");
            password.getStyleClass().add("wrong-credentials");
        }
    }

    @FXML
    private void handleCancelAction(ActionEvent event) throws IOException {
        System.exit(0);
    }

}
