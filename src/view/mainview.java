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
}
