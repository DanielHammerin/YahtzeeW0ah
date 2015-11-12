package model;

/**
 * Created by Markus on 12/11/15.
 */
public class StandardYahtzeeRules {

    private int score;



    public int getScore(){return score;}




    private boolean ThreeOfKind(){

        int [] tal  = sortNumbers(dice);

        score = (1*tal [0])+(2*tal [1]) +(2*tal [1])+(3*tal [2])+(4*tal [3])+(5*tal [4])+(5*tal[6]);

        return(tal[0]== 3 || tal[1]== 3 || tal[2]== 3 || tal[3]== 3 || tal[4]== 3 || tal[5]== 3);
    }



    private boolean FourOfKind(){

        int [] tal  = sortNumbers(dice);

        score = (1*tal [0])+(2*tal [1]) +(2*tal [1])+(3*tal [2])+(4*tal [3])+(5*tal [4])+(5*tal[6]);

        return(tal[0]== 4 || tal[1]== 4 || tal[2]== 4 || tal[3]== 4 || tal[4]== 4 || tal[5]== 4);
    }


    private boolean Yahtzee(){

        int [] tal  = sortNumbers(dice);


        return(tal[0]== 5 || tal[1]== 5 || tal[2]== 5 || tal[3]== 5 || tal[4]== 5 || tal[5]== 5);
    }


    private boolean Straight(){

        boolean res = false;

        if(dice.get[0])
    }
}
