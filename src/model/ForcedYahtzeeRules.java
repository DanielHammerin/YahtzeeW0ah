package model;

import java.util.ArrayList;

/**
 * Created by Markus on 16/11/15.
 */
public class ForcedYahtzeeRules {

    private int score;

    public int getScore(){
        return score;
    }

    /*
     * Method for checking which categories are scorable.
     * Created by Daniel Hammerin 2015-11-15
     */
    public ArrayList<Boolean> getCategories(int[] finalHand) {
        ArrayList<Boolean> categories = new ArrayList<>();

        if (finalHand == null) {                                                //If the final hand is empty, just return an arraylist of false.
            int n = 0;
            while (n <= 12) {
                categories.add(false);
                n++;
            }
            return categories;
        }
        else {
            categories.add(Ones(finalHand));                                   //Adding them to the return list.
            categories.add(Twos(finalHand));
            categories.add(Threes(finalHand));
            categories.add(Fours(finalHand));
            categories.add(Fives(finalHand));
            categories.add(Sixes(finalHand));
            categories.add(ThreeOfKind(finalHand));
            categories.add(FourOfKind(finalHand));
            categories.add(fullHouse(finalHand));
            categories.add(smallStraight(finalHand));
            categories.add(Straight(finalHand));
            categories.add(Chance(finalHand));
            categories.add(Yahtzee(finalHand));

            return categories;
        }
    }

    public int[] Sort(int[] dice){             //Takes in final hand of dices.

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

    private boolean Ones(int[] dice){
        boolean res = false;

        for(int i = 0; i < 5; i++){
            if(dice[i]== 1){
                res = true;
            }
        }
        return res;
    }

    private boolean Twos(int[] dice){
        boolean res = false;

        for(int i = 0; i < 5; i++){
            if(dice[i]== 2){
                res = true;
            }
        }
        return res;
    }
    private boolean Threes(int[] dice){
        boolean res = false;

        for(int i = 0; i < 5; i++){
            if(dice[i]== 3){
                res = true;
            }
        }
        return res;
    }
    private boolean Fours(int[] dice){
        boolean res = false;

        for(int i = 0; i < 5; i++){
            if(dice[i]== 4){
                res = true;
            }
        }
        return res;
    }
    private boolean Fives(int[] dice){
        boolean res = false;

        for(int i = 0; i < 5; i++){
            if(dice[i]== 5){
                res = true;
            }
        }
        return res;
    }
    private boolean Sixes(int[] dice){
        boolean res = false;

        for(int i = 0; i < 5; i++){
            if(dice[i]== 6){
                res = true;
            }
        }
        return res;
    }

    private boolean ThreeOfKind(int[] dice){

        boolean res = false;

        int[] scores  = Sort(dice);

        score = (1*scores[0])+(2*scores[1])+(3*scores[2])+(4*scores[3])+
                (5*scores[4])+(6*scores[5]);

        if(scores[0]== 3 || scores[1]== 3 || scores[2]== 3 || scores[3]== 3 || scores[4]== 3 || scores[5]== 3)
        {
            res = true;

        }
        return res;
    }



    private boolean FourOfKind(int[] dice){

        boolean res = false;
        int[] scores  = Sort(dice);

        score = (1*scores[0])+(2*scores[1])+(3*scores[2])+(4*scores[3])+
                (5*scores[4])+(6*scores[5]);

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

    private boolean Chance(int [] dice){

        int [] scores = Sort(dice);

        int sum = 0;

        for(int i = 0;i < 5; i++){
            sum += dice[i];

        }

        return true;
    }
    /*
     * Method for scoring in lower scores.
     * Created by Daniel Hammerin 2015-12-20
     */
    public int score(int[] finalHand, int n) {
        int s = 0;
        for (int i : finalHand) {
            if (i == n) {
                s += n;
            }
        }
        return s;
    }
    /*
     * Method for putting score in player.
     * Created by Daniel Hammerin 2015-12-20
     */
    public void scoreCategoryInPlayer(String cmdIn, Player p, int[] finalHand) {                                        //Score in category chosen.
        int in = Integer.parseInt(cmdIn);

        if (in == 1) {
            p.setOnes(score(finalHand, 1));
        }
        else if (in == 2) {
            p.setTwos(score(finalHand, 2));
        }
        else if (in == 3) {
            p.setThrees(score(finalHand, 3));
        }
        else if (in == 4) {
            p.setFours(score(finalHand, 4));
        }
        else if (in == 5) {
            p.setFives(score(finalHand, 5));
        }
        else if (in == 6) {
            p.setSixes(score(finalHand, 6));
        }
        else if (in == 7) {
            int[] intArr = Sort(finalHand);
            int s = 0;
            for (int i : intArr) {
                if (i >= 3) {
                    s = i * 3;
                }
            }
            p.setThreeofakind(s);
        }
        else if (in == 8) {
            int[] intArr = Sort(finalHand);
            int s = 0;
            for (int i : intArr) {
                if (i >= 4) {
                    s = i * 4;
                }
            }
            p.setFourofakind(s);
        }
        else if (in == 9) {
            p.setFullhouse(25);
        }
        else if (in == 10) {
            p.setSmallstraight(30);
        }
        else if (in == 11) {
            p.setLargestraight(40);
        }
        else if (in == 12) {
            int s = 0;
            for (int i : finalHand) {
                s += i;
            }
            p.setChance(s);
        }
        else if (in == 13) {
            p.setYahtzee(50);
        }
    }

    //Method to check if a player has reached a score of 200, if so then the game is over and the player won

    public void GameOver(Player p, int [] finalHand, Game game){
        for(Player i: game.players)
        if(i.getTotalscore() == 200){
            System.out.println("Player"+i.getName()+"Has reached the score of 200, thus he wins the game.");
        }
    }
}

