/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Persona;

/**
 * FXML Controller class
 *
 * @author jsoler
 */
public class PersonViewController implements Initializable {
    
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField surnameTextField;
    @FXML
    private Button acceptButton;
    
    Persona localPerson;
    boolean acceptPressed;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        localPerson = new Persona("","","resources/images/Lloroso.png");
    }    

    @FXML
    private void cancelOnAction(ActionEvent event) {       
        nameTextField.getScene().getWindow().hide();
    }

    @FXML
    private void acceptOnAction(ActionEvent event) {
        acceptPressed = true;
        if(localPerson == null){
            localPerson = new Persona("","","resources/images/Lloroso.png");
        }
        localPerson.setNombre(nameTextField.getText());
        localPerson.setApellidos(surnameTextField.getText());
        nameTextField.getScene().getWindow().hide();
    }

    void initPerson(Persona myPerson){
        this.localPerson = myPerson;
        nameTextField.setText(localPerson.getNombre());
        surnameTextField.setText(localPerson.getApellidos());
    }
    
    boolean isAccepted(){
        return acceptPressed;
    }
    
    Persona getPerson(){
        return localPerson;
    }
}
