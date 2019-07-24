/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacher_portal.ui.attendance;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import teacher_portal.database_connection.DB;
//import teacher_portal.database_connection.DBbyDBName;
import teacher_portal.database_connection.DB;

/**
 * FXML Controller class
 *
 * @author Praveen
 */
public class AttendancepersubjectController implements Initializable {

    @FXML
    private Label upd;
    @FXML
    private TableView<Students> studentattendlist;
    @FXML
    private TableColumn<String, Students> rollno;
    @FXML
    private Label upd1;
    @FXML
    private JFXDatePicker datepick;
    @FXML
    private TableColumn<String, Students> p;
    @FXML
    private JFXButton handleupdate;
    @FXML
    private AnchorPane pane;
    @FXML
    private Label printpresent;
    @FXML
    private Label info;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rollno.setCellValueFactory(new PropertyValueFactory<>("id"));
        p.setCellValueFactory(new PropertyValueFactory<>("sel"));
        System.out.println(AttendanceController.yrforattprsub + " " + AttendanceController.nmeforarrprsub);
        String subname = AttendanceController.nmeforarrprsub;
        int yr = AttendanceController.yrforattprsub;
        upd1.setText(subname + " of " + yr + "th year Students");
        String year = "";
        switch (yr) {
            case 1:
                year = "firstyear";
                break;
            case 2:
                year = "secondyear";
                break;
            case 3:
                year = "thirdyear";
                break;
            case 4:
                year = "forthyear";
                break;
            default:
                break;
        }
        Connection con = DB.getConnection();
        ArrayList<String> stid = null;
        try {
            stid = getstudentname(con, year,subname, stid);
        } catch (SQLException ex) {
            Logger.getLogger(AttendancepersubjectController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Students> student = new ArrayList<>();
        for (int i = 0; i < stid.size(); i++) {
            student.add(new Students(stid.get(i)));
        }
        for (int i = 0; i < student.size(); i++) {
            System.out.println("studentid" + " " + student.get(i).getId());
            System.out.println("studentid" + " " + student.get(i).getselect());
        }
        stid.clear();
        load(student);
        studentattendlist.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            handlecurroeration();
        });
        studentattendlist.setRowFactory(tv -> {
            TableRow<Students> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Students rowData = row.getItem();
                    rowData.setSelect(null);
                    presentname.remove(rowData.getId());
                    printpresent.setText(presentname.toString());
                    System.out.println("Unselected");
                }
            });
            return row;
        });

    }

    ArrayList<String> presentname = new ArrayList<>();

    private void handlecurroeration() {
        Students person = studentattendlist.getSelectionModel().getSelectedItem();
        person.setSelect("present");
        Students per = studentattendlist.getSelectionModel().getSelectedItem();
        System.out.println(per.getId() + "--00--" + per.getselect());
        if (!presentname.contains(per.getId())) {
            presentname.add(per.getId());
        }
        printpresent.setText(presentname.toString());

    }

    private ArrayList<String> getstudentname(Connection con,String year, String subname, ArrayList<String> stid) throws SQLException {
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM `" + year + "`");

        ResultSetMetaData metadata = resultSet.getMetaData();
        int columnCount = metadata.getColumnCount();

        ArrayList<String> columns = new ArrayList<>();
        for (int i = 3; i <= columnCount; i++) {
            String columnName = metadata.getColumnName(i);
            columns.add(columnName);
        }
        return columns;
    }
    ObservableList<Students> res = null;

    private void load(ArrayList<Students> student) {
        res = getsubwithteach(student);
        studentattendlist.setItems(res);
    }

    private ObservableList<Students> getsubwithteach(ArrayList<Students> student) {
        ObservableList<Students> ttable = FXCollections.observableArrayList();
        int count = 0;
        for (int i = 0; i < student.size(); i++) {
            Students p = student.get(i);
            System.out.println(p.getId() + "  " + p.getId() + "--" + p.getId() + "  " + p.getselect());
            ttable.add(p);
        }
        return ttable;
    }

    @FXML
    private void handleupdateoperation(ActionEvent event) {
        ArrayList<String> uid = new ArrayList<>();
        for (Students i : res) {
            if (i.getselect() == null || i.getselect().equals(null)) {

            } else {
                uid.add(i.getId());
            }
        }
        System.out.println("uid" + " " + uid);
        int check = 0;
        try {
            check = save(AttendanceController.yrforattprsub, uid,AttendanceController.nmeforarrprsub);
        } catch (SQLException ex) {
            Logger.getLogger(AttendancepersubjectController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (check == 1) {
            System.out.println("updated");
            info.setText("Upated Successfully");
        } else {
            System.out.println("error occured while updating");
            info.setText("Error Ocurred while Updating");
        }

    }

    public static int save(int yr, ArrayList<String> uid,String subname) throws SQLException {//, String address, String city, String contact, String imgpath) {
        int status = 0;
        String year = "";
        String subn = AttendanceController.nmeforarrprsub;
        if (yr == 0) {
            
        } else if (yr == 1) {
            year = "firstyear";
        } else if (yr == 2) {
            year = "secondyear";
        } else if (yr == 3) {
            year = "thirdyear";
        } else if (yr == 4) {
            year = "forthyear";
        }
        try {
            Connection con = DB.getConnection();
            String query = "insert into "+year+" (subcode,";
//            String query1 = "insert into " + subn + "(";
            for (int i = 0; i < uid.size(); i++) {
                if (i == uid.size() - 1) {
                    query += "`" + uid.get(i) + "`";
                } else {
                    query += "`" + uid.get(i) + "`" + ",";
                }
            }
            query += ") values(?,";
            for (int i = 0; i < uid.size(); i++) {
                if (i == uid.size() - 1) {
                    query += "?";
                } else {
                    query += "?" + ",";
                }
            }
            query += ")";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, subname);
            for (int i = 0; i < uid.size(); i++) {
                ps.setInt(i + 2, 1);

            }
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

}
