package view;

import model.Player;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Daniel on 2015-11-10.
 */
public class mainview {

    public void displayMainScoreBoard(ArrayList<Player> playerList) {
        int player = playerList.size();
        new Columns()
                .addLine("X", "| Name |", "|", playerList.get(playerList.size()).getName(), "|",)
        System.out.println("Name");
            System.out.println();
        System.out.println("Ones");
        System.out.println("Twos");
        System.out.println("Threes");
        System.out.println("Fours");
        System.out.println("Fives");
        System.out.println("Sixes");
            System.out.println();
        System.out.println("Three of a kind");
        System.out.println("Four of a kind");
        System.out.println("Full House");
        System.out.println("Small Straight");
        System.out.println("Large Straight");
        System.out.println("Chance");
        System.out.println("Yahtzee");
            System.out.println();
        System.out.println("Total Score");

    }

    public void displayStart() {
        System.out.println("Start new game? 'n' or Load existing session? 'l'");
    }

    public void displaySelectPlayers() {
        System.out.println("Select number of players: (1-5)");
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
}
