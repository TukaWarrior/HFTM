package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbAccess2 {
    private static final String CONNECTION_STRING = "jdbc:oracle:thin:vereinuser/vereinuser@localhost:1521:xe";

    public static void main(String[] args)
    {
        int persId = 1; // Ulla

        getAdresses();

        System.out.println("----------- Before address update -----------");
        printPerson(persId);
        // Update address
        moveToNewAddress("Lalastr. 1", "999", "Heidiland", persId);
        System.out.println("----------- After address update -----------");
        printPerson(persId);
        // Create new status and set person status
        newState(persId);
        System.out.println("----------- After new status -----------");
        printPerson(persId);
    }

    private static void getAdresses()
    {
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(CONNECTION_STRING);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT name, vorname, strasse_nr, plz, ort FROM person");

            while(resultSet.next())
            {
                System.out.println(
                        "Name: " + resultSet.getString("name") + " " + resultSet.getString("vorname")
                                + "\nAdresse: "
                                + resultSet.getString("strasse_nr")
                                + " , "
                                + resultSet.getString("plz")
                                + " "
                                + resultSet.getString("ort")
                                +"\n-------------------------------------------");
            }
            resultSet.close();
            statement.close();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        finally
        {
            if(connection != null)
            {
                try
                {
                    connection.close();
                }
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
    }

    private static void moveToNewAddress(String strasse_nr, String plz, String ort, int persID)
    {
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(CONNECTION_STRING);

            String statement = "UPDATE person SET strasse_nr=?, plz=?, ort=? WHERE persid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, strasse_nr);
            preparedStatement.setString(2, plz);
            preparedStatement.setString(3, ort);
            preparedStatement.setInt(4, persID);

            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println("Updated " + rowsAffected + " row(s)");
        }
        catch(SQLException ex)
        {
            try
            {
                if(connection != null)
                {
                    connection.rollback();
                }
            }
            catch (SQLException exrb)
            {
                System.out.println("Rollback failed");
            }
            System.out.println("Update failed");
        }
        finally
        {
            if(connection != null)
            {
                try
                {
                    connection.close();
                }
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
    }

    private static void newState(int persID)
    {
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(CONNECTION_STRING);
            connection.setAutoCommit(false);

            int newStatId = 7;
            // Create new status
            String createStatus = "INSERT INTO status(statid, bezeichner) VALUES(?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(createStatus);
            insertStatement.setInt(1, newStatId);
            insertStatement.setString(2, "VIP");
            insertStatement.executeUpdate();

            // Set person new status
            String updatePersonStatus = "UPDATE person SET statid=? WHERE persid=?";
            PreparedStatement updateStatement = connection.prepareStatement(updatePersonStatus);
            updateStatement.setInt(1, newStatId);
            updateStatement.setInt(2, persID);
            updateStatement.executeUpdate();

            // Execute
            connection.commit();
        }
        catch(SQLException ex)
        {
            try
            {
                if(connection != null)
                {
                    connection.rollback();
                }
            }
            catch (SQLException exrb)
            {
                System.out.println("Rollback failed");
            }
            System.out.println("Transaction failed");
        }
        finally
        {
            if(connection != null)
            {
                try
                {
                    connection.close();
                }
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
            System.out.println("New status 'VIP' created");
        }
    }

    private static void printPerson(int persID)
    {
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(CONNECTION_STRING);

            String elStatemente = "SELECT PERSON.NAME, PERSON.VORNAME, PERSON.STRASSE_NR, PERSON.PLZ, PERSON.ORT, STATUS.BEZEICHNER "
                    + "FROM PERSON "
                    + "JOIN STATUS ON PERSON.STATID = STATUS.STATID "
                    + "WHERE PERSON.PERSID='" + persID + "'";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(elStatemente);

            while(resultSet.next())
            {
                System.out.println(
                        "Name: " + resultSet.getString("name")
                                + " "
                                + resultSet.getString("vorname")
                                + "\nAdresse: "
                                + resultSet.getString("strasse_nr")
                                + " , "
                                + resultSet.getString("plz")
                                + " "
                                + resultSet.getString("ort")
                                + "\nStatus: "
                                + resultSet.getString("bezeichner")
                                +"\n-------------------------------------------");
            }
            resultSet.close();
            statement.close();
        }
        catch(SQLException ex)
        {
            System.out.println("Transaction failed");
        }
        finally
        {
            if(connection != null)
            {
                try
                {
                    connection.close();
                }
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
    }
}
