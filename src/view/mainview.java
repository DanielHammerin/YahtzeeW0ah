package view;

import model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Daniel Hammerin on 2015-11-10.
 */
public class mainview {

    public void displayCommands() {
        System.out.println("To roll, press:   'R'");
        System.out.println("The roll will be displayed as a series of numbers.");
        System.out.println("Enter the number(s) you wish to save.");
        System.out.println("Then press 'R' again to re-roll all unselected dices.");
    }
    public void displayMainScoreBoard(ArrayList<Player> playerList) {
        /*
         * ArrayLists inside method so they are cleared (new ones made) every time the method is called.
         */
        List<String> Name = new ArrayList<>();
        List<String> Ones = new ArrayList<>();
        List<String> Twos = new ArrayList<>();
        List<String> Threes = new ArrayList<>();
        List<String> Fours = new ArrayList<>();
        List<String> Fives = new ArrayList<>();
        List<String> Sixes = new ArrayList<>();

        List<String> Threeofakind = new ArrayList<>();
        List<String> Fourofakind = new ArrayList<>();
        List<String> Fullhouse = new ArrayList<>();
        List<String> Smallstraight = new ArrayList<>();
        List<String> Largestraight = new ArrayList<>();
        List<String> Chance = new ArrayList<>();
        List<String> Yahtzee = new ArrayList<>();

        List<String> Totalscore = new ArrayList<>();

        for (Player p : playerList) {                           //For every player, append their category data.
            Name.add(p.getName());
            Ones.add(String.valueOf(p.getOnes()));
            Twos.add(String.valueOf(p.getTwos()));
            Threes.add(String.valueOf(p.getThrees()));
            Fours.add(String.valueOf(p.getFours()));
            Fives.add(String.valueOf(p.getFives()));
            Sixes.add(String.valueOf(p.getSixes()));

            Threeofakind.add(String.valueOf(p.getThreeofakind()));
            Fourofakind.add(String.valueOf(p.getFourofakind()));
            Fullhouse.add(String.valueOf(p.getFullhouse()));
            Smallstraight.add(String.valueOf(p.getSmallstraight()));
            Largestraight.add(String.valueOf(p.getLargestraight()));
            Chance.add(String.valueOf(p.getChance()));
            Yahtzee.add(String.valueOf(p.getYahtzee()));
            Totalscore.add(String.valueOf(p.getTotalscore()));
        }

        System.out.println("|   | Name            " + stringBuilder(Name));
        System.out.println("|1. | Ones            " + stringBuilder(Ones));
        System.out.println("|2. | Twos            " + stringBuilder(Twos));
        System.out.println("|3. | Threes          " + stringBuilder(Threes));
        System.out.println("|4. | Fours           " + stringBuilder(Fours));
        System.out.println("|5. | Fives           " + stringBuilder(Fives));
        System.out.println("|6. | Sixes           " + stringBuilder(Sixes));
        System.out.println("|7. | Three of a kind " + stringBuilder(Threeofakind));
        System.out.println("|8. | Four of a kind  " + stringBuilder(Fourofakind));
        System.out.println("|9. | Full House      " + stringBuilder(Fullhouse));
        System.out.println("|1. | Small Straight  " + stringBuilder(Smallstraight));
        System.out.println("|11.| Large Straight  " + stringBuilder(Largestraight));
        System.out.println("|12.| Chance          " + stringBuilder(Chance));
        System.out.println("|13.| Yahtzee         " + stringBuilder(Yahtzee));
        System.out.println("|   | Total Score     " + stringBuilder(Totalscore));

    }

    /*
     * Method for creating the lines for the scoreboard.
     */
    public String stringBuilder(List<String> arrIn) {
        StringBuilder sb = new StringBuilder();
        for (String s : arrIn) {
            sb.append("|");
            sb.append(s);
            sb.append(pad(s));
        }
        return sb.toString();
    }

    /*
     * Method for padding the spaces between columns.
     */
    public String pad(String s) {
        int space = 15;
        int sLength = s.length();
        String retPad = "";
        int temp = space - sLength;

        for (int i = 0; i <= temp ; i++) {
            retPad += " ";
        }
        return retPad;
    }

    public void displayRoll(ArrayList<Integer> arrOut) {
        StringBuilder sb = new StringBuilder();
        for (int i : arrOut) {
            sb.append(i).toString();
            sb.append(", ");
        }
        System.out.println("Rolled numbers: " + sb.toString());
    }

    public void displayStart() {
        System.out.println("Start new game? 'n' or Load existing session? 'l'");
    }

    public String getInput() {
        Scanner sc = new Scanner(System.in);
        String ret = sc.nextLine();
        return ret;
    }

    public void displayMessages(String in) {
        if (in.equals("enterNplayers")) {
            System.out.println("Please enter number of players. (1-5)");
        }
        else if (in.equals("notAvalidInput")) {
            System.out.println("Not a valid input please try again.");
        }
        else if (in.equals("enterNewGameName")) {
            System.out.println("Enter the name of the new game session.");
        }
        else if (in.equals("enterSavedGameName")) {
            System.out.println("Enter the name of your saved game.");
        }
        else if(in.equals("enterplayername")) {
            System.out.println("Enter ");
        }
        else if (in.equals("choosedicestokeep")) {
            System.out.println("Choose which dices you wish to keep. (Enter their actual number)");
        }
        else if (in.equals("rollorscore")) {
            System.out.println("Do you wish to score or roll again? R/S");
        }
    }

    public void displayAddNewPlayer(int n) {
        if (n == 0) {
            System.out.println("Enter first players name:");
        }
        else if (n == 1) {
            System.out.println("Enter second players name:");
        }
        else if (n == 2) {
            System.out.println("Enter third players name:");
        }
        else if (n == 3) {
            System.out.println("Enter fourth players name:");
        }
        else if (n == 4) {
            System.out.println("Enter last players name:");
        }
    }

    public void displaySavedDices(int[] finalHand) {
        StringBuilder sb = new StringBuilder();
        for (int i : finalHand) {
            sb.append(i);
        }
        System.out.println("Saved dices: " + sb.toString());
    }
}
