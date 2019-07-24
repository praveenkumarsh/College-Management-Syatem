
package student_portal.ui.alert;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class alertpane {
    
    public alertpane(String infoMessage, String headerText, String title){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }
    
}
