
package admin_portal.ui.home;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class HomeController implements Initializable {

    @FXML
    private AnchorPane home_pane;
    @FXML
    private JFXTextField enteryr;
    @FXML
    private AnchorPane innerpane;
    
    public static int year = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String userid = admin_portal.database_connection.retrieveSingleDetails.userid;
        String name = admin_portal.database_connection.retrieveSingleDetails.name;
    }    

    @FXML
    private void handleteacherupdateloginpasswrd(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/admin_portal/ui/home/updateteacherpass/upteachpass.fxml"));
        innerpane.getChildren().setAll(pane);
    }

    @FXML
    private void handlestudentupdateloginpasswrd(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/admin_portal/ui/home/updatestudentpass/upstudentpass.fxml"));
        innerpane.getChildren().setAll(pane);
    }

    @FXML
    private void handlechangeteacherfromrecord(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/admin_portal/ui/home/updatenewteacherrecord/upnewteachrec.fxml"));
        innerpane.getChildren().setAll(pane);
    }

    @FXML
    private void handledeletestudent(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/admin_portal/ui/home/studentdelete/studentdeletefun.fxml"));
        innerpane.getChildren().setAll(pane);
    }

    @FXML
    private void handlegetstudentdetailbyyear(ActionEvent event) throws IOException {
        year = Integer.parseInt(enteryr.getText());
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/admin_portal/ui/home/getstrecord/strec.fxml"));
        innerpane.getChildren().setAll(pane);
    }
    
}
