package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Contains methods to interact with the data base.
 * Created by Daniel Hammerin 10-11-2015.
 */
public class DB {

    private static ArrayList<Game> savedGames = new ArrayList<>();

    /**
     * Saves the passed member into the database.
     * @param game, the member to be saved.
     */
    public static  void saveGame(Game game) {
        savedGames.add(game);
    }

    public static Game loadGame(String gameName) {
        Game game = null;
        for (Game g : savedGames ) {
            if (g.name.equals(gameName)) {
                game = g;
                return game;
            }
        }
        return game;
    }

    public static List<String> getSavedGameNames() {
        ArrayList<String> games = new ArrayList<>();
        for (Game g : savedGames) {
            games.add(g.name);
        }
        return games;
    }

    public static ArrayList<Game> getGames() {
        return savedGames;
    }

}
