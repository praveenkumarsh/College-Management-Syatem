/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacher_portal.ui.main.toolbar;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
//import student_portal.ui.main.MainController;
//import student_portal.ui.main.Student_Portal;

/**
 * FXML Controller class
 *
 * @author Praveen
 */



public class ToolbarController implements Initializable {
//    private static AnchorPane pane;
    @FXML
    private JFXButton home;
    @FXML
    private JFXButton dashboard;
    @FXML
    private JFXButton attendance;
    @FXML
    private JFXButton notice;
    @FXML
    private JFXButton settings;

    public ToolbarController() {
//        ToolbarController.pane = student_portal.ui.main.MainController.innerpane;
    }
    

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadhomeWindow(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/teacher_portal/ui/home/home.fxml"));
        teacher_portal.ui.main.MainController.ipane.getChildren().setAll(pane);
//        Student_Portal.stag.setTitle("SignUP");
    }

    @FXML
    private void loadDashboardWindow(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/teacher_portal/ui/dashboard/dashboard.fxml"));
        teacher_portal.ui.main.MainController.ipane.getChildren().setAll(pane);
    }

    @FXML
    private void loadAttendanceWindow(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/teacher_portal/ui/attendance/attendance.fxml"));
        teacher_portal.ui.main.MainController.ipane.getChildren().setAll(pane);
    }

    @FXML
    private void loadNoticeWindow(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/teacher_portal/ui/notice/notice.fxml"));
        teacher_portal.ui.main.MainController.ipane.getChildren().setAll(pane);
    }

    private void loadTimetableWindow(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/teacher_portal/ui/timetable/timetable.fxml"));
        teacher_portal.ui.main.MainController.ipane.getChildren().setAll(pane);
    }

    @FXML
    private void loadSettingsWindow(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/teacher_portal/ui/setting/setting.fxml"));
        teacher_portal.ui.main.MainController.ipane.getChildren().setAll(pane);
    }
    
}
