/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin_portal.ui.home.updatenewteacherrecord;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.logging.log4j.Level;

/**
 * FXML Controller class
 *
 * @author Praveen
 */
public class UpnewteacherrecController implements Initializable {

    @FXML
    private JFXTextField id;
    @FXML
    private Label infolabel;

    public static String userid = "";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleupdate(ActionEvent event) {
        userid = id.getText();
        loadnewtab();
        
    }
    
    void loadnewtab() {
        try {
            System.out.println("enter");
            Parent parent = FXMLLoader.load(getClass().getResource("/admin_portal/ui/home/updatenewteacherrecord/up/updateprofile.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Teacher's New Profile");
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException ex) {
        }
    }
    
}
