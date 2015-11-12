package model;

/**
 * Created by Daniel on 2015-11-10.
 */
public class Player {

    private String name;

    private int ones;
    private int twos;
    private int threes;
    private int fours;
    private int fives;
    private int sixes;

    private int threeofakind;
    private int fourofakind;
    private int fullhouse;
    private int smallstraight;
    private int largestraight;
    private int chance;
    private int yahtzee;

    private int totalscore;

    public int getOnes() {
        return ones;
    }

    public void setOnes(int ones) {
        this.ones = ones;
    }

    public int getTwos() {
        return twos;
    }

    public void setTwos(int twos) {
        this.twos = twos;
    }

    public int getThrees() {
        return threes;
    }

    public void setThrees(int threes) {
        this.threes = threes;
    }

    public int getFours() {
        return fours;
    }

    public void setFours(int fours) {
        this.fours = fours;
    }

    public int getFives() {
        return fives;
    }

    public void setFives(int fives) {
        this.fives = fives;
    }

    public int getSixes() {
        return sixes;
    }

    public void setSixes(int sixes) {
        this.sixes = sixes;
    }

    public int getThreeofakind() {
        return threeofakind;
    }

    public void setThreeofakind(int threeofakind) {
        this.threeofakind = threeofakind;
    }

    public int getFourofakind() {
        return fourofakind;
    }

    public void setFourofakind(int fourofakind) {
        this.fourofakind = fourofakind;
    }

    public int getFullhouse() {
        return fullhouse;
    }

    public void setFullhouse(int fullhouse) {
        this.fullhouse = fullhouse;
    }

    public int getSmallstraight() {
        return smallstraight;
    }

    public void setSmallstraight(int smallstraight) {
        this.smallstraight = smallstraight;
    }

    public int getLargestraight() {
        return largestraight;
    }

    public void setLargestraight(int largestraight) {
        this.largestraight = largestraight;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public int getYahtzee() {
        return yahtzee;
    }

    public void setYahtzee(int yahtzee) {
        this.yahtzee = yahtzee;
    }

    public int getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(int totalscore) {
        this.totalscore = totalscore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
