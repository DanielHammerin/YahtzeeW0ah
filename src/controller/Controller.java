package controller;

import model.DB;
import model.Game;
import model.Player;
import view.mainview;

import java.util.ArrayList;


/**
 * Created by Daniel on 2015-11-10.
 */
public class Controller {


    mainview mv = new mainview();


    public void startNewGame() {
        mv.displayStart();
        String cmd = mv.getInput().toLowerCase();
        if (cmd == "n") {
            startnewGame();
        }
        else if (cmd == "l") {
            playLoadedGame();
        }
        else {
            mv.displayMessages("notAvalidInput");
            startnewGame();
        }
    }

    public boolean commandControll(Game game) {
        while (true) {
            mv.displayMainScoreBoard(game.players);
            String cmd = mv.getInput();
        }
    }
    /*
     * Method for creating a new game with n Players.
     */
    public void startnewGame() {                            //Start a new game.
        Game newGame = new Game();
        ArrayList<Player> playerList = new ArrayList<>();

        mv.displayMessages("enterNewGameName");             //Enter new game name.
        String newGameName = mv.getInput();
        newGame.name = newGameName;

        mv.displayMessages("enterNplayers");                //Enter number of players.
        int nPlayers = Integer.parseInt(mv.getInput());
        newGame.numberOfPlayers = nPlayers;

        int n = 0;
        while (n <= nPlayers) {                             //While number of players is less than or equal to specified.
            Player newPlayer = new Player();                //Create new player object.
            mv.displayAddNewPlayer(n);
            String newPlayerName = mv.getInput();
            newPlayer.setName(newPlayerName);               //Set new player name.
            playerList.add(newPlayer);                      //Add player to arraylist of players.
        }
        newGame.addPlayers(playerList);                        //Add playerList to Game player list.
        commandControll(newGame);                              //Call main program with new game.
    }

    /*
     * Method for loading a saved game.
     */
    public void playLoadedGame() {                          //Load saved game and play.
        mv.displayMessages("enterSavedGameName");
        String name = mv.getInput();                        //Get game name to load.
        Game loadedGame = DB.loadGame(name);
        commandControll(loadedGame);                        //Call main program with loaded game
    }



}
