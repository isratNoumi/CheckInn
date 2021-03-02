/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkinn;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


import javafx.fxml.Initializable;



public class SingUpController implements Initializable{

    @FXML
    ImageView image;
    int count;
    
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        slideshow();
    }    
    
}
