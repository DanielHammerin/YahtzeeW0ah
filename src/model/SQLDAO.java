package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Contains methods to interact with the data base.
 * Created by Daniel Hammerin 10-11-2015.
 */
public class SQLDAO {

    private static ArrayList<Game> savedGames = new ArrayList<>();

    /**
     * Saves the passed member into the database.
     * @param game, the member to be saved.
     */
    public static void saveGame(Game game) {
        savedGames.add(game);
    }

    public Game loadGame() {
        Game game;
        for (Game g : savedGames ) {
            if (g.)
        }
        return game;
    }

}
