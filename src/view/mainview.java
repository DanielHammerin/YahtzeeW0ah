package view;

import java.util.Scanner;

/**
 * Created by Daniel on 2015-11-10.
 */
public class mainview {

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
    }
}
