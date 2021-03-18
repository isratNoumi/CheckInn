/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkinn;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AddEmployeeController implements Initializable {

   

    @FXML
    private TextField id;
    @FXML
    private TextField fname;
    @FXML
    private TextField lname;
    @FXML
    private TextField dof;
    @FXML
    private TextField age;
    @FXML
    private TextField contact;
    @FXML
    private TextField email;
    @FXML
    private TextField address;
    @FXML
    private TextField dept;
    @FXML
    private TextField jobtitle;
    @FXML
    private TextField salary;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
    }    

    @FXML
    private void Addrecordbtn(ActionEvent event) {
        PreparedStatement pst=null;
        try
        {
            String query="INSERT INTO `employee` (`First Name`, `Last Name`, `Department`, `Contact No`, `Employee Id`, `Job Title`, `Email`) VALUES (?,?,?,?,?,?,?)";
             Connection con=Javaconnect.ConnectDB();
             pst=con.prepareStatement(query);
             
          
            
             pst.setString(1, fname.getText() );
             pst.setString(2, lname.getText());
             pst.setString(3, dept.getText());
             pst.setString(4, contact.getText());
             pst.setString(5, id.getText());
             pst.setString(6, jobtitle.getText());
             pst.setString(7, email.getText());
                 
              
                 
                 pst.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Record Added Successfully!");
                 
        }catch(Exception e){
            
        }
    }

    @FXML
    private void clearbtn(ActionEvent event) {
        fname.setText(" ");
        lname.setText(" ");
        dept.setText(" ");
        contact.setText(" ");
        id.setText(" ");
        jobtitle.setText(" ");
        email.setText(" ");
        address.setText("");
        age.setText("");
        dof.setText("");
        
    }

    
}