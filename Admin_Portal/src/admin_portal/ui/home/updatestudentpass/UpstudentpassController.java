/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin_portal.ui.home.updatestudentpass;

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
public class UpstudentpassController implements Initializable {

    @FXML
    private JFXTextField id;
    @FXML
    private JFXTextField newpass;
    @FXML
    private JFXTextField newrepass;
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
    private void handleupdate(ActionEvent event) {
        String userid = id.getText();
        String pass = newpass.getText();
        String repass = newpass.getText();
        if(!pass.equals(repass)){
            infolabel.setText("Password Not Match");
        }else if(userid.equals("")){
            infolabel.setText("Userid Can't be Empty");
        }else{
            if(DaoStudent.checkData(userid)){
                int check = DaoStudent.update(userid, pass);
                if(check==1){
                    infolabel.setText("Updated Successfull");
                }else{
                    infolabel.setText("Error Occurred while Updating");
                }
            }
        }
    }
    
}
