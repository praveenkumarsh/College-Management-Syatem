/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_portal.ui.timetable;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import student_portal.database_connection.DB;
import student_portal.database_connection.DaoStudent;
import student_portal.ui.alert.alertpane;

/**
 * FXML Controller class
 *
 * @author Praveen
 */
public class TimetableController implements Initializable {

    @FXML
    private TableColumn<String, Tmtble> eight;
    @FXML
    private TableColumn<String, Tmtble> nine;
    @FXML
    private TableColumn<String, Tmtble> ten;
    @FXML
    private TableColumn<String, Tmtble> eleven;
    @FXML
    private TableColumn<String, Tmtble> twelve;
    @FXML
    private TableColumn<String, Tmtble> thirteen;
    @FXML
    private TableColumn<String, Tmtble> forteen;
    @FXML
    private TableView<Tmtble> tview;
    
    public static ArrayList<String> sublist8to14 = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        ObservableList<Tmtble> ttable = FXCollections.observableArrayList();
        String usr = student_portal.database_connection.retrieveSingleDetails.userid;
        int clas = student_portal.database_connection.retrieveSingleDetails.year;
        if (clas == 0) {

        } else {
            System.out.println("class " + clas);
            eight.setCellValueFactory(new PropertyValueFactory<String, Tmtble>("egt"));
            nine.setCellValueFactory(new PropertyValueFactory<String, Tmtble>("nne"));
            ten.setCellValueFactory(new PropertyValueFactory<String, Tmtble>("tn"));
            eleven.setCellValueFactory(new PropertyValueFactory<String, Tmtble>("elvn"));
            twelve.setCellValueFactory(new PropertyValueFactory<String, Tmtble>("twlve"));
            thirteen.setCellValueFactory(new PropertyValueFactory<String, Tmtble>("thrten"));
            forteen.setCellValueFactory(new PropertyValueFactory<String, Tmtble>("frtn"));
            tview.setItems(getTimeTable(clas));
        }
    }

    private ObservableList<Tmtble> getTimeTable(int clas) {
        ObservableList<Tmtble> ttable = FXCollections.observableArrayList();
        sublist8to14.clear();
        if (clas == 0) {
            System.out.println("class can't be blank");
        } else {
            System.out.println("Executing Script");
            int id = clas;
//            if (DaoStudent.checkData2(id)) {
                try {
                    int status = 0;
                    System.out.println("Connecting to database");
                    Connection con = DB.getConnection();
                    PreparedStatement ps = con.prepareStatement("select * from timetable where clas=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    System.out.println("Connected");
                    ps.setInt(1, id);
                    ResultSet rs = ps.executeQuery();
                    rs.beforeFirst();
                    rs.next();
                    String eight1 = rs.getString(2);
                    String nine1 = rs.getString(3);
                    String ten1 = rs.getString(4);
                    String eleven1 = rs.getString(5);
                    String twelve1 = rs.getString(6);
                    String thirteen1 = rs.getString(7);
                    String forteen1 = rs.getString(8);
                    sublist8to14.add(eight1);
                    sublist8to14.add(nine1);
                    sublist8to14.add(ten1);
                    sublist8to14.add(twelve1);
                    sublist8to14.add(thirteen1);
                    sublist8to14.add(forteen1);
                    ttable.add(new Tmtble(eight1, nine1, ten1, eleven1, twelve1, thirteen1, forteen1));
                    con.close();
                } catch (SQLException ex) {
                    System.out.println("Exception Caught");
                }
//            } else {
//                System.out.println("Error: Record Not Found");
//            }
        }
        
        return ttable;
    }

    public static class Tmtble {

        private String egt = null;
        private String nne = null;
        private String tn = null;
        private String elvn = null;
        private String twlve = null;
        private String thrten = null;
        private String frtn = null;

        public Tmtble() {
        }

        public Tmtble(String egt, String nne, String tn, String elvn, String twlve, String thrten, String frtn) {
            System.out.println("in constructor");
            this.egt = egt;
            this.nne = nne;
            this.tn = tn;
            this.elvn = elvn;
            this.twlve = twlve;
            this.thrten = thrten;
            this.frtn = frtn;
        }

        public String getEgt() {
            return egt;
        }

        public String getNne() {
            return nne;
        }

        public String getTn() {
            return tn;
        }

        public String getElvn() {
            return elvn;
        }

        public String getTwlve() {
            return twlve;
        }

        public String getThrten() {
            return thrten;
        }

        public String getFrtn() {
            return frtn;
        }

    }

}
