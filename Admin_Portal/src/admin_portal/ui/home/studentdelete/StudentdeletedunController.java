/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin_portal.ui.home.studentdelete;

import admin_portal.connectstudentandinformation.connect1;
import admin_portal.database_connection.DaoStudent;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Praveen
 */
public class StudentdeletedunController implements Initializable {

    @FXML
    private JFXTextField id;
    @FXML
    private Label infolabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handledelete(ActionEvent event) {
        String userid = id.getText();
        if(DaoStudent.checkData(userid)){
            int check = connect1.delete(userid);
            if(check == 1){
                infolabel.setText("Successfully Deleted");
            }else{
                infolabel.setText("Error Occurred While Deleting");
            }
        }else{
            infolabel.setText("UserID not found");
        }
    }
    
}
