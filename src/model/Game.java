package model;

import java.math.RoundingMode;
import java.util.ArrayList;

/**
 * Created by Daniel Hammerin on 2015-11-10.
 */
public class Game {

    public String name;
    public int numberOfPlayers;
    public ArrayList<Player> players = new ArrayList<>();
    int playerListIndex;
    ArrayList<Boolean> checkable;
    StandardYahtzeeRules yahtzeeRule = new StandardYahtzeeRules();
    public int Rounds;

    public ArrayList<Integer> rollNewhand() {
        Rounds++;
        ArrayList<Integer> arr = new ArrayList<>();
        Dice dice = new Dice();
        int n = 0;
        while (n < 5) {
            arr.add(dice.roll());
            n++;
        }
        return arr;
    }
    public ArrayList<Integer> rollHand(ArrayList<Integer> arr) {

        Rounds++;
        StandardYahtzeeRules r = new StandardYahtzeeRules();
        ForcedYahtzeeRules e = new ForcedYahtzeeRules();
        e.GameOverTwo(game);
        r.GameOverOne(game);

        ArrayList<Integer> retArr = new ArrayList<>();
        Dice dice = new Dice();
        for (int i : arr) {
            i = dice.roll();
            retArr.add(i);
        }
        return retArr;
    }

    public void addPlayers(ArrayList<Player> arr) {            //Add players to game player list.
        for (Player p : arr) {
            players.add(p);
        }
    }


    public Player getPlayer() {                             //Basically iterates over players and returns them in order of entry which dictates who's turn it is.
        Player p;
        while (true) {
            if (playerListIndex == players.size()) {
                playerListIndex = 0;
            }
            else {
                p = players.get(playerListIndex);
                playerListIndex++;
                return p;
            }
        }
    }

    public ArrayList<Boolean> possibleCategories(int[] finalhand) {
        checkable = yahtzeeRule.getCategories(finalhand);
        return checkable;
    }

    public boolean getConfirmation(String cmdIn, ArrayList<Boolean> selection) {                //Ensure that the category is pickable.
        
        if (selection.get(Integer.parseInt(cmdIn) - 1)) {                                   //From the list of booleans, check the one that the player wanted.
            return true;
        }
        else {
            return false;
        }
    }

    public void scoreCategoryInPlayer(String cmdIn, Player p, int[] finalHand) {
        yahtzeeRule.scoreCategoryInPlayer(cmdIn, p, finalHand);
    }
    /*
     * Looks in the players score sheet if the player has scored the category before.
     */
    public boolean categoryHasBeenScored(Player p, String cmdIn) {
        boolean b;
        ArrayList<Boolean> playerCategories = p.getPlayerCategories(p);

        if (playerCategories.get(Integer.parseInt(cmdIn) - 1)) {
            b = true;
        }
        else {
            b = false;
        }
        return b;
    }

    public void whoWon(){

        //IF gameover1 = true; skriv ut allas score men ändå säg vem hade högsta
        //IF gameover2 = true; skriv ut den som hade högst score
        // fixa så att man kan spara score efter ett gameOver

    }



}
