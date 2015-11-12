package model;

/**
 * Created by Markus on 12/11/15.
 *
 * This class creates an instance of Dice
 */
public class Dice {


    private int id;

    private int tal;


    public Dice(int id){

        tal = (int) (Math.random()*6 +1);
        this.id = id;
    }



    public void roll() {

        tal = (int) (Math.random()*6) +1;
    }

    public int getTal(){return tal;}
    public int getId(){return id;}
}
