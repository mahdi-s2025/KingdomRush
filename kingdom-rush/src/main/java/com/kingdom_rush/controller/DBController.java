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
            String spellsCmd = "SELECT health, freeze, coin, littleBoy FROM spells INNER JOIN " +
                    "players ON players.ID = spells.ID WHERE players.ID = '" + ID + "'";
            ResultSet spellsResult = database.executeQuery(spellsCmd);
            if (spellsResult.next()) {
                backpack[0] = new HealthSpell(spellsResult.getInt("health"));
                backpack[1] = new FreezeSpell(spellsResult.getInt("freeze"));
                backpack[2] = new CoinSpell(spellsResult.getInt("coin"));
                backpack[3] = new LittleBoySpell(spellsResult.getInt("littleBoy"));
            }

            targetPlayer = new Player(result.getString("username"), result.getString("password"),
                    result.getInt("level"), result.getInt("diamonds"), backpack);
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
    }
}
