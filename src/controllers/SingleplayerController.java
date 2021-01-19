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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class SingleplayerController implements Initializable {

    @FXML
    private BorderPane singleplayerBodyBP;
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
    private AnchorPane centerAP;
    @FXML
    private Button easyBtn;
    @FXML
    private Button mediumBtn;
    @FXML
    private Button hardBtn;
    @FXML
    private Button backBtn;
//--------------------------------------------------------------------------

    private final int gameMode = 1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Setting game mode to single player mode
        GameConfig.setGameMode(gameMode);
    }

    @FXML
    private void handleConfigImgMouseClicked(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            System.out.println("Config Button Working");
        }
    }

    @FXML
    private void handleConfigBtnAction(ActionEvent event) {
        System.out.println("Moving Config Button Working");
    }

    @FXML
    private void handleEasyBtnAction(ActionEvent event) {
        GameConfig.setGameDifficultyLevel(0);           //setting game difficulty level to easy
        SwitchSceneTo.gameBoardScene(event);
    }

    @FXML
    private void handleMediumBtnAction(ActionEvent event) {
        GameConfig.setGameDifficultyLevel(1);           //setting game difficulty level to medium
        SwitchSceneTo.gameBoardScene(event);
    }

    @FXML
    private void handleHardBtnAction(ActionEvent event) {
        GameConfig.setGameDifficultyLevel(2);           //setting game difficulty level to medium
        SwitchSceneTo.gameBoardScene(event);
    }

    @FXML
    private void handleBackBtnAction(ActionEvent event) {
        GameConfig.setGameMode(0);
        SwitchSceneTo.homeScene(event);
    }

}
