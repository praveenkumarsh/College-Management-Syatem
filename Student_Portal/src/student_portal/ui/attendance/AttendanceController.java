package student_portal.ui.attendance;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import student_portal.database_connection.DB;
import student_portal.database_connection.DaoStudent;
import student_portal.ui.alert.alertpane;

/**
 * FXML Controller class
 *
 * @author Praveen
 */
public class AttendanceController implements Initializable {

    @FXML
    private TableView<AttendancePerSub> attendancetable;
    @FXML
    private TableColumn<String, AttendancePerSub> subname;
    @FXML
    private TableColumn<String, AttendancePerSub> totallecture;
    @FXML
    private TableColumn<String, AttendancePerSub> presentlecture;
    @FXML
    private TableColumn<String, AttendancePerSub> totalpercentage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        subname.setCellValueFactory(new PropertyValueFactory<>("subname"));
        totallecture.setCellValueFactory(new PropertyValueFactory<>("totalattendance"));
        presentlecture.setCellValueFactory(new PropertyValueFactory<>("presentAttendance"));
        totalpercentage.setCellValueFactory(new PropertyValueFactory<>("presentPercentage"));
        String usrid = student_portal.database_connection.retrieveSingleDetails.userid;
        int clas = student_portal.database_connection.retrieveSingleDetails.retrieveyear();
        load(clas, usrid);
    }

    void load(int clas, String usrid) {
        if (clas == 0) {
        } else {
            System.out.println("class " + clas);
            attendancetable.setItems(getAttendancePerSubs(clas, usrid));
        }

    }

    private ObservableList<AttendancePerSub> getAttendancePerSubs(int clas, String userid) {
        ObservableList<AttendancePerSub> ttable = FXCollections.observableArrayList();
        ArrayList<String> sublist = getsublist(clas);
        for (String sub : sublist) {
            int n1 = student_portal.database_connection.QueryForAttendance.gettotal(clas, userid, sub);
            int n2 = student_portal.database_connection.QueryForAttendance.getpresent(clas, userid, sub);
            if (n1 == 0) {
                ttable.add(new AttendancePerSub(sub, n1, n2, 0));
            } else {
                float n3 = ((n2 * 100) / n1);
                ttable.add(new AttendancePerSub(sub, n1, n2, n3));
            }
        }
        return ttable;
    }

    private ArrayList<String> getsublist(int yr) {
        ArrayList<String> sblst = new ArrayList<>();
        try {

            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from timetable where clas=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            System.out.println("Connected");
            ps.setInt(1, yr);
            ResultSet rs = ps.executeQuery();
            rs.beforeFirst();
            rs.next();
            sblst.add(rs.getString(2));
            sblst.add(rs.getString(3));
            sblst.add(rs.getString(4));
            sblst.add(rs.getString(6));
            sblst.add(rs.getString(7));
            sblst.add(rs.getString(8));
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(AttendanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.err.println(sblst);
        return sblst;
    }

    public class AttendancePerSub {

        String subname = "";
        int totalattendance = 0;
        int presentAttendance = 0;
        float presentPercentage = 0;

        public AttendancePerSub(String subname, int ta, int pa, float pp) {

            this.subname = subname;
            this.totalattendance = ta;
            this.presentAttendance = pa;
            this.presentPercentage = pp;
        }

        public String getSubname() {
            return subname;
        }

        public int getTotalattendance() {
            return totalattendance;
        }

        public int getPresentAttendance() {
            return presentAttendance;
        }

        public float getPresentPercentage() {
            return presentPercentage;
        }

    }

}
