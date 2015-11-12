package controller;

import model.DB;
import model.Game;
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
            startnewGame();
        }
        else if (cmd == "l") {
            playLoadedGame();
        }
        else {
            mv.displayMessages("notAvalidInput");
            startnewGame();
        }
    }

    public boolean commandControll(Game game) {
        while (true) {

        }
    }

    public void startnewGame() {
        Game game = new Game();
        mv.displayMessages("enterNewGameName");
        String newGameName = mv.getInput();
        game.name = newGameName;

        mv.displayMessages("enterNplayers");


    }
    public void playLoadedGame() {
        DB db = new DB();
        mv.displayMessages("enterSavedGameName");
        String name = mv.getInput();
        Game game = db.loadGame(name);
        commandControll(game);
    }



}
