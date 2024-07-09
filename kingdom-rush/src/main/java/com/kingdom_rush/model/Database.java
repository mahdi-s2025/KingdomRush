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

    private Database() throws Exception {
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

    public static Database getDatabase() throws Exception {
        if (database == null)
            database = new Database();
        return database;
    }

    public void executeSQL(String cmd) throws Exception {
        try {
            Statement statement = connection.prepareStatement(cmd);
            statement.execute(cmd);
            statement.close();
        } catch (Exception e) {
            throw new Exception("Error executing SQL: " + cmd);
        }
    }

    public ResultSet executeQuery(String cmd) throws Exception {
        try {
            Statement statement = connection.prepareStatement(cmd);
            return statement.executeQuery(cmd);
        } catch (Exception e) {
            throw new Exception("Error executing Query: " + cmd);
        }
    }
}
