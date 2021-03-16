/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkinn;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class LogInFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    @FXML
    private AnchorPane pane1,pane2;
    @FXML
    private TextField userName,psfld,mailfld;
    @FXML
    private PasswordField password;
     PreparedStatement pst = null;
         ResultSet rs;
   String expass;

    @FXML
    void openSingUp(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        Scene scene = new Scene(pane);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }
    public void openAdmin(ActionEvent event) throws IOException, SQLException
    {
          String usname=userName.getText();
        String pass=password.getText();
        psfld.setText(DigestUtils.sha1Hex(pass));
        String pp =psfld.getText();
        
        
        
       /* 
        if(usname.equals("")||pass.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please Fillup all the information");
        
       

    }
        else{
             String query = "SELECT * FROM `logindata` WHERE username=? or email_id=? and password=?";
             
            Connection con = Javaconnect.ConnectDB();
            pst = con.prepareStatement(query);
            pst.setString(1, usname);
            pst.setString(2,usname);
            pst.setString(3, pass);
            rs=pst.executeQuery();
        if(rs.next()){
            */
       if(usname.equals("admin") && pp.equals("3af0d5b33b833cfe3c9803fdec89765ad3fd399f")){
           
        Parent root2=FXMLLoader.load(getClass().getResource("Admin.fxml"));
        Scene scene2 = new Scene(root2);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
        }
    //    }
       
    }
    @FXML
    void passONmail(ActionEvent event) throws IOException, SQLException {

        String mail = mailfld.getText().toString();
        String query = "SELECT * FROM logindata WHERE email_id=?";
        Connection conn = Javaconnect.ConnectDB();
        
        pst = conn.prepareStatement(query);
        pst.setString(1,mail);
        rs = pst.executeQuery();
        if(rs.next())
        {
             expass = rs.getString("password");
             sendPass();
             pane2.setVisible(false);
             pane1.setVisible(true);
             
        }
        else
            JOptionPane.showMessageDialog(null,"Check Your Internet Connection.");
    }

    @FXML
    void resetpass(ActionEvent event) {

        pane1.setVisible(false);
        pane2.setVisible(true);
    }
    
      @FXML
    void backtologin(ActionEvent event) {

        pane2.setVisible(false);
        pane1.setVisible(true);
    }
    
    public void sendPass() //method to send OTP to user 
    {
        Properties props=new Properties();
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port","465");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.ssl.enable","true");
                   
                Session session = Session.getInstance(props, new Authenticator(){
                   @Override
                   protected PasswordAuthentication getPasswordAuthentication(){
                       return new PasswordAuthentication("checkinn.cse@gmail.com","checkinn123");
                  }
                });
                session.setDebug(true);
                MimeMessage message = new MimeMessage(session);
                
                try
                {
                message.setFrom("checkinn.cse21@gmail.com");
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailfld.getText()));
                message.setSubject("Old Password");
                message.setText("Your password is : " + expass);
                message.saveChanges();
                
                Transport.send(message);
                JOptionPane.showMessageDialog(null,"Check your email for password."); 
                
                }catch(Exception e)
                {  
                    JOptionPane.showMessageDialog(null,"Please check your internet connection");  
                }              
            
    }
}
