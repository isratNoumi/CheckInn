
package checkinn;

import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;


public class AdminScreenLoader {
    private Pane view;
    
    public Pane getPage(String fileName){
     
        try{
            URL fileUrl = CheckInn.class.getResource("/multiplefxmlhandling/" + fileName + ".fxml");
            if(fileUrl == null){
                throw new java.io.FileNotFoundException("FXML file can't be found");
            }
            
            view = new FXMLLoader().load(fileUrl);
        }
        
        catch(Exception e){
            System.out.println("No page " +fileName +" please check fxmlLoader");
        }
        
        return view;
    }
}
