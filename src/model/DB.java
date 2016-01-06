package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.io.*;

/**
 * In this class we have created methods to
 * help with saving the game  as well as loading it. We tried using Serializable
 * to save the game to a file, but came to the conclusion that using an arraylist
 * was a much simpler and fail-free solution, specially since we have too little
 * knowlage in how serializable works.
 * Created by Daniel Hammerin 10-11-2015.
 */
public class DB implements Serializable{

    private static ArrayList<Game> savedGames = new ArrayList<>();

    /**
     * Saves the passed member into the database.
     * @param game, the member to be saved.
     */
    public static void saveGame(Game game) {
        Game toRemove = null;
        for (Game g : savedGames) {
            if (g.name.equals(game.name)) {
                toRemove = g;
            }
        }
        if (toRemove != null) {
            savedGames.remove(toRemove);
        }
        savedGames.add(game);
    }

    public static Game loadGame(String gameName) {
        Game game = null;
        for (Game g : savedGames ) {
            if (g.name.equals(gameName)) {
                game = g;
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

    public boolean GameSave(Game game){
        String s = "saveGame'" + game.name + "'.ser";
        try{
            FileOutputStream file = new FileOutputStream(s);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(game);
            System.out.printf("The data is now saved in savedGame.ser file");

        }catch(IOException i){
            i.printStackTrace();
        }
    return true;
    }

    public Game GameLoad(Game game){
        try
        {
            File file = new File("savedGame.ser");
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            game = (Game) in.readObject();
            return game;
        }catch(IOException i) {
            i.printStackTrace();

            return null;
        }catch(ClassNotFoundException c){
            c.printStackTrace();

            return null;
        }
    }
}

