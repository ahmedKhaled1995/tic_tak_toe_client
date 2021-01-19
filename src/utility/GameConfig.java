/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

/**
 *
 * @author LENOVO
 */
public class GameConfig {
    
    //This class is intended to hold all the player configuration regarding the difficulty level, game mode, flags about players's requests
    //feel free to add more configurations
    
    /*
        Difficulty level: 
        0 -> Easy
        1 -> Medium
        2 -> Hard
    */
    private static int gameDifficultyLevel;
    
    /*
        Game Mode:
        1 -> Single Player Mode
        2 -> Multiplayer Mode
    */
    private static int gameMode;
    
    public static void setGameDifficultyLevel(int _gameDifficultyLevel){
        gameDifficultyLevel = _gameDifficultyLevel;
    }
    
    public static int getGameDiffficultyLevel(){
        return gameDifficultyLevel;
    }
    
    public static void setGameMode(int _gameMode){
        gameMode = _gameMode;
    }
    
    public static int getGameMode(){
        return gameMode;
    }
}
