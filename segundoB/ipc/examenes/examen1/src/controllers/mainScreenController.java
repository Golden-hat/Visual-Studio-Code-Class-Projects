package controllers;

import java.beans.EventHandler;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class mainScreenController implements Initializable {
    
    @FXML
    private TextField addField;

    @FXML
    private Button addButton;

    @FXML
    private Button DownButton;

    @FXML
    private Button UpButton;

    @FXML
    private ListView<String> list;

    public List<String> WordData = new ArrayList<>();
    public ObservableList<String> arrayListWords = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addButton.disableProperty().bind(
            Bindings.isEmpty(addField.textProperty())
        );

        UpButton.disableProperty().bind(
            Bindings.greaterThan(1, list.getSelectionModel().selectedIndexProperty())
        );

        if(list.getSelectionModel().getSelectedIndex() == WordData.size()-1){
            DownButton.setDisable(true);
        }
        else{DownButton.setDisable(false);}
    }

    @FXML
    void onAbout(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Información del alumno");
        alert.setHeaderText("YASSIN PELLICER LAMLA");
        alert.setContentText("Yassin Juan Pellicer Lamla, 2E1, DNI: 20860758B");
        alert.showAndWait();
    }

    @FXML
    void onAddField(ActionEvent event) {
        if(!addField.getText().equals("")){
            WordData.add(addField.getText());
            arrayListWords = FXCollections.observableArrayList(WordData);
            list.setItems(arrayListWords);
            addField.setText("");
        }
        if(list.getSelectionModel().getSelectedIndex() == WordData.size()-1){
            DownButton.setDisable(true);
        }
        else{DownButton.setDisable(false);}
    }

    @FXML
    void onClear(ActionEvent event) {
        WordData.clear();
        arrayListWords.clear();
        initialize(null, null);
    }

    @FXML
    void onClickList(MouseEvent event) {
        if(list.getSelectionModel().getSelectedIndex() == WordData.size()-1){
            DownButton.setDisable(true);
        }
        else{DownButton.setDisable(false);}
    }

    @FXML
    void onDown(ActionEvent event) {
        Collections.swap(arrayListWords, list.getSelectionModel().getSelectedIndex(), list.getSelectionModel().getSelectedIndex()+1);
        list.getSelectionModel().select(list.getSelectionModel().getSelectedIndex()+1);
        if(list.getSelectionModel().getSelectedIndex() == WordData.size()-1){
            DownButton.setDisable(true);
        }
        else{DownButton.setDisable(false);}
    }

    @FXML
    void onUp(ActionEvent event) {
        Collections.swap(arrayListWords, list.getSelectionModel().getSelectedIndex(), list.getSelectionModel().getSelectedIndex()-1);
        list.getSelectionModel().select(list.getSelectionModel().getSelectedIndex()-1);
    }

    @FXML
    void onClickField(ActionEvent event) {
        addField.setOnAction((event) -> {
            
        });
    }
}
