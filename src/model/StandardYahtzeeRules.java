package model;

/**
 * Created by Markus on 12/11/15.
 */
public class StandardYahtzeeRules {

    private int score;



    public int getScore(){return score;}


    Game game = new Game();


    private int[] Sort(int[] dice){             //Takes in final hand of dices.

        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;

        for(int i = 0; i < dice.length; i++){   //Sets variables depending on which rolled numbers are present.
            if(dice[i] == 1) {
                one++;
            }
            if(dice[i] == 2) {
                two++;
            }
            if(dice[i] == 3) {
                three++;
            }
            if(dice[i] == 4) {
                four++;
            }
            if(dice[i] == 5) {
                five++;
            }
            if(dice[i] == 6) {
                six++;
            }
        }

        int[] numb = new int [] {one, two, three, four, five, six};             //Put all variables in a new int[]
        return numb;
    }

    private boolean ThreeOfKind(int[] dice){

        boolean res = false;

        int[] scores  = Sort(dice);

        score = (1*scores [0])+(2*scores [1]) +(2*scores [1])+(3*scores [2])+(4*scores [3])+(5*scores [4])+(5*scores[6]);

        if(scores[0]== 3 || scores[1]== 3 || scores[2]== 3 || scores[3]== 3 || scores[4]== 3 || scores[5]== 3)
        {
            res = true;

        }
        return res;
    }



    private boolean FourOfKind(int[] dice){

        boolean res = false;
        int[] scores  = Sort(dice);

        score = (1*scores [0])+(2*scores [1]) +(2*scores [1])+(3*scores [2])+(4*scores [3])+(5*scores [4])+(5*scores[6]);

        if(scores[0]== 4 || scores[1]== 4 || scores[2]== 4 || scores[3]== 4 || scores[4]== 4 || scores[5]== 4){
            res = true;
        }
    return res;
    }


    private boolean Yahtzee(int[] dice){

        int[] scores  = Sort(dice);
        boolean res = false;

        if(scores[0]== 5 || scores[1]== 5 || scores[2]== 5 || scores[3]== 5 || scores[4]== 5 || scores[5]== 5){
            res = true;
        }
        return res;

    }


    private boolean Straight(int[] dice){

        boolean res = false;

        if(dice[0] == 1 && dice[1] == 2 && dice[2] == 3 && dice[3] == 4
                && dice[4] == 5){
            res = true;
        }
        if(dice[0] == 2 && dice[1] == 3 && dice[2] == 4 && dice[3] == 5
                && dice[4] == 6){
            res = true;
        }

        return res;
    }

    private boolean smallStraight(int[] dice){

        boolean res = false;
        int[] scores = Sort(dice);

       // StandardYahtzeeRules.Sort(scores);


        if((scores[5] == scores[5]+1) &&(scores[4] == scores[3]+1) && (scores[3] == scores[2]+1)){
            res = true;
        }
        return res;
    }


    private boolean fullHouse(int [] dice){

        boolean res = false;
        int[] scores = Sort(dice);

        // StandardYahtzeeRules.Sort(scores);

        if(scores[5] == 3 && scores[4] == 2)
        {
            res = true;
        }

        return res;
    }
}
