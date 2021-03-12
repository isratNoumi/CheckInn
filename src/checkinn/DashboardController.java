/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkinn;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


public class DashboardController implements Initializable {

    @FXML
    private Label date;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        time();
    }    
    
    public void time()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yy   hh:mm");  
        LocalDateTime now = LocalDateTime.now();  
        date.setText(dtf.format(now)); 
    }
    
    
}
