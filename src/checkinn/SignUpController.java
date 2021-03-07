/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkinn;

import java.awt.Desktop;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.util.Duration;
import org.jpedal.PdfDecoder;
import org.jpedal.exception.PdfException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SignUpController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      // slideshow();
    }  
    @FXML
    ImageView image;
    int count;
    
    //function for image slide show  
    public void slideshow() {
        ArrayList<Image> images = new ArrayList<>();
        images.add(new Image( "/S2.jpg"));
        images.add(new Image( "/S3.jpg" ));
        images.add(new Image( "/S4.jpg" ));
        images.add(new Image( "/S5.jpg" ));
        images.add(new Image( "/S6.jpg" ));
        images.add(new Image( "/S7.jpg" ));
        
        
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5),event ->{
            image.setImage(images.get(count));
            count++;
            if(count == 7)
                count= 0;
        }));
        
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    
    @FXML
    void openPDF(ActionEvent event) {
        try{
            Desktop.getDesktop().open(new File("D:\\Cse\\2.1\\Spring-20\\zLAB\\SD\\CheckInn\\src\\checkinn\\Terms & Condition.pdf"));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    @FXML
    void openLogin(ActionEvent event) {
        System.out.println("Log In page");
    }
    
     @FXML
    void singUpAction(ActionEvent event) {
         System.out.println("Successful");
    }
}
