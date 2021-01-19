/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import utility.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class HistoryController implements Initializable {
    
    TableView table;
    @FXML
    private StackPane historyBodySP;
    @FXML
    private ImageView backgroundImg;
    @FXML
    private BorderPane historyBodyBP;
    @FXML
    private HBox topBarHBox;
    @FXML
    private ImageView avatar;
    @FXML
    private Label username;
    @FXML
    private Region topRegion1;
    @FXML
    private ImageView pointsImg;
    @FXML
    private TextField pointsField;
    @FXML
    private Region topRegion2;
    @FXML
    private ImageView configImg;
    @FXML
    private HBox bottomBarHBox;
    @FXML
    private Button backBtn;
    @FXML
    private AnchorPane centerAP;
    @FXML
    private SplitPane horizontalSP;
    @FXML
    private AnchorPane AP1;
    @FXML
    private TableView<?> gameRecordsTV;
    @FXML
    private TableColumn<?, ?> gameNoCol;
    @FXML
    private TableColumn<?, ?> gameNameCol;
    @FXML
    private AnchorPane AP2;
    @FXML
    private Label gameName;
    @FXML
    private GridPane gameDetailsGP;
    @FXML
    private Label date;
    @FXML
    private Label gameDate;
    @FXML
    private Label opponent;
    @FXML
    private Label opponentName;
    @FXML
    private Label pointsReceived;
    @FXML
    private Label gamePointsReceived;
    @FXML
    private Label gameResult;
    @FXML
    private Button replayBtn;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void handleReplayBtnAction(ActionEvent event){
        System.out.println("Replay Button Working");
    }
    
    @FXML
    private void handleBackBtnAction(ActionEvent event){
        SwitchSceneTo.homeScene(event);
    }
    
    //Repeated need to do some clean coding
    @FXML
    private void handleConfigImgMouseClicked(MouseEvent mouseEvent){
        if(mouseEvent.getButton() == MouseButton.PRIMARY)
            System.out.println("Config Button Working");
    }
    
}
