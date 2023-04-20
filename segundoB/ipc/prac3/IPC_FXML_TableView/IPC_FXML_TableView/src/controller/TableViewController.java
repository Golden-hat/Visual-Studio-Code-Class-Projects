/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Persona;

/**
 * FXML Controller class
 *
 * @author jsoler
 */
public class TableViewController implements Initializable {

    private ObservableList<Persona> myObservableList = null; // Colecci�n vinculada a la vista.

    @FXML
    private Button addButton;
    @FXML
    private TableView<?> personTableView;
    @FXML
    private TableColumn<?, ?> firstNameColumn;
    @FXML
    private TableColumn<?, ?> lastNameColumn;
    @FXML
    private Button modifyButton;
    @FXML
    private Button deleteButton;

    private void initializeModel() {
        ArrayList<Persona> personData = new ArrayList<Persona>();
        personData.add(new Persona("Jordan", "Belfort"));
        personData.add(new Persona("Gregor", "MacGregor"));
        myObservableList = FXCollections.observableList(personData);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initializeModel();
       
    }



}
