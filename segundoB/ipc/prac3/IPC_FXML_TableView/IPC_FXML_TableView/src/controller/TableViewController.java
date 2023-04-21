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
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import static javax.accessibility.AccessibleState.MODAL;
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
    private TableView<Persona> personTableView;
    @FXML
    private TableColumn<Persona, String> firstNameColumn;
    @FXML
    private TableColumn<Persona, String> lastNameColumn;
    @FXML
    private Button modifyButton;
    @FXML
    private Button deleteButton;

    private void initializeModel() {
        ArrayList<Persona> personData = new ArrayList<>();
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
        personTableView.setItems(myObservableList);
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Persona, String>("nombre"));         
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Persona, String>("apellidos"));
        deleteButton.disableProperty().bind(personTableView.getSelectionModel().selectedIndexProperty().isEqualTo(-1));
        modifyButton.disableProperty().bind(personTableView.getSelectionModel().selectedIndexProperty().isEqualTo(-1));
    }
    
    private void deleteAction(ActionEvent event){
        myObservableList.remove(personTableView.getSelectionModel().getSelectedIndex());
        personTableView.getSelectionModel().clearSelection();
    }

    @FXML
    private void modifyAction(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/PersonView.fxml"));
        Parent root = loader.load();
        PersonViewController controller = loader.getController();
        controller.initPerson(personTableView.getSelectionModel().getSelectedItem());
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Demo view");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        if(controller.isAccepted()){
            Persona personModified = controller.getPerson();
            myObservableList.set(personTableView.getSelectionModel().getSelectedIndex(),personModified);
        }
    }

    
    


}
