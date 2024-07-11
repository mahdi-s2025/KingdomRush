package com.kingdom_rush.controller;

import com.kingdom_rush.model.*;
import lombok.Getter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBController {
    @Getter
    private static DBController instance;

    static {
        try {
            instance = new DBController();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    private final Database database;

    private DBController() throws Exception {
        database = Database.getDatabase();
    }

    public Player findPlayer(String username) throws Exception {
        Player targetPlayer = null;
        String cmd = "SELECT * FROM players WHERE username = '" + username + "'";
        ResultSet result = database.executeQuery(cmd);

        if (result.next()) {
            int ID = result.getInt("ID");
            Spell[] backpack = new Spell[4];
            String spellsCmd = "SELECT health, freeze, coin, littleBoy FROM spells WHERE ID = '" + ID + "'";
            ResultSet spellsResult = database.executeQuery(spellsCmd);
            if (spellsResult.next()) {
                backpack[0] = new HealthSpell(spellsResult.getInt("health"));
                backpack[1] = new FreezeSpell(spellsResult.getInt("freeze"));
                backpack[2] = new CoinSpell(spellsResult.getInt("coin"));
                backpack[3] = new LittleBoySpell(spellsResult.getInt("littleBoy"));
            }

            int[] stars = new int[4];
            String starsCmd = "SELECT level1, level2, level3, level4 FROM stars WHERE ID = '" + ID + "'";
            ResultSet starsResult = database.executeQuery(starsCmd);
            if (starsResult.next()) {
                stars[0] = starsResult.getInt("level1");
                stars[1] = starsResult.getInt("level2");
                stars[2] = starsResult.getInt("level3");
                stars[3] = starsResult.getInt("level4");
            }

            targetPlayer = new Player(result.getString("username"), result.getString("password"),
                    result.getInt("level"), result.getInt("diamonds"), backpack, stars);
            targetPlayer.setID(ID);
            spellsResult.close();
        }
        result.close();
        return targetPlayer;
    }

    public void insertPlayer(Player player) throws Exception {
        String cmd = String.format("INSERT INTO players (username, password) VALUES ('%s', '%s')",
                player.getUsername(), player.getPassword());
        PreparedStatement statement = database.getConnection().prepareStatement(cmd, Statement.RETURN_GENERATED_KEYS);
        statement.executeUpdate();
        ResultSet generatedKey = statement.getGeneratedKeys();
        if (generatedKey.next())
            player.setID(generatedKey.getInt(1));
        statement.close();
        generatedKey.close();

        String spellsCmd = "INSERT INTO spells (ID) VALUES ('" + player.getID() + "')";
        database.executeSQL(spellsCmd);

        String starsCmd = "INSERT INTO stars (ID) VALUES ('" + player.getID() + "')";
        database.executeSQL(starsCmd);
    }

    public void updatePlayer(Player player, String field, String newValue) {
        String cmd = String.format("UPDATE players SET %s = '%s' WHERE ID = '%s'",field, newValue, player.getID());
        database.executeSQL(cmd);
    }

    public void updateSpell(Player player, String name, String newValue) {
        String cmd = String.format("UPDATE spells SET %s = '%s' WHERE ID = '%s'", name, newValue, player.getID());
        database.executeSQL(cmd);
    }
}
