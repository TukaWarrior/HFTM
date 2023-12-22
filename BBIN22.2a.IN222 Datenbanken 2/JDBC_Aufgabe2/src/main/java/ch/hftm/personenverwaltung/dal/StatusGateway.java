package ch.hftm.personenverwaltung.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ch.hftm.personenverwaltung.model.Status;

public class StatusGateway {

	private Connection connection;

	public StatusGateway(Connection connection) {
		this.connection = connection;
	}

	public void createStatus(Status status) throws SQLException {
		String idStatement = "SELECT MAX(statid)+1 AS newid FROM status";
		Statement statment = connection.createStatement();
		ResultSet rstId = statment.executeQuery(idStatement);
		rstId.next();
		status.setId(rstId.getInt("newid"));
		statment.close();

		String sql = "INSERT INTO status (statid,bezeichner,beitrag) values (?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setInt(1, status.getId());
		preparedStatement.setString(2, status.getBezeichner());
		// Null-Wert Behandlung für Beitrag
		if (status.getBeitrag() != null) {
			preparedStatement.setInt(3, status.getBeitrag());
		} else {
			preparedStatement.setNull(3, java.sql.Types.INTEGER);
		}

		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	
	public Status readStatus(int statusId) throws SQLException {
		String sql = "SELECT statid,bezeichner,beitrag FROM status WHERE statid = " + statusId;
		return getStatusListFromQuery(sql).get(0);
	}

	public List<Status> readStatus() throws SQLException {
		String sql = "SELECT statid,bezeichner,beitrag FROM status ORDER BY statid";
		return getStatusListFromQuery(sql);
	}

	public void updateStatus(Status status) throws SQLException {
		String sql = "UPDATE status set bezeichner=?, beitrag=? WHERE statid=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setString(1, status.getBezeichner());
		// Null-Wert Behandlung für Beitrag
		if (status.getBeitrag() != null) {
			preparedStatement.setInt(2, status.getBeitrag());
		} else {
			preparedStatement.setNull(2, java.sql.Types.INTEGER);
		}
		preparedStatement.setInt(3, status.getId());

		preparedStatement.executeUpdate();
		preparedStatement.close();
	}

	public void deleteStatus(Status status) throws SQLException {
		String sql = "DELETE FROM status where statid=" + status.getId();
		Statement statment = connection.createStatement();
		statment.executeUpdate(sql);
		statment.close();
	}
	
	private List<Status> getStatusListFromQuery(String sql) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		List<Status> statusList = new ArrayList<Status>();
		while (resultSet.next()) {
			Status s = new Status();
			s.setId(resultSet.getInt("statid"));
			s.setBezeichner(resultSet.getString("bezeichner"));
			s.setBeitrag(resultSet.getInt("beitrag"));
			// Null-Wert Behandlung für Beitrag
			if (resultSet.wasNull()) {
				s.setBeitrag(null);
			}
			statusList.add(s);
		}
		statement.close();
		return statusList;
	}
}
