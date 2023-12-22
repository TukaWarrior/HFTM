package ch.hftm.personenverwaltung.dal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import ch.hftm.personenverwaltung.model.Status;

@TestInstance(Lifecycle.PER_CLASS)
public class StatusIT {

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

    @Test
    void addingDeletingAndCountingStatus() throws SQLException {
        StatusGateway statusGw = new StatusGateway(connection);

        // Alle Status zählen
        int sizeBeforeInsert = statusGw.readStatus().size();

        // Status Anlegen
        Status stat1 = new Status("Neuer Status");
        statusGw.createStatus(stat1);

        // Alle Status zählen
        int sizeAfterInsert = statusGw.readStatus().size();

        assertEquals(sizeAfterInsert-1, sizeBeforeInsert, "Problem beim Datensatz hinzufügen");

        statusGw.deleteStatus(stat1);

        // Alle Status zählen
        int sizeAfterDeleting = statusGw.readStatus().size();

        assertEquals(sizeAfterInsert-1, sizeAfterDeleting, "Problem beim Datensatz löschen");
        
    }

    @Test
    void changingStatus() throws SQLException {
        StatusGateway statusGw = new StatusGateway(connection);

        // Erstbeste Status-ID aus Statusliste
        int existingStatusId = statusGw.readStatus().get(0).getId();

        // Status über ID auslesen
        Status status = statusGw.readStatus(existingStatusId);

        // Status ändern
        String newBezeichner = "Testing";
        status.setBezeichner(newBezeichner);
        statusGw.updateStatus(status);

        // Status über ID auslesen
        Status status2 = statusGw.readStatus(existingStatusId);
        
        assertEquals(status2.getBezeichner(), newBezeichner, "Problem beim ändern des Datensatzes.");
    }
}
