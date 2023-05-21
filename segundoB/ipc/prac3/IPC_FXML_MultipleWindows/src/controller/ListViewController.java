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
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Persona;

/**
 * FXML Controller class
 *
 * @author jsoler
 * Modified carferl2
 */
public class ListViewController implements Initializable {

    @FXML
    private ListView<Persona> personasListView;
    @FXML
    private Button addButton;
    @FXML
    private Button modifyButton;
    @FXML
    private Button deleteButton;
    //=========================================================

    public ObservableList<Persona> myObservablePersonaList = null; // Collection linked to table.

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // using the observable list associated with the ListView by default
        myObservablePersonaList = personasListView.getItems();
        myObservablePersonaList.add(new Persona("Jordan", "Belfort"));
        myObservablePersonaList.add(new Persona("Gregor", "McGregor"));

        //=======================================================
        //=======================================================
        // Modify CellFactory to display the object Persona
        personasListView.setCellFactory(c -> new PersonListCell());

        //=======================================================
        // in case nothing selected, disable delete button
        deleteButton.disableProperty().bind(Bindings.equal(personasListView.getSelectionModel().selectedIndexProperty(), -1));
        // in case nothing selected, disable modify button
        modifyButton.disableProperty().bind(Bindings.equal(personasListView.getSelectionModel().selectedIndexProperty(), -1));
    }


    @FXML
    private void deleteAction(ActionEvent event) {
            //============================================
        // delete list
        myObservablePersonaList.remove(personasListView.getSelectionModel().getSelectedIndex());

        //================================================
    }

    @FXML
    private void modifyAction(ActionEvent event) throws IOException {
        try{
            FXMLLoader miCargador = new FXMLLoader(getClass().getResource("/view/PersonView.fxml"));
            Parent root = miCargador.load();
            Scene scene = new Scene(root,500,300);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Vista datos persona");
            stage.initModality(Modality.APPLICATION_MODAL);

            PersonViewController controladorPersona = miCargador.getController();
            Persona persona = personasListView.getSelectionModel().getSelectedItem();
            controladorPersona.initPersona(persona); // pasa los datos
            
            stage.showAndWait(); 
            
            if (controladorPersona.isOKPressed()) {
                int indice= myObservablePersonaList.indexOf(persona);
                // índice que ocupara en la lista observable
                Persona p= controladorPersona.getPersona();
                //nuevo valor en el formulario emergente
                myObservablePersonaList.set(indice, p); // actualiza la persona.
            }

        }catch(Exception e){}
    }

    @FXML
    private void addAction(ActionEvent event){
        try{
            FXMLLoader miCargador = new FXMLLoader(getClass().getResource("/view/PersonView.fxml"));
            Parent root = miCargador.load();
            Scene scene = new Scene(root,500,300);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Añadir persona");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
            
            PersonViewController controladorPersona = miCargador.getController();
            Persona p = controladorPersona.getPersona();
            
            myObservablePersonaList.add(p);
        }catch(Exception e){}
    }

    class PersonListCell extends ListCell<Persona> {

        @Override
        protected void updateItem(Persona item, boolean empty) {
            super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
            if (empty) // item is empty
            {
                setText("");
            } else {
                setText(item.getApellidos() + ", " + item.getNombre());
            }
        }
    }

}