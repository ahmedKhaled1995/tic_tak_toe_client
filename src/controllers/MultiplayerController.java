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
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class MultiplayerController implements Initializable {

    @FXML
    private StackPane multiplayerBodySP;
    @FXML
    private BorderPane multiplayerBodyBP;
    @FXML
    private HBox TopBarHBox;
    @FXML
    private ImageView avatar;
    @FXML
    private Label username;
    @FXML
    private Region topRegion1;
    @FXML
    private ImageView pointsImage;
    @FXML
    private TextField pointsField;
    @FXML
    private Region topRegion2;
    @FXML
    private ImageView configImg;
    @FXML
    private Button configBtn;
    @FXML
    private ImageView configMovingImg;
    @FXML
    private HBox bottomBarHBox;
    @FXML
    private Button backBtn;
    @FXML
    private Region bottomRegion;
    @FXML
    private Button inviteBtn;
    @FXML
    private AnchorPane centerAP;
    @FXML
    private TreeTableView<?> playersTableTV;
    @FXML
    private TreeTableColumn<?, ?> onlineStatusCol;
    @FXML
    private TreeTableColumn<?, ?> playerNameCol;
    @FXML
    private TreeTableColumn<?, ?> pointsCol;
//------------------------------------------------------------------------------
    private final int gameMode = 2;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Setting game mode to multiplayer mode
        GameConfig.setGameMode(gameMode);
    }    
    
    @FXML
    private void handleInviteBtnAction(ActionEvent event){
        System.out.println("Invite Button Working");
    }
    
    @FXML
    private void handleBackBtnAction(ActionEvent event){   
        GameConfig.setGameMode(0);
        SwitchSceneTo.homeScene(event);
    }
    
    @FXML
    private void handleConfigImgMouseClicked(MouseEvent mouseEvent){
        if(mouseEvent.getButton() == MouseButton.PRIMARY)
            System.out.println("Config Button Working");
    }
    
    @FXML
    private void handleConfigBtnAction(ActionEvent event){
        System.out.println("Moving Config Button Working");
    }
}
