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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class CheckInAdminController implements Initializable {    
    
    @FXML
    private TableView<ModelTableUser> guestTable;

    @FXML
    private TableColumn<ModelTableUser, String> name;

    @FXML
    private TableColumn<ModelTableUser, String> mail;

    @FXML
    private TableColumn<ModelTableUser, String> gndr;

    @FXML
    private TableColumn<ModelTableUser, String> Cin;

    @FXML
    private TableColumn<ModelTableUser, String> Cout;

    @FXML
    private TableColumn<ModelTableUser, String> roomNo;

    @FXML
    private TableColumn<ModelTableUser, String> price;
    
    ObservableList<ModelTableUser> oblist = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Connection conn = Javaconnect.ConnectDB();
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM logindata");
            
            while(rs.next()){
                oblist.add(new ModelTableUser(rs.getString("username"),rs.getString("email_id"),rs.getString("gender"),rs.getString("roomno"),rs.getString("checkin"),rs.getString("checkout"),rs.getString("Cost")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckInAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        mail.setCellValueFactory(new PropertyValueFactory<>("email"));
        gndr.setCellValueFactory(new PropertyValueFactory<>("gender"));
        Cin.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
        Cout.setCellValueFactory(new PropertyValueFactory<>("checkOut"));
        roomNo.setCellValueFactory(new PropertyValueFactory<>("room"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        guestTable.setItems(oblist);
    }
    
    @FXML
    void addInfo(ActionEvent event) {

        
    }

    @FXML
    void updateInfo(ActionEvent event) {

    }
}
