
package student_portal.ui.home;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class HomeController implements Initializable {

    @FXML
    private AnchorPane home_pane;
    @FXML
    private Label user;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String userid = student_portal.database_connection.retrieveSingleDetails.userid;
        String name = student_portal.database_connection.retrieveSingleDetails.retrievefullname();
        user.setText("!! Welcome "+name+" ("+userid+") !!");
    }    
    
}
