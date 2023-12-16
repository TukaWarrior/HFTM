package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Datenbanken II
 * Beispiel-Lösung zur Aufgabe 1
 * @author simeon.liniger
 */
public class DbAccess_Loesung {

	/**
	 * Main-Methode zum Testen der Methoden
	 * @param args
	 */
	public static void main(String[] args) {
		DbAccess_Loesung dbAccess = new DbAccess_Loesung();

		dbAccess.moveToNewAddress(1, "HALLO-Strasse 3", "9999", "Dort");

		dbAccess.getAddresses();
		
		dbAccess.newState(1);

	}

	/**
	 * Listet alle Personen mit den zugehörigen Adress-Informationen auf
	 */
	private void getAddresses() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:vereinuser/vereinuser@localhost:1521:xe");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(
					"SELECT vorname, name, strasse_nr, plz, ort FROM person");

			while (resultSet.next()) {
				String address = "Addresse: " + resultSet.getString("name");
				address += " " + resultSet.getString("vorname");
				address += " " + resultSet.getString("name");
				address += ", " + resultSet.getString("strasse_nr");
				address += ", " + resultSet.getString("plz");
				address += " " + resultSet.getString("ort");

				System.out.println(address);
			}
			resultSet.close();
			statement.close();

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
	}

	/**
	 * Ändert die Adress-Information einer gewünschten Person
	 * @param persId ID der betroffenen Person
	 * @param strasseNr Neue Strasse
	 * @param plz Neue PLZ
	 * @param ort Neuer Ort
	 */
	private void moveToNewAddress(int persId, String strasseNr, String plz, String ort) {
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:vereinuser/vereinuser@localhost:1521:xe");

			String sql = "UPDATE PERSON set strasse_nr = ?, plz = ?, ort = ? WHERE persid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, strasseNr);
			preparedStatement.setString(2, plz);
			preparedStatement.setString(3, ort);
			preparedStatement.setInt(4, persId);

			preparedStatement.executeUpdate();

			preparedStatement.close();
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
	}

	/**
	 * Erzeugt ein neuer Status VIP und weist diesen der gewünschten Person zu
	 * @param persId ID der betroffenen Person
	 */
	private void newState(int persId) {
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:vereinuser/vereinuser@localhost:1521:xe");

			// Nicht nach jedem Execute Comitten
			connection.setAutoCommit(false);

			// Höchste ID abfragen
			String idStatement = "SELECT MAX(statid)+1 AS newid FROM status";
			Statement statment = connection.createStatement();
			ResultSet rstId = statment.executeQuery(idStatement);
			rstId.next();
			int statId = rstId.getInt("newid");
			statment.close();

			// Status hinzufügen
			String sql = "INSERT INTO status (statid,bezeichner) values (?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, statId);
			preparedStatement.setString(2, "VIP");
			preparedStatement.executeUpdate();
			
			// Person Ändern
			sql = "UPDATE person SET statid = ? WHERE persid = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, statId);
			preparedStatement.setInt(2, persId);
			preparedStatement.executeUpdate();

			preparedStatement.close();

			// Transaktion Übernehmen
			connection.commit();
			System.out.println("Connection commit");

		} catch (SQLException e) {
			// Transaktion verwerfen
			try {
				if (connection != null) {
					connection.rollback();
				}
			} catch (SQLException e2) {
				System.out.println("Rollback failed!");
				e2.printStackTrace();
			}
			System.out.println("Transaction failed!");
			e.printStackTrace();
		} finally {
			// Verbindung schliessen
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
