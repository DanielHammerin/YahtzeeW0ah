package model;

import java.util.ArrayList;

/**
 * Created by Daniel Hammerin on 2015-11-10.
 */
public class Game {

    public String name;
    public int numberOfPlayers;
    public ArrayList<Player> players = new ArrayList<>();
    int playerListIndex;

    public ArrayList<Integer> rollNewhand() {
        ArrayList<Integer> arr = new ArrayList<>();
        Dice dice = new Dice();
        int n = 0;
        while (n <= 5) {
            arr.add(dice.roll());
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
        ArrayList<Boolean> checkable;

    }
}
