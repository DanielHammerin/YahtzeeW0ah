package model;

import java.util.ArrayList;

/**
 * Created by Markus on 12/11/15.
 *
 * This class creates an instance of Dice.
 */
public class Dice {

    public int roll() {
        int tal;
        tal = (int) (Math.random()*6) +1;
        return tal;
    }


}
