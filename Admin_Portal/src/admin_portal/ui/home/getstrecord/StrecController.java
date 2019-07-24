/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin_portal.ui.home.getstrecord;

import admin_portal.database_connection.DB;
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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Praveen
 */
public class StrecController implements Initializable {

    @FXML
    private TableView<Strecord> tview;
    @FXML
    private TableColumn<String, Strecord> sno;
    @FXML
    private TableColumn<String, Strecord> rno;
    @FXML
    private TableColumn<String, Strecord> name1;
    @FXML
    private TableColumn<String, Strecord> fathername1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sno.setCellValueFactory(new PropertyValueFactory<>("sno"));
        rno.setCellValueFactory(new PropertyValueFactory<>("rollno"));
        name1.setCellValueFactory(new PropertyValueFactory<>("name"));
        fathername1.setCellValueFactory(new PropertyValueFactory<>("fname"));
        int year = admin_portal.ui.home.HomeController.year;
        ArrayList<Strecord> srec = null;
        try {
            srec = getrecord(year);
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(StrecController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(Strecord r: srec){
            System.out.println(r.sno+" "+r.rollno+" "+r.name+" "+r.fname);
        }
        sno.setCellValueFactory(new PropertyValueFactory<>("sno"));
        rno.setCellValueFactory(new PropertyValueFactory<>("rollno"));
        name1.setCellValueFactory(new PropertyValueFactory<>("name"));
        fathername1.setCellValueFactory(new PropertyValueFactory<>("fname"));
        load(srec);
    }

    private ArrayList<Strecord> getrecord(int year) throws SQLException {
        ArrayList<Strecord> record = new ArrayList<>();
        int serial = 1;
        Connection con = DB.getConnection();
        String query = "SELECT * FROM studentinformation WHERE stage = "+year;
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()){
            String roll = rs.getString(1);
            String name = rs.getString(2);
            String fname = rs.getString(8);
            Strecord st = new Strecord(serial, roll, name, fname);
            serial++;
            record.add(st);
        }
        statement.close();
        con.close();
        return record;
    }

    private void load(ArrayList<Strecord> srec) {
        tview.setItems(getsubwithteach(srec));
    }

    private ObservableList<Strecord> getsubwithteach(ArrayList<Strecord> srec) {
        ObservableList<Strecord> ttable = FXCollections.observableArrayList();
        int count = 0;
        for (int i = 0; i < srec.size(); i++) {
            Strecord p = srec.get(i);
//            System.out.println(p.subname+" "+p.years);
            ttable.add(p);
        }
        return ttable;
    }

    public class Strecord {

        int sno;
        String rollno;
        String name;
        String fname;

        public Strecord(int sno, String roll, String name, String fname) {
            this.sno = sno;
            this.rollno = roll;
            this.name = name;
            this.fname = fname;
        }

        public int getSno() {
            return sno;
        }

        public String getRollno() {
            return rollno;
        }

        public String getName() {
            return name;
        }

        public String getFname() {
            return fname;
        }
    }

}
