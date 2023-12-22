package ch.hftm.personenverwaltung.dal;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class PersonIT {

    Connection connection;

    @BeforeAll
    void initialization() throws SQLException {
        // Connection erzeugen
        ConnectionUtil connectionUtil = new ConnectionUtil();
        connection = connectionUtil.getAConnection();

        connection.setAutoCommit(false);
    }

    @AfterAll
    void dispose() throws SQLException {
        connection.rollback();
        connection.close();
    }

    // TODO: Schreibe die notwendigen Tests um den Zugriff aus dem PersonGateway auf die Person-Tabelle zu testen.
    @Test
    void accessingAPersonById() throws SQLException {
    }
}
