/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkinn;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;



public class AdminController implements Initializable {

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            Parent pane = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
            adminMain.setCenter(pane);
        } catch (IOException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    
    @FXML
    private BorderPane adminMain;
  

    @FXML
    void checkIn(ActionEvent event) throws IOException {

        System.out.println("Hi");
        /*
        AdminScreenLoader object = new AdminScreenLoader();
        Pane view = object.getPage("Dashboard.fxml");
        adminMain.setCenter(view); */
        Parent pane = FXMLLoader.load(getClass().getResource("CheckIn.fxml"));
        adminMain.setCenter(pane);
        
    }
    
    @FXML
    void dashboard(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        adminMain.setCenter(pane);
        
    }
    
}
