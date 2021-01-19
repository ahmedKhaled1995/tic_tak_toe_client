/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author LENOVO
 */
public class SwitchSceneTo {

    //List of game views
    private static final ArrayList<String> viewsList = new ArrayList<String>() {
        {
            add("home");                      // viewIndex 0 -> home.fxml
            add("singleplayer");              // viewIndex 1 -> singleplayer.fxml
            add("multiplayer");               // viewIndex 2 -> multiplayer.fxml
            add("history");                   // viewIndex 3 -> history.fxml
            add("gameboard");                 // viewIndex 4 -> gameboard.fxml
        }
    };

    public static void showScene(Event event, int viewIndex) {
        try {
            Parent newView = FXMLLoader.load(SwitchSceneTo.class.getResource("../views/" + viewsList.get(viewIndex) + ".fxml"));
            Stage newStage = new Stage();
            newStage.setScene(new Scene(newView));
            newStage.setResizable(false);
            newStage.show();
        } catch (NullPointerException ex) {
            Logger.getLogger(SwitchSceneTo.class.getName()).log(Level.SEVERE, null, ex);

            String errorMessage = "Error: " + viewsList.get(viewIndex) + ".fxml was not found. Reinstalling the application may fix the problem";
            System.out.println(errorMessage);
            showErrorDiag(errorMessage);
        } catch (IOException ex) {
            Logger.getLogger(SwitchSceneTo.class.getName()).log(Level.SEVERE, null, ex);

            String errorMessage = "Error: " + viewsList.get(viewIndex) + ".fxml is either damaged or corrupted. Reinstalling the application may fix the problem";
            System.out.println(errorMessage);
            showErrorDiag(errorMessage);
        } finally {
            closeCurrentStage(event);
        }
    }

    public static void homeScene(Event event) {
        showScene(event, 0);
    }

    public static void singlePlayerScene(Event event) {
        showScene(event, 1);
    }

    public static void multiplayerScene(Event event) {
        showScene(event, 2);
    }

    public static void historyScene(Event event) {
        showScene(event, 3);
    }

    public static void gameBoardScene(Event event) {
        showScene(event, 4);
    }

    public static void closeCurrentStage(Event event) {
        getStage(event).close();
    }

    public static Stage getStage(Event event) {
        return (Stage) ((Node) event.getSource()).getScene().getWindow();
    }

    private static void showErrorDiag(String errorMessage) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("System Error");
        errorAlert.setHeaderText("");
        errorAlert.setContentText(errorMessage);
        errorAlert.showAndWait();
    }
}
