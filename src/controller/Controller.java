package controller;

import model.DB;
import model.Game;
import model.Player;
import view.mainview;

import java.util.ArrayList;


/**
 * Created by Daniel Hammerin on 2015-11-10.
 */
public class Controller {


    mainview mv = new mainview();

    int nRolls;
    ArrayList<Integer> rollingHand;
    int[] finalHand;
    int finalArrIndex;

    public void startNewGame() {
        mv.displayStart();
        String cmd = mv.getInput().toLowerCase();
        if (cmd.equals("n")) {
            startnewGame();
        }
        else if (cmd.equals("l")) {
            playLoadedGame();
        }
        else {
            mv.displayMessages("notAvalidInput");
            startnewGame();
        }
    }

    public boolean commandControll(Game game) {
        while (true) {
            mv.displayCommands();
            mv.displayMainScoreBoard(game.players, game.possibleCategories(finalHand));
            String cmd = mv.getInput().toLowerCase();

            if (cmd.equals("r")) {              //Reset for the next player.
                nRolls = 0;
                finalArrIndex = 0;
                finalHand = new int[5];
                Player p = game.getPlayer();
                rolling(game, p);
            }
            else if (cmd.equals("l")) {         //Load another game.

            }
            else if (cmd.equals("s")) {         //Save game.

            }
            else {
                mv.displayMessages("notAvalidInput");
            }
        }
    }

    public void rolling(Game game, Player p) {
        mv.displayMainScoreBoard(game.players, game.possibleCategories(finalHand));
        mv.displaySavedDices(finalHand);
        mv.displayRoll(rollingHand);
        mv.displayMessages("rollorscore");
        String cmdIn = mv.getInput().toLowerCase();

        if (cmdIn.equals("r")) {                            //If player wants to roll.
            if (nRolls == 0) {
                rollingHand = game.rollNewhand();           //RollingHand is an arrayList.
                nRolls++;
                rolling(game, p);
            } else if (nRolls > 0 && nRolls < 4) {
                if (nRolls == 3) {                          //If player has rolled 3 times.
                    for (int i : rollingHand) {
                        finalHand[finalArrIndex] = i;
                        finalArrIndex++;
                    }
                    selectCategoryToScore(finalHand, p, game);       //Go to score selection part.
                } else {
                    mv.displayMessages("choosedicestokeep");
                    String in = mv.getInput();                            //String of dices to keep.

                    for (char c : in.toCharArray()) {           //For every char in the input string.
                        int x = Character.getNumericValue(c);   //Set x to char value.
                        for (int i : rollingHand) {             //Check the rolled hand.
                            if (x == i) {                       //If x matches any of the numbers rolled.
                                finalHand[finalArrIndex] = i;   //Put x in the intArray finalHand[]
                                rollingHand.remove(i);          //remove it from the arrayList of rolling dices.
                                finalArrIndex++;                //Increase index in intArray.
                            }
                        }
                    }
                    rollingHand = game.rollHand(rollingHand);   //Re-roll remaining dices.
                    rolling(game, p);
                }
            }
        }
        else if (cmdIn.equals("s")) {               //If player wants to score.
            for (int i : rollingHand) {             //Put all dices to saved hand.
                finalHand[finalArrIndex] = i;
                finalArrIndex++;
            }
            selectCategoryToScore(finalHand, p, game);       //Go to score selection part.
        }
        else {
            mv.displayMessages("notAvalidInput");
            rolling(game, p);
        }
    }

    public void selectCategoryToScore(int[] finalHand, Player p, Game g) {        //Directs user to score part or w/e...
        ArrayList<Boolean> selection = g.possibleCategories(finalHand);           //Gets arraylist of possible score categories.

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
        while (n < nPlayers) {                             //While number of players is less than or equal to specified.
            Player newPlayer = new Player();                //Create new player object.
            mv.displayAddNewPlayer(n);
            String newPlayerName = mv.getInput();
            newPlayer.setName(newPlayerName);               //Set new player name.
            playerList.add(newPlayer);                      //Add player to arraylist of players.
            n++;
        }
        newGame.addPlayers(playerList);                        //Add playerList to Game player list.
        commandControll(newGame);                              //Call main program with new game.
    }

    /*
     * Method for loading a saved game.
     */
    public void playLoadedGame() {                          //Load saved game and play.
        mv.displayMessages("enterSavedGameName");
        mv.displaySavedGames(DB.getSavedGameNames());
        String name = mv.getInput();                        //Get game name to load.
        Game loadedGame = DB.loadGame(name);
        commandControll(loadedGame);                        //Call main program with loaded game
    }

    public void loadAnotherGame() {

    }

    public void saveGame() {

    }

}
