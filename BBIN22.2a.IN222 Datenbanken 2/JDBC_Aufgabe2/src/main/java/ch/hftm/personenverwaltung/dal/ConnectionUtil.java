package ch.hftm.personenverwaltung.dal;

import java.sql.*;

public class ConnectionUtil {

	public Connection getAConnection() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:oracle:thin:vereinuser/vereinuser@localhost:1521:xe");
	}

}
