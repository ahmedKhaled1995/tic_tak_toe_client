/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import utility.*;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
public class HomeController implements Initializable {

    @FXML
    private StackPane homeBodySP;
    @FXML
    private ImageView backgroundImg;
    @FXML
    private BorderPane homeBodyBP;
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
    private Button logoutBtn;
    @FXML
    private Button historyBtn;
    @FXML
    private Button exitBtn;
    @FXML
    private AnchorPane centerAP;
    @FXML
    private Button singlePlayerBtn;
    @FXML
    private Button multiplayerBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleSinglePlayerBtnAction(ActionEvent event) {
        SwitchSceneTo.singlePlayerScene(event);
    }

    @FXML
    private void handleMultiplayerBtnAction(ActionEvent event) {
        SwitchSceneTo.multiplayerScene(event);
    }

    //Will be used in multiple scenese, need to find a way to do some clean coding
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
    private void handleLogoutBtnAction(ActionEvent event) {
        System.out.println("Logout Button Working");
    }

    @FXML
    private void handleHistoryBtnAction(ActionEvent event) {
        SwitchSceneTo.historyScene(event);
    }

    @FXML
    private void handleExitBtnAction(ActionEvent event) {
        if(exitApplication() == true){
            SwitchSceneTo.getStage(event).close();
        }
    }

    private boolean exitApplication() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("System Message");
        alert.setHeaderText("Are you sure that you want to exit?");

        ButtonType yes = new ButtonType("Yes");
        ButtonType no = new ButtonType("No");

        alert.getButtonTypes().setAll(yes, no);

        Boolean exit = null;

        Optional<ButtonType> playerChoice = alert.showAndWait();
        if (playerChoice.get() == yes) {
            // ... user chose "yes"
            exit = true;
        } else if (playerChoice.get() == no) {
            // ... user chose "No"
            exit = false;
        }

        return exit;
    }
}
