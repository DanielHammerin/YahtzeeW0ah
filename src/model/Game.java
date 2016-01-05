package model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Daniel Hammerin on 2015-11-10.
 */
public class Game {

    public String name;
    public int numberOfPlayers;
    public ArrayList<Player> players = new ArrayList<>();
    int playerListIndex;
    ArrayList<Boolean> checkable;
    StandardRules yahtzeeRule = new StandardRules();
    public int rounds;
    public String date;

    public ArrayList<Integer> rollNewhand() {
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

    public Player getWinner() {
        Player winner = players.get(0);
        for (Player p : players) {
            if (p.getTotalscore() > winner.getTotalscore()) {
                winner = p;
            }
        }
        return winner;
    }

    public boolean isGameOver(Game g) {
        return yahtzeeRule.isGameOver(g);
    }

    public void increaseRound() {
        rounds++;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

}
