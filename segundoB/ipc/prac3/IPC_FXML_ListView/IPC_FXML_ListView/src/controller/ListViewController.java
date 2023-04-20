package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import model.Persona;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ListViewController implements Initializable {
    //=========================================================
    @FXML
    private ListView<Persona> personasListView;
    @FXML
    private Button addButton;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField surnameTextField;
    @FXML
    private Button deleteButton;
    //=========================================================
    // ListView and observable data type MUST be the same.
    private ObservableList<?> myObservablePersonaList = null; // Collection linked to table.


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // at the controller initialization
        ArrayList<Persona> personData = new ArrayList<Persona>();
        personData.add(new Persona("Jordan", "Belfort"));
        personData.add(new Persona("Gregor", "McGregor"));
        
        //=======================================================
        // create the observable list using FXColletions method 
        
        //=======================================================
        //=======================================================
        // link the pesona observable list with ListView
        
        //=======================================================
        //=======================================================
        // Modify CellFactory to display the object Persona
        
        //=======================================================
        // disable buttons to start
        addButton.setDisable(true);
        // in case nothing selected, disable delete button

        // TextField focus listener
        nameTextField.focusedProperty().addListener((a, b, c) -> {
            // TODO Auto-generated method stub
            if (nameTextField.isFocused()) {
                addButton.setDisable(false);
                personasListView.getSelectionModel().select(-1);
            }
        });

        // listView focus listener
        personasListView.focusedProperty().addListener((a, b, c) -> {
            if (personasListView.isFocused()) {
                addButton.setDisable(true);
            }
        });
        
    }
    
    @FXML
    void addAction(ActionEvent event) {
        // add collection if every field is not empty and do not contain empty strings
        if ((!nameTextField.getText().isEmpty())
                && (nameTextField.getText().trim().length() != 0)
                && (!surnameTextField.getText().isEmpty())
                && (surnameTextField.getText().trim().length() != 0)) {
            //============================================
            // add to the list
            //myObservablePersonaList.add(new Persona(nameTextField.textProperty().getValue(), surnameTextField.textProperty().getValue()));
            
            //============================================
            // empty text fields after adding to the list
            nameTextField.clear();
            surnameTextField.clear();
            //change focus to inital textfield
            nameTextField.requestFocus();

        }
    }
    @FXML
    void deleteAction(ActionEvent event) {
        //================================================
        // delete from the list
        
        //================================================
    }


}
