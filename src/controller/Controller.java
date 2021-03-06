package controller;

import model.DB;
import model.Game;
import model.Player;
import view.mainview;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;


/**
 * This is the controller class. It connects pretty much everything together
 * and is responsible for starting the game, rolling, selecting category etc.
 * Created by Daniel Hammerin on 2015-11-10.
 */
public class Controller {


    mainview mv = new mainview();

    int nRolls;
    ArrayList<Integer> rollingHand;
    int[] finalHand;
    int finalArrIndex;
    /*
     * Method for pre game start.
     */
    public void startNewGame() {
        mv.displayStart();
        String cmd = mv.getInput().toLowerCase();
        if (cmd.equals("n")) {
            startbrandnewgame();
        }
        else if (cmd.equals("l")) {
            playLoadedGame();
        }
        else if (cmd.equals("v")) {
            viewFinishedGame();
        }
        else {
            mv.displayMessages("notAvalidInput");
            startNewGame();
        }
    }
    /*
     * Method for when a game is started. This is the main method for saving, loading or playing a game.
     */
    public boolean commandControll(Game game) {
        while (true) {
            if (game.isGameOver(game)) {                      //Checks if  the game is over and who won.
                mv.displayWinner(game.getWinner());
                saveGame(game);
                startNewGame();
            }
            else {
                nRolls = 0;
                finalArrIndex = 0;
                finalHand = new int[5];
                rollingHand = new ArrayList<>();

                mv.displayCommands();
                mv.displayMainScoreBoard(game.players, game.possibleCategories(finalHand));
                String cmd = mv.getInput().toLowerCase();

                if (cmd.equals("p")) {              //Reset for the next player.
                    game.increaseRound();           //Increase round number for every cycle of all players.
                    Player p = game.getPlayer();
                    rollingHand = game.rollNewhand(); //Just to initialize rollingHand.
                    nRolls++;
                    rolling(game, p);
                }
                else if (cmd.equals("l")) {         //Load another game.
                    loadAnotherGame(game);
                }
                else if (cmd.equals("s")) {         //Save game.
                    saveGame(game);
                    mv.displayMessages("saved");
                }
                else {
                    mv.displayMessages("notAvalidInput");
                }
            }
        }
    }
    /*
     * When a player chooses to play, the player is sent here to "rolling". The player can choose to roll, score and
     * save dices. The player is then sent to chose a category to score in.
     * After scoring the program returns to commandcontroll and the next player can play their round.
     */
    public void rolling(Game game, Player p) {
        mv.displayPlayersTurn(p.getName());
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
            }
            else if (nRolls > 0 && nRolls < 4) {
                if (nRolls == 3) {                          //If player has rolled 3 times.
                    for (int i : rollingHand) {
                        finalHand[finalArrIndex] = i;
                        finalArrIndex++;
                    }
                    selectCategoryToScore(finalHand, p, game);       //Go to score selection part.
                }
                else {
                    //chooseDiceToKeep(game, p);

                    mv.displayMessages("choosedicestokeep");
                    String in = mv.getInput();                            //String of dices to keep.

                    for (char c : in.toCharArray()) {           //For every char in the input string.
                        int x = Character.getNumericValue(c);   //Set x to char value.
                        for (Iterator<Integer> it = rollingHand.iterator(); it.hasNext(); ) {             //Check the rolled hand.
                            int i = it.next();
                            if (x == i) {                       //If x matches any of the numbers rolled.
                                finalHand[finalArrIndex] = i;   //Put x in the intArray finalHand[]
                                it.remove();                    //remove it from the arrayList of rolling dices.
                                finalArrIndex++;                //Increase index in intArray.
                                break;
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

    /*
    public void chooseDiceToKeep(Game game, Player p) {
        mv.displayMessages("choosedicestokeep");
        String in = mv.getInput();                              //String of dices to keep.

        for (char c : in.toCharArray()) {                       //For every char in the input string.
            for (int i = rollingHand.size(); i >= 0 ; i--) {            //Check the rolled hand from last to first.
                if (c == i) {                                   //If x matches any of the numbers rolled.
                    finalHand[finalArrIndex] = rollingHand.get(i);               //Put value of i in the intArray finalHand[]
                    rollingHand.remove(i);                      //remove i from the arrayList of rolling dices.
                    finalArrIndex++;                            //Increase index in intArray.
                }
            }
        }
        rollingHand = game.rollHand(rollingHand);               //Re-roll remaining dices.
        rolling(game, p);
    }
*/
    public void selectCategoryToScore(int[] finalHand, Player p, Game g) {        //Directs user to score part or w/e...
        ArrayList<Boolean> selection = g.possibleCategories(finalHand);           //Gets arraylist of possible score categories.
        mv.displayMainScoreBoard(g.players, selection);                           //Show possible score categories.

        mv.displayMessages("choosecat2score");
        String cmdIn = mv.getInput().toLowerCase();
        if (Integer.parseInt(cmdIn) > 13 || Integer.parseInt(cmdIn) < 1) {
            mv.displayMessages("notAvalidInput");
            selectCategoryToScore(finalHand, p, g);
        }
        else {
            boolean checkable = g.getConfirmation(cmdIn, selection);                 //Boolean for if the chosen category is actually pickable.
            boolean scoredBefore = g.categoryHasBeenScored(p, cmdIn);                    //Boolean for if the category has already been picked.

            if (checkable && !scoredBefore) {
                g.scoreCategoryInPlayer(cmdIn, p, finalHand);
                p.setTotalscore();
            }
            else if (scoredBefore) {
                mv.displayMessages("alreadyscored");
                selectCategoryToScore(finalHand, p, g);
            }
            else if (!checkable) {
                mv.displayMessages("cantscorethere");
                selectCategoryToScore(finalHand, p, g);
            }
            else {
                mv.displayMessages("notAvalidInput");
                selectCategoryToScore(finalHand, p, g);
            }
        }
    }

    /*
     * Method for creating a new game with n Players.
     */
    public void startbrandnewgame() {                            //Start a new game.
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
            newPlayer.setGameName(newGameName);             //Set name of game to a player to know which game they belong to.
            playerList.add(newPlayer);                      //Add player to arraylist of players.
            n++;
        }
        newGame.addPlayers(playerList);                        //Add playerList to Game player list.
        newGame.date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        commandControll(newGame);                              //Call main program with new game.
    }

    /*
     * Method for loading a saved game.
     */
    public void playLoadedGame() {                          //Load saved game and play.
        if (DB.getGames().isEmpty()) {
            mv.displayMessages("nogames");
            startNewGame();
        }
        else {
            mv.displayMessages("enterSavedGameName");
            mv.displaySavedGames(DB.getSavedGameNames());
            String name = mv.getInput();                        //Get game name to load.
            Game loadedGame = DB.loadGame(name);
            commandControll(loadedGame);                        //Call main program with loaded game
        }
    }

    public void viewFinishedGame() {
        mv.displayMessages("savedgames");
        if (DB.getGames().isEmpty()) {
            mv.displayMessages("nogames");
            startNewGame();
        }
        else {
            mv.displaySavedGames(DB.getSavedGameNames());
            mv.displayMessages("enterSavedGameName");
            String name = mv.getInput();
            Game loadedGame = DB.loadGame(name);

            mv.displayMessages("compactverbose");
            String s = mv.getInput();
            if (s.equals("v")) {
                int[] temp = {0, 0, 0, 0, 0};
                mv.displayDate(loadedGame.date);
                mv.displayMainScoreBoard(loadedGame.players, loadedGame.possibleCategories(temp));
            } else if (s.equals("c")) {
                mv.displayDate(loadedGame.date);
                mv.displayCompactList(loadedGame);
            }
        }
    }

    public void loadAnotherGame(Game thisGame) {
        if (DB.getGames().isEmpty()) {
            mv.displayMessages("nogames");
            startNewGame();
        }
        else {
            DB.saveGame(thisGame);

            mv.displayMessages("enterSavedGameName");
            mv.displaySavedGames(DB.getSavedGameNames());
            String s = mv.getInput();
            commandControll(DB.loadGame(s));
        }
    }

    public void saveGame(Game thisGame) {
        DB.saveGame(thisGame);
    }

}
