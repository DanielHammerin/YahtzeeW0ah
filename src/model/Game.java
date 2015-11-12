package model;

import java.util.ArrayList;

/**
 * Created by Daniel on 2015-11-10.
 */
public class Game {

    public String name;
    public int numberOfPlayers;
    public ArrayList<Player> players = new ArrayList<>();



    public int[] rollHand() {
        Dice d = new Dice();
        int[] hand = d.roll();
        return hand;
    }

    public void addPlayers(ArrayList<Player> arr) {            //Add players to game player list.
        for (Player p : arr) {
            players.add(p);
        }
    }


}
