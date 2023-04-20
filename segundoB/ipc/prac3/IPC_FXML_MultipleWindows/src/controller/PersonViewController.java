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
import javafx.scene.control.TextField;
import model.Persona;

/**
 * FXML Controller class
 *
 * @author jsoler
 * Modified carferl2
 */
public class PersonViewController implements Initializable {

    @FXML    
    private TextField nameTextField;
    @FXML
    private TextField surnameTextField;
    
    private Persona person;
    private  boolean okPressed = false;
    
    @FXML
    private void acceptAction(ActionEvent event) {

    }
    
    @FXML
    private void cancelAction(ActionEvent event) {
        nameTextField.getScene().getWindow().hide();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   

    
}
