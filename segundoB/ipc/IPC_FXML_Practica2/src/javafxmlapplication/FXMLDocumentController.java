/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmlapplication;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import static javafxmlapplication.Utils.*;

/**
 *
 * @author jsoler
 */
public class FXMLDocumentController implements Initializable {
    private Label labelMessage;
    @FXML
    private Circle myBall;
    @FXML
    private GridPane myGridPane;
    private double x_ini;
    private double y_ini;
    
    //=========================================================
    // you must initialize here all related with the object 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleKeyPressed(KeyEvent event) {
        int row = GridPane.getRowIndex(myBall);
        int column = GridPane.getColumnIndex(myBall);
        if(event.getCode()==KeyCode.UP){
            GridPane.setRowIndex(myBall, Utils.rowNorm(myGridPane, row - 1));
        } else if (event.getCode()==KeyCode.DOWN){
            GridPane.setRowIndex(myBall, Utils.rowNorm(myGridPane, row + 1));
        } else if (event.getCode()==KeyCode.LEFT){
            GridPane.setColumnIndex(myBall, Utils.rowNorm(myGridPane, column - 1));
        } else if (event.getCode()==KeyCode.RIGHT){
            GridPane.setColumnIndex(myBall, Utils.rowNorm(myGridPane, column + 1));
        }
    }

    @FXML
    private void handleMousePressed(MouseEvent event) {
        double x = event.getSceneX();
        double y = event.getSceneY();
        GridPane.setConstraints(myBall, Utils.columnCalc(myGridPane, x),Utils.rowCalc(myGridPane, y));
    }

    @FXML
    private void handleMouseReleased(MouseDragEvent event) {
        myBall.setTranslateX(0);
        myBall.setTranslateY(0);
        event.consume();
    }

    @FXML
    private void handleMouseDraggedBall(MouseDragEvent event) {
        myBall.setTranslateX(event.getSceneX() - x_ini);
        myBall.setTranslateY(event.getSceneY() - y_ini);
    }

    @FXML
    private void handleMousePressedBall(MouseEvent event) {
        x_ini = event.getSceneX();
        y_ini = event.getSceneY();
    }
    
}
