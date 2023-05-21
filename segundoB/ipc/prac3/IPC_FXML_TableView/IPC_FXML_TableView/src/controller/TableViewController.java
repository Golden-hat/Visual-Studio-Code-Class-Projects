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
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    @FXML
    private TableColumn<Persona, String> ImageColumn;

    private void initializeModel() {
        ArrayList<Persona> personData = new ArrayList<>();
        personData.add(new Persona("Jordan", "Belfort","resources/images/Lloroso.png"));
        personData.add(new Persona("Gregor", "MacGregor", "resources/images/Lloroso.png"));
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
        ImageColumn.setCellValueFactory( personaFila ->new SimpleStringProperty(personaFila.getValue().getImagenPath())); 
        ImageColumn.setCellFactory(c-> new ImagenTabCell());
        deleteButton.disableProperty().bind(personTableView.getSelectionModel().selectedIndexProperty().isEqualTo(-1));
        modifyButton.disableProperty().bind(personTableView.getSelectionModel().selectedIndexProperty().isEqualTo(-1));
    }
    
    @FXML
    private void deleteAction(ActionEvent event){
        myObservableList.remove(personTableView.getSelectionModel().getSelectedIndex());
        personTableView.getSelectionModel().clearSelection();
    }

    @FXML
    private void addAction(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PersonView_wCombo.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 500,300);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Demo view");
            stage.initModality(Modality.APPLICATION_MODAL);
            PersonViewController_wCombo controller = loader.getController();
            
            stage.showAndWait();

            if(controller.isAccepted()){
                Persona personModified = controller.getPerson();
                myObservableList.add(personModified);
            }
        }catch(Exception e){}
    }

    @FXML
    private void modifyActionButt(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PersonView_wCombo.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 500,300);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Demo view");
            stage.initModality(Modality.APPLICATION_MODAL);
            
            PersonViewController_wCombo controller = loader.getController();
            controller.initPerson(personTableView.getSelectionModel().getSelectedItem());

            stage.showAndWait();

            if(controller.isAccepted()){
                Persona personModified = controller.getPerson();
                myObservableList.set(personTableView.getSelectionModel().getSelectedIndex(),personModified);
            }
        }catch(Exception e){}
    }

    class ImagenTabCell extends TableCell<Persona, String> {
        private ImageView view = new ImageView();
        private Image imagen;
        
        @Override
        protected void updateItem(String t, boolean bln) {
            super.updateItem(t, bln);
            if (t == null || bln) {
                setText(null);
                setGraphic(null);
            } else {
                imagen = new Image(t, 25, 25, true, true);
                view.setImage(imagen);
                setGraphic(view);
            }
        }
    }
}
