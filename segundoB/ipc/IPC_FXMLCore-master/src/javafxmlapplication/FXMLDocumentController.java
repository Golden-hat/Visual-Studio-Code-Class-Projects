/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmlapplication;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author jsoler
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private TextField userName;
    @FXML
    private Text userMessage;
    @FXML
    private Button loginClicked;
    
    //=========================================================
    // you must initialize here all related with the object 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    public void loginClicked(ActionEvent event) {
        userMessage.setText("Welcome " + userName.getText());
    }
    
}
