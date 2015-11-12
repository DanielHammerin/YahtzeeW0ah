package controller;

import view.mainview;


/**
 * Created by Daniel on 2015-11-10.
 */
public class Controller {

    mainview mv = new mainview();

    public void startNewGame() {
        mv.displayStart();
        String cmd = mv.getInput().toLowerCase();
        if (cmd == "n") {

        }
        else if (cmd == "l") {

        }
        commandControll();
    }

    public boolean commandControll() {
        while (true) {

        }
    }





}
