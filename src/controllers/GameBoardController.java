/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.BufferedReader;
import java.io.PrintWriter;
import utility.*;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class GameBoardController implements Initializable {

    //Board Outer Body
    @FXML
    private AnchorPane gameBoardBodyAP;

    //Top Bar Elements
    @FXML
    private AnchorPane topBarAP;
    @FXML
    private Label playerName;
    @FXML
    private TextField playerScoreField;
    @FXML
    private TextField opponentScoreField;
    @FXML
    private Label playerScoreLabel;
    @FXML
    private Label opponentScoreLabel;
    @FXML
    private Label opponentName;
    @FXML
    private ImageView playerSymbol;
    @FXML
    private ImageView opponentSymbol;
    @FXML
    private ImageView gameLogo;

    //Game Board Elements
    @FXML
    private GridPane gameBoardGP;
    @FXML
    private ImageView tile1;
    @FXML
    private ImageView tile2;
    @FXML
    private ImageView tile3;
    @FXML
    private ImageView tile4;
    @FXML
    private ImageView tile5;
    @FXML
    private ImageView tile6;
    @FXML
    private ImageView tile7;
    @FXML
    private ImageView tile8;
    @FXML
    private ImageView tile9;
    @FXML
    private Pane pane1;
    @FXML
    private Pane pane2;
    @FXML
    private Pane pane3;
    @FXML
    private Pane pane4;
    @FXML
    private Pane pane5;
    @FXML
    private Pane pane6;
    @FXML
    private Pane pane7;
    @FXML
    private Pane pane8;
    @FXML
    private Pane pane9;

    @FXML
    private Label result;

    @FXML
    private Button anotherRoundBtn;

    @FXML
    private Button homeBtn;
    //------------------------------------------------------------------------------

    //Dummy data
    String dummyPlayerName = "Hasaballa";
    int dummyPlayerScore = 0;

    //------------------------------------------------------------------------------
    //Game Variables
    // Every possibilities of winning
    private ArrayList<Integer> win1, win2, win3, win4, win5, win6, win7, win8;

    // Text displayed at the end of the game
    private String playerWinsMsg, computerWinsMsg;

    // Where token(X or O) has already been played and where is it now
    private static int loc;
    private Boolean place1 = true, place2 = true, place3 = true, place4 = true, place5 = true, place6 = true,
            place7 = true, place8 = true, place9 = true;

    // Stores if someone won or tied
    private Boolean win = false, tie = false;

    // Stupid computer
    private int computerId = 1;

    // Places where AI can block
    private ArrayList<Integer> block1, block2, block3, block4, block5, block6, block7, block8, block9, block10, block11,
            block12, block13, block14, block15, block16, block17, block18, block19, block20, block21, block22, block23,
            block24;
    private Boolean loop1 = true, loop2 = true, loop3 = true, loop4 = true, loop5 = true, loop6 = true, loop7 = true,
            loop8 = true, loop9 = true, loop10 = true, loop11 = true, loop12 = true, loop13 = true, loop14 = true,
            loop15 = true, loop16 = true, loop17 = true, loop18 = true, loop19 = true, loop20 = true, loop21 = true,
            loop22 = true, loop23 = true, loop24 = true, loop25 = true, loop26 = true, loop27 = true, loop28 = true,
            loop29 = true, loop30 = true, loop31 = true, loop32 = true, loop33 = true, loop34 = true, loop35 = true;

    // Sound
    private MediaPlayer winSound, lostSound, clickSound;

    private ArrayList<Integer> resultat1, resultat2;
    private int person;

    // Game IDs
    private int gameId = 1;
    private int startId;

    // Score & names
    private int player1Score, player2Score;

    // To know if user selected easy/medium/hard
    private int selection;

    // Tie score in the corner
    private int tieScore;

    public static PrintWriter out = null;
    public static BufferedReader in = null;

    //x & y images
    Image x = new Image("/resources/p1.png");
    Image o = new Image("/resources/o.png");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if (GameConfig.getGameMode() == 1) {
            System.out.println("Game Mode: Single Player Mode");

            //Initializing the game board scene
            playerName.setText(dummyPlayerName);
            opponentName.setText("Computer");

            playerScoreField.setText(Integer.toString(dummyPlayerScore));
            opponentScoreField.setText("0");

            result.setText("");

            player1Score = dummyPlayerScore;
            startId = GameConfig.getGameMode();  //1

            // Declaration of music
            winSound = new MediaPlayer(new Media(getClass().getResource("/resources/sound/win.wav").toExternalForm()));
            lostSound = new MediaPlayer(new Media(getClass().getResource("/resources/sound/fail.mp3").toExternalForm()));
            clickSound = new MediaPlayer(new Media(getClass().getResource("/resources/sound/click.wav").toExternalForm()));

            // Stores the location of the tokens
            resultat1 = new ArrayList<>();
            resultat2 = new ArrayList<>();
            
            selection = GameConfig.getGameDiffficultyLevel();
            String level;
            switch (selection){
                case 0:
                    level = "Easy";
                    break;
                case 1:
                    level = "Medium";
                    break;
                case 2:
                    level = "Hard";
                    break;
                default:
                    level = null;
                    break;
            }
            System.out.println("Game Difficulty: " + level);
        } else if (GameConfig.getGameMode() == 2) {
            System.out.println("Game Mode: Multiplayer Mode");
        } else {
            System.out.println("Error: No given mode");
        }
    }
    
    @FXML
    private void handleHomeBtn(ActionEvent event) {
        if (leaveGame() == true) {
            SwitchSceneTo.homeScene(event);
        }
    }
    
    @FXML
    private void handleAnotherRoundBtn(ActionEvent event){
        anotherRound();
    }

    @FXML
    private void injectTile1(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            loc = 1;
            startGame(event);
        }
    }

    @FXML
    private void injectTile2(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            loc = 2;
            startGame(event);
        }
    }

    @FXML
    private void injectTile3(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            loc = 3;
            startGame(event);
        }
    }

    @FXML
    private void injectTile4(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            loc = 4;
            startGame(event);
        }
    }

    @FXML
    private void injectTile5(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            loc = 5;
            startGame(event);
        }
    }

    @FXML
    private void injectTile6(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            loc = 6;
            startGame(event);
        }
    }

    @FXML
    private void injectTile7(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            loc = 7;
            startGame(event);
        }
    }

    @FXML
    private void injectTile8(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            loc = 8;
            startGame(event);
        }
    }

    @FXML
    private void injectTile9(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            loc = 9;
            startGame(event);
        }
    }

    //--------------------------------------------------------------------------
    //Single Player Functionality
    public void startGame(MouseEvent mouseEvent) {

        if (gameId <= 9) {

            // Checks who's turn is //user is odd ->O
            if (gameId % 2 == 0) {
                person = 2;             //Computer
            } else {
                person = 1;             //Player
            }

            //Computer Mode Selection
            if (startId == 1) {
                // Computer brain
                if (person == 2) {
                    switch (selection) {
                        case 0:
                            easyComputerLevel();
                            break;
                        case 1:
                            if (computerId == 2) {
                                difficultComputerLevel();
                                gameId++;
                                computerId = 1;
                            } else if (computerId == 1) {
                                easyComputerLevel();
                                computerId = 2;
                            }
                            break;
                        case 2:
                            difficultComputerLevel();
                            gameId = gameId + 1;
                            break;
                        default:
                            break;
                    }
                }
            }

            // Checks where to put the tokens
            injectTiles();

            if (gameId >= 5) {
                playerWinsMsg = playerName.getText() + " WINS!";
                computerWinsMsg = opponentName.getText() + " WINS!";

                checkWinning();
            }

            // Keeping up with how many turn there is
            gameId++;
        }

        // Checks if there's a tie
        checkTie();
    }

    public void injectTiles() {
        if (loc == 1 && place1) {
            clickSound.seek(Duration.ZERO);
            place1 = false;
            if (person == 1) {
                clickSound.play();
                tile1.setImage(x);
                resultat1.add(loc);
            } else {
                clickSound.play();
                tile1.setImage(o);
                resultat2.add(loc);
            }
        } else if (loc == 2 && place2) {
            clickSound.seek(Duration.ZERO);
            place2 = false;
            if (person == 1) {
                clickSound.play();
                tile2.setImage(x);
                resultat1.add(loc);
            } else {
                clickSound.play();
                tile2.setImage(o);
                resultat2.add(loc);
            }
        } else if (loc == 3 && place3) {
            clickSound.seek(Duration.ZERO);
            place3 = false;
            if (person == 1) {
                clickSound.play();
                tile3.setImage(x);
                resultat1.add(loc);
            } else {
                clickSound.play();
                tile3.setImage(o);
                resultat2.add(loc);
            }
        } else if (loc == 4 && place4) {
            clickSound.seek(Duration.ZERO);
            place4 = false;
            if (person == 1) {
                clickSound.play();
                tile4.setImage(x);
                resultat1.add(loc);
            } else {
                clickSound.play();
                tile4.setImage(o);
                resultat2.add(loc);
            }
        } else if (loc == 5 && place5) {
            clickSound.seek(Duration.ZERO);
            place5 = false;
            if (person == 1) {
                clickSound.play();
                tile5.setImage(x);
                resultat1.add(loc);
            } else {
                clickSound.play();
                tile5.setImage(o);
                resultat2.add(loc);
            }
        } else if (loc == 6 && place6) {
            clickSound.seek(Duration.ZERO);
            place6 = false;
            if (person == 1) {
                clickSound.play();
                tile6.setImage(x);
                resultat1.add(loc);
            } else {
                clickSound.play();
                tile6.setImage(o);
                resultat2.add(loc);
            }
        } else if (loc == 7 && place7) {
            clickSound.seek(Duration.ZERO);
            place7 = false;
            if (person == 1) {
                clickSound.play();
                tile7.setImage(o);
                resultat1.add(loc);
            } else {
                clickSound.play();
                tile7.setImage(o);
                resultat2.add(loc);
            }
        } else if (loc == 8 && place8) {
            clickSound.seek(Duration.ZERO);
            place8 = false;
            if (person == 1) {
                clickSound.play();
                tile8.setImage(x);
                resultat1.add(loc);
            } else {
                clickSound.play();
                tile8.setImage(o);
                resultat2.add(loc);
            }
        } else if (loc == 9 && place9) {
            clickSound.seek(Duration.ZERO);
            place9 = false;
            if (person == 1) {
                clickSound.play();
                tile9.setImage(x);
                resultat1.add(loc);
            } else {
                clickSound.play();
                tile9.setImage(o);
                resultat2.add(loc);
            }
        } else {
            gameId--;
        }
    }

    public void checkTie() {
        if (gameId > 9 && win != true && tie == false) {
            lostSound.play();
            tie = true;
            result.setText("TIE!");
            tieScore = tieScore + 1;

        }
    }

    public void checkWinning() {
        // Defines every possibilities of winning
        win1 = new ArrayList<>();
        win2 = new ArrayList<>();
        win3 = new ArrayList<>();
        win4 = new ArrayList<>();
        win5 = new ArrayList<>();
        win6 = new ArrayList<>();
        win7 = new ArrayList<>();
        win8 = new ArrayList<>();

        win1.add(1);
        win1.add(2);
        win1.add(3);

        win2.add(4);
        win2.add(5);
        win2.add(6);

        win3.add(7);
        win3.add(8);
        win3.add(9);

        win4.add(1);
        win4.add(4);
        win4.add(7);

        win5.add(2);
        win5.add(5);
        win5.add(8);

        win6.add(3);
        win6.add(6);
        win6.add(9);

        win7.add(1);
        win7.add(5);
        win7.add(9);

        win8.add(3);
        win8.add(5);
        win8.add(7);

        // Checks if someone wins
        if (resultat1.containsAll(win1)) {
            win = true;
            result.setText(playerWinsMsg);
            player1Score = player1Score + 1;
        } else if (resultat2.containsAll(win1)) {
            win = true;
            result.setText(computerWinsMsg);
            player2Score = player2Score + 1;
        } else if (resultat1.containsAll(win2)) {
            win = true;
            result.setText(playerWinsMsg);
            player1Score = player1Score + 1;
        } else if (resultat2.containsAll(win2)) {
            win = true;
            result.setText(computerWinsMsg);
            player2Score = player2Score + 1;
        } else if (resultat1.containsAll(win3)) {
            win = true;
            result.setText(playerWinsMsg);
            player1Score = player1Score + 1;
        } else if (resultat2.containsAll(win3)) {
            win = true;
            result.setText(computerWinsMsg);
            player2Score = player2Score + 1;
        } else if (resultat1.containsAll(win4)) {
            win = true;
            result.setText(playerWinsMsg);
            player1Score = player1Score + 1;
        } else if (resultat2.containsAll(win4)) {
            win = true;
            result.setText(computerWinsMsg);
            player2Score = player2Score + 1;
        } else if (resultat1.containsAll(win5)) {
            win = true;
            result.setText(playerWinsMsg);
            player1Score = player1Score + 1;
        } else if (resultat2.containsAll(win5)) {
            win = true;
            result.setText(computerWinsMsg);
            player2Score = player2Score + 1;
        } else if (resultat1.containsAll(win6)) {
            win = true;
            result.setText(playerWinsMsg);
            player1Score = player1Score + 1;
        } else if (resultat2.containsAll(win6)) {
            win = true;
            result.setText(computerWinsMsg);
            player2Score = player2Score + 1;
        } else if (resultat1.containsAll(win7)) {
            win = true;
            result.setText(playerWinsMsg);
            player1Score = player1Score + 1;
        } else if (resultat2.containsAll(win7)) {
            win = true;
            result.setText(computerWinsMsg);
            player2Score = player2Score + 1;
        } else if (resultat1.containsAll(win8)) {
            win = true;
            result.setText(playerWinsMsg);
            player1Score = player1Score + 1;
        } else if (resultat2.containsAll(win8)) {
            win = true;
            player2Score = player2Score + 1;
            result.setText(computerWinsMsg);
        }

        // Plays sound when someone wins
        if (win) {
            gameId = 10;
            if (startId == 1 || startId == 3) {
                if (result.getText().equals(computerWinsMsg)) {
                    lostSound.play();
                    opponentScoreField.setText(Integer.toString(player2Score));
                } else {
                    winSound.play();
                    playerScoreField.setText(Integer.toString(player1Score));
                }
            } else {
                winSound.play();
            }
        }
    }

    public void anotherRound() {

        gameId = 1;
        win = false;
        tie = false;
        resultat1.clear();
        resultat2.clear();
        place1 = true;
        place2 = true;
        place3 = true;
        place4 = true;
        place5 = true;
        place6 = true;
        place7 = true;
        place8 = true;
        place9 = true;
        loop1 = true;
        loop2 = true;
        loop3 = true;
        loop4 = true;
        loop5 = true;
        loop6 = true;
        loop7 = true;
        loop8 = true;
        loop9 = true;
        loop10 = true;
        loop11 = true;
        loop12 = true;
        loop13 = true;
        loop14 = true;
        loop15 = true;
        loop16 = true;
        loop17 = true;
        loop18 = true;
        loop19 = true;
        loop20 = true;
        loop21 = true;
        loop22 = true;
        loop23 = true;
        loop24 = true;
        loop25 = true;
        loop26 = true;
        loop27 = true;
        loop28 = true;
        loop29 = true;
        loop30 = true;
        loop31 = true;
        loop32 = true;
        loop33 = true;
        loop34 = true;
        loop35 = true;
        loc = 0;
        result.setText("");
        clearTiles();
        winSound.stop();
        lostSound.stop();
    }

    public void easyComputerLevel() {
        if (person == 2) {
            int rand = 1 + (int) (Math.random() * ((9 - 1) + 1));
            while (resultat1.contains(rand) || resultat2.contains(rand)) {
                rand = 1 + (int) (Math.random() * ((9 - 1) + 1));
            }
            loc = rand;
            resultat2.add(rand);
        }
    }

    public void difficultComputerLevel() {
        block1 = new ArrayList<>();
        block2 = new ArrayList<>();
        block3 = new ArrayList<>();
        block4 = new ArrayList<>();
        block5 = new ArrayList<>();
        block6 = new ArrayList<>();
        block7 = new ArrayList<>();
        block8 = new ArrayList<>();
        block9 = new ArrayList<>();
        block10 = new ArrayList<>();
        block11 = new ArrayList<>();
        block12 = new ArrayList<>();
        block13 = new ArrayList<>();
        block14 = new ArrayList<>();
        block15 = new ArrayList<>();
        block16 = new ArrayList<>();
        block17 = new ArrayList<>();
        block18 = new ArrayList<>();
        block19 = new ArrayList<>();
        block20 = new ArrayList<>();
        block21 = new ArrayList<>();
        block22 = new ArrayList<>();
        block23 = new ArrayList<>();
        block24 = new ArrayList<>();

        block1.add(1);
        block1.add(2);

        block2.add(4);
        block2.add(5);

        block3.add(7);
        block3.add(8);

        block4.add(2);
        block4.add(3);

        block5.add(5);
        block5.add(6);

        block6.add(8);
        block6.add(9);

        block7.add(7);
        block7.add(4);

        block8.add(8);
        block8.add(5);

        block9.add(9);
        block9.add(6);

        block10.add(1);
        block10.add(4);

        block11.add(2);
        block11.add(5);

        block12.add(3);
        block12.add(6);

        block13.add(5);
        block13.add(9);

        block14.add(1);
        block14.add(5);

        block15.add(7);
        block15.add(5);

        block16.add(5);
        block16.add(3);

        block17.add(1);
        block17.add(7);

        block18.add(2);
        block18.add(8);

        block19.add(3);
        block19.add(9);

        block20.add(1);
        block20.add(3);

        block21.add(4);
        block21.add(6);

        block22.add(7);
        block22.add(9);

        block23.add(1);
        block23.add(9);

        block24.add(7);
        block24.add(3);

        // Puts computer token
        if (resultat1.isEmpty() == false) {
            if (resultat2.containsAll(block1) && loop1 && place3) {
                loop1 = false;
                place3 = false;
                resultat2.add(3);
                tile3.setImage(o);
            } else if (resultat2.containsAll(block2) && loop2 && place6) {
                loop2 = false;
                place6 = false;
                resultat2.add(6);
                tile6.setImage(o);
            } else if (resultat2.containsAll(block3) && loop3 && place9) {
                loop3 = false;
                place9 = false;
                resultat2.add(9);
                tile9.setImage(o);
            } else if (resultat2.containsAll(block4) && loop4 && place1) {
                loop4 = false;
                place1 = false;
                resultat2.add(1);
                tile1.setImage(o);
            } else if (resultat2.containsAll(block5) && loop5 && place4) {
                loop5 = false;
                place4 = false;
                resultat2.add(4);
                tile4.setImage(o);
            } else if (resultat2.containsAll(block6) && loop6 && place7) {
                loop6 = false;
                place7 = false;
                resultat2.add(7);
                tile7.setImage(o);
            } else if (resultat2.containsAll(block7) && loop7 && place1) {
                loop7 = false;
                place1 = false;
                resultat2.add(1);
                tile1.setImage(o);
            } else if (resultat2.containsAll(block8) && loop8 && place2) {
                loop8 = false;
                place2 = false;
                resultat2.add(2);
                tile2.setImage(o);
            } else if (resultat2.containsAll(block9) && loop9 && place3) {
                loop9 = false;
                place3 = false;
                resultat2.add(3);
                tile3.setImage(o);
            } else if (resultat2.containsAll(block10) && loop10 && place7) {
                loop10 = false;
                place7 = false;
                resultat2.add(7);
                tile7.setImage(o);
            } else if (resultat2.containsAll(block11) && loop11 && place8) {
                loop11 = false;
                place8 = false;
                resultat2.add(8);
                tile8.setImage(o);
            } else if (resultat2.containsAll(block12) && loop12 && place9) {
                loop12 = false;
                place9 = false;
                resultat2.add(9);
                tile9.setImage(o);
            } else if (resultat2.containsAll(block13) && loop13 && place1) {
                loop13 = false;
                place1 = false;
                resultat2.add(1);
                tile1.setImage(o);
            } else if (resultat2.containsAll(block14) && loop14 && place9) {
                loop14 = false;
                place9 = false;
                resultat2.add(9);
                tile9.setImage(o);
            } else if (resultat2.containsAll(block15) && loop15 && place3) {
                loop15 = false;
                place3 = false;
                resultat2.add(3);
                tile3.setImage(o);
            } else if (resultat2.containsAll(block16) && loop16 && place7) {
                loop16 = false;
                place7 = false;
                resultat2.add(7);
                tile7.setImage(o);
            } else if (resultat2.containsAll(block17) && loop22 && place4) {
                loop22 = false;
                place4 = false;
                resultat2.add(4);
                tile4.setImage(o);
            } else if (resultat2.containsAll(block18) && loop23 && place5) {
                loop23 = false;
                place5 = false;
                resultat2.add(5);
                tile5.setImage(o);
            } else if (resultat2.containsAll(block19) && loop24 && place6) {
                loop24 = false;
                place6 = false;
                resultat2.add(6);
                tile6.setImage(o);
            } else if (resultat2.containsAll(block20) && loop25 && place2) {
                loop25 = false;
                place2 = false;
                resultat2.add(2);
                tile2.setImage(o);
            } else if (resultat2.containsAll(block21) && loop26 && place5) {
                loop26 = false;
                place5 = false;
                resultat2.add(5);
                tile5.setImage(o);
            } else if (resultat2.containsAll(block22) && loop27 && place8) {
                loop27 = false;
                place8 = false;
                resultat2.add(8);
                tile8.setImage(o);
            } else if (resultat2.containsAll(block23) && loop28 && place5) {
                loop28 = false;
                place5 = false;
                resultat2.add(5);
                tile5.setImage(o);
            } else if (resultat2.containsAll(block24) && loop29 && place5) {
                loop29 = false;
                place5 = false;
                resultat2.add(5);
                tile5.setImage(o);
            } else if (resultat1.containsAll(block1) && loop1 && place3) {
                loop1 = false;
                place3 = false;
                resultat2.add(3);
                tile3.setImage(o);
            } else if (resultat1.containsAll(block2) && loop2 && place6) {
                loop2 = false;
                place6 = false;
                resultat2.add(6);
                tile6.setImage(o);
            } else if (resultat1.containsAll(block3) && loop3 && place9) {
                loop3 = false;
                place9 = false;
                resultat2.add(9);
                tile9.setImage(o);
            } else if (resultat1.containsAll(block4) && loop4 && place1) {
                loop4 = false;
                place1 = false;
                resultat2.add(1);
                tile1.setImage(o);
            } else if (resultat1.containsAll(block5) && loop5 && place4) {
                loop5 = false;
                place4 = false;
                resultat2.add(4);
                tile4.setImage(o);
            } else if (resultat1.containsAll(block6) && loop6 && place7) {
                loop6 = false;
                place7 = false;
                resultat2.add(7);
                tile7.setImage(o);
            } else if (resultat1.containsAll(block7) && loop7 && place1) {
                loop7 = false;
                place1 = false;
                resultat2.add(1);
                tile1.setImage(o);
            } else if (resultat1.containsAll(block8) && loop8 && place2) {
                loop8 = false;
                place2 = false;
                resultat2.add(2);
                tile2.setImage(o);
            } else if (resultat1.containsAll(block9) && loop9 && place3) {
                loop9 = false;
                place3 = false;
                resultat2.add(3);
                tile3.setImage(o);
            } else if (resultat1.containsAll(block10) && loop10 && place7) {
                loop10 = false;
                place7 = false;
                resultat2.add(7);
                tile7.setImage(o);
            } else if (resultat1.containsAll(block11) && loop11 && place8) {
                loop11 = false;
                place8 = false;
                resultat2.add(8);
                tile8.setImage(o);
            } else if (resultat1.containsAll(block12) && loop12 && place9) {
                loop12 = false;
                place9 = false;
                resultat2.add(9);
                tile9.setImage(o);
            } else if (resultat1.containsAll(block13) && loop13 && place1) {
                loop13 = false;
                place1 = false;
                resultat2.add(1);
                tile1.setImage(o);
            } else if (resultat1.containsAll(block14) && loop14 && place9) {
                loop14 = false;
                place9 = false;
                resultat2.add(9);
                tile9.setImage(o);
            } else if (resultat1.containsAll(block15) && loop15 && place3) {
                loop15 = false;
                place3 = false;
                resultat2.add(3);
                tile3.setImage(o);
            } else if (resultat1.containsAll(block16) && loop16 && place7) {
                loop16 = false;
                place7 = false;
                resultat2.add(7);
                tile7.setImage(o);
            } else if (resultat1.contains(1) && loop17 && place5) {
                loop17 = false;
                place5 = false;
                resultat2.add(5);
                tile5.setImage(o);
            } else if (resultat1.contains(3) && loop18 && place5) {
                loop18 = false;
                place5 = false;
                resultat2.add(5);
                tile5.setImage(o);
            } else if (resultat1.contains(7) && loop19 && place5) {
                loop19 = false;
                place5 = false;
                resultat2.add(5);
                tile5.setImage(o);
            } else if (resultat1.contains(9) && loop20 && place5) {
                loop20 = false;
                place5 = false;
                resultat2.add(5);
                tile5.setImage(o);
            } else if (resultat1.contains(5) && loop21) {
                loop21 = false;
                if (place1) {
                    place1 = false;
                    resultat2.add(1);
                    tile1.setImage(o);
                } else if (place3) {
                    place3 = false;
                    resultat2.add(3);
                    tile3.setImage(o);
                } else if (place7) {
                    place7 = false;
                    resultat2.add(7);
                    tile7.setImage(o);
                } else if (place9) {
                    place9 = false;
                    resultat2.add(9);
                    tile9.setImage(o);
                }
            } else if (resultat1.containsAll(block17) && loop22 && place4) {
                loop22 = false;
                place4 = false;
                resultat2.add(4);
                tile4.setImage(o);
            } else if (resultat1.containsAll(block18) && loop23 && place5) {
                loop23 = false;
                place5 = false;
                resultat2.add(5);
                tile5.setImage(o);
            } else if (resultat1.containsAll(block19) && loop24 && place6) {
                loop24 = false;
                place6 = false;
                resultat2.add(6);
                tile6.setImage(o);
            } else if (resultat1.containsAll(block20) && loop25 && place2) {
                loop25 = false;
                place2 = false;
                resultat2.add(2);
                tile2.setImage(o);
            } else if (resultat1.containsAll(block21) && loop26 && place5) {
                loop26 = false;
                place5 = false;
                resultat2.add(5);
                tile5.setImage(o);
            } else if (resultat1.containsAll(block22) && loop27 && place8) {
                loop27 = false;
                place8 = false;
                resultat2.add(8);
                tile8.setImage(o);
            } else if (resultat1.containsAll(block23) && loop28 && place5) {
                loop28 = false;
                place5 = false;
                resultat2.add(5);
                tile5.setImage(o);
            } else if (resultat1.containsAll(block24) && loop29 && place5) {
                loop29 = false;
                place5 = false;
                resultat2.add(5);
                tile5.setImage(o);
            } else if (resultat1.contains(2) && loop30) {
                loop30 = false;
                if (place1) {
                    place1 = false;
                    resultat2.add(1);
                    tile1.setImage(o);
                } else if (place3) {
                    place3 = false;
                    resultat2.add(3);
                    tile3.setImage(o);
                } else if (place7) {
                    place7 = false;
                    resultat2.add(7);
                    tile7.setImage(o);
                } else if (place9) {
                    place9 = false;
                    resultat2.add(9);
                    tile9.setImage(o);
                }
            } else if (resultat1.contains(4) && loop31) {
                loop31 = false;
                if (place1) {
                    place1 = false;
                    resultat2.add(1);
                    tile1.setImage(o);
                } else if (place3) {
                    place3 = false;
                    resultat2.add(3);
                    tile3.setImage(o);
                } else if (place7) {
                    place7 = false;
                    resultat2.add(7);
                    tile7.setImage(o);
                } else if (place9) {
                    place9 = false;
                    resultat2.add(9);
                    tile9.setImage(o);
                }
            } else if (resultat1.contains(8) && loop32) {
                loop32 = false;
                if (place1) {
                    place1 = false;
                    resultat2.add(1);
                    tile1.setImage(o);
                } else if (place3) {
                    place3 = false;
                    resultat2.add(3);
                    tile3.setImage(o);
                } else if (place7) {
                    place7 = false;
                    resultat2.add(7);
                    tile7.setImage(o);
                } else if (place9) {
                    place9 = false;
                    resultat2.add(9);
                    tile9.setImage(o);
                }
            } else if (resultat1.contains(6) && loop33) {
                loop33 = false;
                if (place1) {
                    place1 = false;
                    resultat2.add(1);
                    tile1.setImage(o);
                } else if (place3) {
                    place3 = false;
                    resultat2.add(3);
                    tile3.setImage(o);
                } else if (place7) {
                    place7 = false;
                    resultat2.add(7);
                    tile7.setImage(o);
                } else if (place9) {
                    place9 = false;
                    resultat2.add(9);
                    tile9.setImage(o);
                }
            } else if (resultat1.containsAll(block24) && loop34) {
                loop34 = false;
                if (place2) {
                    place2 = false;
                    resultat2.add(2);
                    tile2.setImage(o);
                } else if (place4) {
                    place4 = false;
                    resultat2.add(4);
                    tile4.setImage(o);
                } else if (place6) {
                    place6 = false;
                    resultat2.add(6);
                    tile6.setImage(o);
                } else if (place8) {
                    place8 = false;
                    resultat2.add(8);
                    tile8.setImage(o);
                }
            } else if (resultat1.containsAll(block23) && loop35) {
                loop35 = false;
                if (place2) {
                    place2 = false;
                    resultat2.add(2);
                    tile2.setImage(o);
                } else if (place4) {
                    place4 = false;
                    resultat2.add(4);
                    tile4.setImage(o);
                } else if (place6) {
                    place6 = false;
                    resultat2.add(6);
                    tile6.setImage(o);
                } else if (place8) {
                    place8 = false;
                    resultat2.add(8);
                    tile8.setImage(o);
                }
            }
        }
    }

    public void clearTiles() {
        tile1.setImage(null);
        tile2.setImage(null);
        tile3.setImage(null);
        tile4.setImage(null);
        tile5.setImage(null);
        tile6.setImage(null);
        tile7.setImage(null);
        tile8.setImage(null);
        tile9.setImage(null);
    }

    private boolean leaveGame() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("System Message");
        alert.setHeaderText("Are you sure that you want to leave?");

        ButtonType yes = new ButtonType("Yes");
        ButtonType no = new ButtonType("No");

        alert.getButtonTypes().setAll(yes, no);

        Boolean leave = null;

        Optional<ButtonType> playerChoice = alert.showAndWait();
        if (playerChoice.get() == yes) {
            // ... user chose "yes"
            leave = true;
        } else if (playerChoice.get() == no) {
            // ... user chose "No"
            leave = false;
        }

        return leave;
    }
}
