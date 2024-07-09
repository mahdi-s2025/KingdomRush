package com.kingdom_rush.controller;

import com.kingdom_rush.model.*;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class DBController {
    private static DBController dbController ;
    private final Database database;

    private DBController() throws Exception {
        database = Database.getDatabase();
    }


    public static DBController getDbController() throws Exception {
        if (dbController == null)
            dbController = new DBController();
        return dbController;
    }

    public Player findPlayer(String username) throws Exception {
        Player targetPlayer = null;
        String cmd = "SELECT * FROM users WHERE username = '" + username + "'";
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
}
