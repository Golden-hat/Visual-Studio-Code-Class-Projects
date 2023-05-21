/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmlapplication.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author sovacu
 */
public class MainViewController implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private MenuItem salir;
    @FXML
    private Button amazonButton;
    @FXML
    private Button bloggerButton;
    @FXML
    private Button ebayButton;
    @FXML
    private Button facebookButton;
    @FXML
    private Button googlePlusButton;
    @FXML
    private RadioMenuItem selectAmazon;
    @FXML
    private RadioMenuItem selectEbay;
    
    public boolean selectionEbay = false;
    public boolean selectionAmazon = false;
   
    @FXML
    private Text textField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void onSalir(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Salir");
        alert.setHeaderText("Vas a salir del programa.");
        alert.setContentText("¿Estás seguro de que quieres salir?");
        
        ButtonType si = new ButtonType("Sí.");
        ButtonType no = new ButtonType("No.");
        alert.getButtonTypes().setAll(si, no);
        
        Optional<ButtonType> result = alert.showAndWait();
        
        if (result.isPresent()) {
            if (result.get() == si){
                borderPane.getScene().getWindow().hide();
            }
        }
    }

    @FXML
    private void onClickAmazonButton(ActionEvent event) {
        if(!selectionAmazon){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Selección errónea.");
            alert.setHeaderText("La selección no es válida.");
            alert.setContentText("Si quieres comprar en Amazon, asegúrate de seleccionarlo en el menú 'Opciones/Comprar en...'.");

            ButtonType vale = new ButtonType("Vale.");
            alert.getButtonTypes().setAll(vale);
            
            alert.showAndWait();
        }
        else{
            WebView webView = new WebView();
            webView.getEngine().load("http://www.amazon.es");
            borderPane.setCenter(webView);
        }
    }

    @FXML
    private void onClickBloggerButton(ActionEvent event) {
        List<String> choices = new ArrayList<>();
        choices.add("Hipoteca, bancos y viviendas.");
        choices.add("Desvariando.");
        choices.add("Matador.");

        ChoiceDialog<String> dialog = new ChoiceDialog<>("Hipoteca, bancos y viviendas.", choices);
        dialog.setTitle("Selección de blog");
        dialog.setHeaderText("Selecciona el blog que deseas visitar.");
        
        Optional<String> result = dialog.showAndWait();

        WebView webView = new WebView();
        if(result.isPresent()){
            if(result.get().equals("Hipoteca, bancos y viviendas.")){
                webView.getEngine().load("http://www.reddit.com/r/SpainEconomics/");
            }
            else if(result.get().equals("Desvariando.")){
                webView.getEngine().load("http://www.reddit.com/r/Math/");
            }
            else if(result.get().equals("Matador.")){
                webView.getEngine().load("http://www.reddit.com/r/Destiny2/");
            }
            textField.setText("Navegando en... "+result.get());
        }
        borderPane.setCenter(webView);
    }

    @FXML
    private void onClickEbayButton(ActionEvent event) {
        if(!selectionEbay){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Selección errónea.");
            alert.setHeaderText("La selección no es válida.");
            alert.setContentText("Si quieres comprar en Ebay, asegúrate de seleccionarlo en el menú 'Opciones/Comprar en...'.");

            ButtonType vale = new ButtonType("Vale.");
            alert.getButtonTypes().setAll(vale);
            
            alert.showAndWait();
        }
        else{
            WebView webView = new WebView();
            webView.getEngine().load("http://www.ebay.es");
            borderPane.setCenter(webView);
        }
    }

    @FXML
    private void onClickFacebookButton(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog("Usuario Anónimo.");
        dialog.setHeaderText("Selecciona tu nombre de usuario.");
        dialog.setContentText("Introduce tu nombre:");
        
        Optional<String> result = dialog.showAndWait();
        
        if (result.isPresent() && !dialog.equals("")){
            textField.setText("Has entrado en Facebook bajo el usuario de "+ result.get());
        }
        
        WebView webView = new WebView();
        webView.getEngine().load("http://www.facebook.es");
        borderPane.setCenter(webView);
    }

    @FXML
    private void onSelectAmazon(ActionEvent event) {
        selectionAmazon = !selectionAmazon;
    }

    @FXML
    private void onSelectEbay(ActionEvent event) {
        selectionEbay = !selectionEbay;
    }

    @FXML
    private void onClickGooglePlusButton(ActionEvent event) {
        WebView webView = new WebView();
        webView.getEngine().load("http://www.google.es");
        borderPane.setCenter(webView);
    }
}
