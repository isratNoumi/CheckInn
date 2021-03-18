/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkinn;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class EmployeeListController implements Initializable {

    @FXML
    void addEmploy(ActionEvent event) throws IOException {
/*
        Parent pane = FXMLLoader.load(getClass().getResource("addEmployee.fxml"));
        Scene scene = new Scene(pane);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show(); */
    //    /*
        Parent pane=FXMLLoader.load(getClass().getResource("AddEmployee.fxml"));
        Scene scene = new Scene(pane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    //    */
    }

    @FXML
    void deleteEmploy(ActionEvent event) {

    }

    @FXML
    void detailEmploy(ActionEvent event) {

    }

    @FXML
    void updateEmploy(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
