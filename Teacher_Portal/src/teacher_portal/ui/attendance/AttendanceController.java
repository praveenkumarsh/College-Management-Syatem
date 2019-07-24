package teacher_portal.ui.attendance;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import teacher_portal.database_connection.DB;
import teacher_portal.database_connection.DB;

public class AttendanceController implements Initializable {

    @FXML
    private TableView<Pairs> sublist;
    @FXML
    private TableColumn<String, Pairs> year;
    @FXML
    private TableColumn<String, Pairs> subject;
    protected static int yrforattprsub =0;
    protected static String nmeforarrprsub = "";
    @FXML
    private Button information;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        year.setCellValueFactory(new PropertyValueFactory<>("years"));
        subject.setCellValueFactory(new PropertyValueFactory<>("subname"));
        String userid = teacher_portal.database_connection.retrieveSingleDetails.userid;
        ArrayList<Pairs> subname = new ArrayList<>();
        try {
            retrievesubwithyear(userid, subname);
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        int count = 1;
        for (int i = 0; i < subname.size(); i++) {
            Pairs p = subname.get(i);
            if ((p.subname) == null || p.subname.equals(null) || p.subname.equals("NULL")) {
                subname.remove(i);
                i--;
            }
        }
        for (int i = 0; i < subname.size(); i++) {
            Pairs p = subname.get(i);
            int yr = p.years;
            String sbname = p.subname;
            System.out.println(yr + "-->" + sbname);
        }
        load(subname);
        System.out.println("sublist set");
        sublist.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            handlecurroeration();
        });

    }

    private void retrievesubwithyear(String userid, ArrayList<Pairs> subname) throws SQLException {
        Connection con = DB.getConnection();
        Statement stm;
        stm = con.createStatement();
        String sql = "Select * From subteachbyteacher";
        ResultSet rst;
        rst = stm.executeQuery(sql);
        while (rst.next()) {
            Pairs p = new Pairs(rst.getInt("Year"), rst.getString(userid));
            subname.add(p);
        }
        con.close();
    }

    private void load(ArrayList<Pairs> subname) {
        sublist.setItems(getsubwithteach(subname));
    }

    private ObservableList<Pairs> getsubwithteach(ArrayList<Pairs> subname) {
        ObservableList<Pairs> ttable = FXCollections.observableArrayList();
        int count = 0;
        for (int i = 0; i < subname.size(); i++) {
            Pairs p = subname.get(i);
            System.out.println(p.subname+" "+p.years);
            ttable.add(p);
        }
        return ttable;
    }

    private void handlecurroeration() {
        Pairs person = sublist.getSelectionModel().getSelectedItem();
        System.out.println(person.subname+"  "+person.years);
        yrforattprsub = person.years;
        nmeforarrprsub = person.subname;
        System.out.println(yrforattprsub+"  "+nmeforarrprsub);
        loadMain();
        
    }
    
    void loadMain() {
        try {
            System.out.println("enter");
            Parent parent = FXMLLoader.load(getClass().getResource("/teacher_portal/ui/attendance/attendancepersubject.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Teacher Portal");
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException ex) {
        }
    }

    @FXML
    private void handlehintinfo(ActionEvent event) {
        try {
            System.out.println("enter");
            Parent parent = FXMLLoader.load(getClass().getResource("/teacher_portal/ui/attendance/hint.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Teacher Portal");
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException ex) {
        }
    }

    public class Pairs {

        int years;
        String subname;
        public Pairs(int year, String subname) {
            this.years = year;
            this.subname = subname;
        }

        public int getYears() {
            return years;
        }

        public String getSubname() {
            return subname;
        }

    }

}
