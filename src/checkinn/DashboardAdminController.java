/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkinn;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class DashboardAdminController implements Initializable {

    @FXML
    private Label date;
    
     @FXML
    private TableView<ModelTableDashAdmin> table;

    @FXML
    private TableColumn<ModelTableDashAdmin,String> bookID;

    @FXML
    private TableColumn<ModelTableDashAdmin,String> room;

    @FXML
    private TableColumn<ModelTableDashAdmin,String> cin;

    @FXML
    private TableColumn<ModelTableDashAdmin,String> cout;

    @FXML
    private TableColumn<ModelTableDashAdmin,String> name;

    @FXML
    private TableColumn<ModelTableDashAdmin,String> mail;

    @FXML
    private TableColumn<ModelTableDashAdmin,String> regdate;

    @FXML
    private TableColumn<ModelTableDashAdmin,String> price;

    ObservableList<ModelTableDashAdmin> oblist = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        time();
        
        Connection conn = Javaconnect.ConnectDB();
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM logindata");
            
            while(rs.next()){
                oblist.add(new ModelTableDashAdmin(rs.getString("bookingID"),rs.getString("username"),rs.getString("email_id"),rs.getString("sign_in_date"),rs.getString("roomno"),rs.getString("checkin"),rs.getString("checkout"),rs.getString("Cost")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckInAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        bookID.setCellValueFactory(new PropertyValueFactory<>("bookid"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        mail.setCellValueFactory(new PropertyValueFactory<>("email"));
        room.setCellValueFactory(new PropertyValueFactory<>("room"));
        cin.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
        cout.setCellValueFactory(new PropertyValueFactory<>("checkOut"));
        regdate.setCellValueFactory(new PropertyValueFactory<>("reg"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        table.setItems(oblist);
    }
    
        
    
    public void time()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yy   hh:mm");  
        LocalDateTime now = LocalDateTime.now();  
        date.setText(dtf.format(now)); 
    }
    
    
}
