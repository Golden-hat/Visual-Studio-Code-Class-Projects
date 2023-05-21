/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Persona;

/**
 * FXML Controller class
 *
 * @author jsole
 */
public class PersonViewController_wCombo implements Initializable {
    
    @FXML
    private ComboBox<String> imagesCombo;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField surnameTextField;
    @FXML
    private Button acceptButton;
    
    Persona localPerson;
    boolean acceptPressed;
    
    @FXML
    private Button cancelButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        localPerson = new Persona("","","resources/images/Lloroso.png");
        imagesCombo.getItems().addAll("/resources/images/Lloroso.png", "/resources/images/Pregunta.png", "/resources/images/Sonriente.png");
        imagesCombo.setCellFactory(c -> new ImagenTabCell());
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
        localPerson.setImagenPath(imagesCombo.getSelectionModel().getSelectedItem());
        nameTextField.getScene().getWindow().hide();
    }
    
    void initPerson(Persona myPerson){
        this.localPerson = myPerson;
        nameTextField.setText(localPerson.getNombre());
        surnameTextField.setText(localPerson.getApellidos());
        localPerson.setImagenPath(localPerson.getImagenPath());
    }
    
    class ImagenTabCell extends ComboBoxListCell<String> {
        private ImageView view = new ImageView();
        private Image image;

        @Override
        public void updateItem(String t, boolean empty) {
            super.updateItem(t, empty); 
            if (t == null || empty) {
                setText(null);
                setGraphic(null);
            } else {
                image = new Image(t,25,25,true,true);
                view.setImage(image);
                setGraphic(view);
                setText(null);
            }
        }
    }
    
    boolean isAccepted(){
        return acceptPressed;
    }
    
    Persona getPerson(){
        return localPerson;
    }
}
