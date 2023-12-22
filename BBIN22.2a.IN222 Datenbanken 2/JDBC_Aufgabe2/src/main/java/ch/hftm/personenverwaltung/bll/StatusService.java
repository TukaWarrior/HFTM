package ch.hftm.personenverwaltung.bll;

import java.sql.Connection;
import java.sql.SQLException;

import ch.hftm.personenverwaltung.dal.ConnectionUtil;
import ch.hftm.personenverwaltung.dal.StatusGateway;

public class StatusService implements AutoCloseable {
	
	private  Connection connection;

	public StatusService() throws Exception {
		try {
			// Connection erzeugen
			ConnectionUtil connectionUtil = new ConnectionUtil();
			connection = connectionUtil.getAConnection();
		} catch (SQLException e) {
			throw new Exception("Problem for Setting up the Connection to the Database!", e);
		}
	}
	
	@Override
	public void close() throws Exception {
		try {
			connection.close();
		} catch (SQLException e) {
			throw new Exception("Problem with Closing the Connection to the Database!", e);
		}
	}

	/**
	 * Beispiel Business-Logik-Methode
	 */
	public void meinBeispielUseCase() throws Exception {
		
		try {
			connection.setAutoCommit(false);
			StatusGateway statusGw = new StatusGateway(connection);

			// Gewünschte Operationen
			// ....

			connection.commit();

		} catch (SQLException e) {
			// Transaktion verwerfen
			try {
				connection.rollback();
			} catch (SQLException e2) {
				throw new Exception("Rollback failed!", e);
			}
			throw new Exception("Transaction failed!", e);
		}
	}

}
