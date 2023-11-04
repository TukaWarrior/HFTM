package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbAccess {
    public static void main(String[] args) throws SQLException {
        System.out.println("Hello world!");

        // Mit einer Datenbank verbinden.
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:vereinuser/vereinuser@localhost:1521:xe");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                        e.printStackTrace();
                }
            }
        }

        // Daten abfragen
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Person");
        while (resultSet.next()) {
            System.out.println("Ausgabe: " + resultSet.getString("Spaltenlabel"));
        }
        resultSet.close();
        statement.close();

    }
}