package teacher_portal.ui.attendance;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.SimpleStringProperty;

public class Students {

    private String id;
    private String sel=null;

    public Students(String id) {
        this.id = id;
        
    }

    public String getId() {
        return id;
    }

    public String getselect() {
        return sel;
    }
    
    public void setSelect(String select){
        this.sel = select;
    }
}
