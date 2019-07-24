package admin_portal.ui.main;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
//import admin_portal.ui.main.toolbar.ToolbarController;

/**
 * FXML Controller class
 *
 * @author Praveen
 */
//public static AnchorPane apane;
public class MainController implements Initializable {

    @FXML
    private AnchorPane rootpane;
    private JFXHamburger hamburger;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private AnchorPane innerpane;

    public static AnchorPane ipane;
    @FXML
    private AnchorPane leftpane;
    @FXML
    private Label welcomeuser;
    @FXML
    private ImageView logout;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String userid = admin_portal.database_connection.retrieveSingleDetails.userid;
        String fullname = admin_portal.database_connection.retrieveSingleDetails.name;
        welcomeuser.setText("Welcome : " + fullname+" ("+userid+")");
        ipane = innerpane;
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource("/admin_portal/ui/home/home.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        admin_portal.ui.main.MainController.ipane.getChildren().setAll(pane);
    }

    @FXML
    private void HandlelogoutAction(MouseEvent event) {
        loadMain();
        closeStage();
    }

    private void closeStage() {
        Stage stage = (Stage) rootpane.getScene().getWindow();
        stage.close();
    }

    void loadMain() {
        try {
            System.out.println("enter");
            Parent parent = FXMLLoader.load(getClass().getResource("/admin_portal/ui/login/LoginPortal.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Admin Portal");
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException ex) {
//            LOGGER.log(org.apache.logging.log4j.Level.ERROR, "{}", ex);
        }
    }
}
