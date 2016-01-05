package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.io.*;

/**
 * Contains methods to interact with the data base.
 * Created by Daniel Hammerin 10-11-2015.
 */
public class DB implements Serializable{

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

    public boolean GameSave(Game game){

        try{
            FileOutputStream file = new FileOutputStream("savedGame.ser");
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
            in.close();
            fileIn.close();
            return game;
        }catch(IOException i)
        {
            i.printStackTrace();
            return null;
        }catch(ClassNotFoundException c)
        {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return null;
        }
    }
}

