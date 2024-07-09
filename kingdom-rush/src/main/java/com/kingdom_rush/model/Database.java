package com.kingdom_rush.model;

import lombok.Getter;

import java.sql.*;

@Getter
public class Database {
    private static Database database;

    final private String URL;
    final private String userName;
    final private String password;
    final private Connection connection;

    private Database() {
        URL = "jdbc:mysql://localhost/game";
        userName = "root";
        password = "root";
        Connection tmp = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            tmp = DriverManager.getConnection(URL, userName, password);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        connection = tmp;
    }

    public static Database getDatabase() {
        if (database == null)
            database = new Database();
        return database;
    }

    public void executeSQL(String cmd) {
        try {
            Statement statement = connection.prepareStatement(cmd);
            statement.execute(cmd);
            statement.close();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    public ResultSet executeQuery(String cmd) {
        ResultSet result = null;
        try {
            Statement statement = connection.prepareStatement(cmd);
            result = statement.executeQuery(cmd);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return result;
    }
}
