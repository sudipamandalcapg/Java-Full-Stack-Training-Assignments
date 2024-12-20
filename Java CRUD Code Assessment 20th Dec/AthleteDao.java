package javaCRUD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AthleteDao extends AbstractAthlete implements AthleteOperations {

	@Override
	public void addAthlete(Athlete athlete) {
		String query = "INSERT INTO players (name, skill, exp, country, overall_score) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = dbConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, athlete.getPlayerName());
			stmt.setString(2, athlete.getPlayerSkill());
			stmt.setInt(3, athlete.getPlayerExperience());
			stmt.setString(4, athlete.getPlayerCountry());
			stmt.setDouble(5, athlete.getPlayerScore());
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				athlete.setPlayerId(rs.getInt(1)); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Athlete getAthleteById(int playerId) {
		String query = "SELECT * FROM players WHERE id = ?";
		try (PreparedStatement stmt = dbConnection.prepareStatement(query)) {
			stmt.setInt(1, playerId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new Athlete(rs.getInt("id"), rs.getString("name"), rs.getString("skill"), rs.getInt("exp"),
						rs.getString("country"), rs.getDouble("overall_score"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Athlete> getAllAthletes() {
		List<Athlete> athletes = new ArrayList<>();
		String query = "SELECT * FROM players";
		try (Statement stmt = dbConnection.createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				athletes.add(new Athlete(rs.getInt("id"), rs.getString("name"), rs.getString("skill"), rs.getInt("exp"),
						rs.getString("country"), rs.getDouble("overall_score")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return athletes;
	}

	@Override
	public List<Athlete> getAthletesByCountry(String country) {
		List<Athlete> athletes = new ArrayList<>();
		String query = "SELECT * FROM players WHERE country = ?";
		try (PreparedStatement stmt = dbConnection.prepareStatement(query)) {
			stmt.setString(1, country);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				athletes.add(new Athlete(rs.getInt("id"), rs.getString("name"), rs.getString("skill"), rs.getInt("exp"),
						rs.getString("country"), rs.getDouble("overall_score")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return athletes;
	}

	@Override
	public List<Athlete> getAthletesByExperience() {
		List<Athlete> athletes = new ArrayList<>();
		String query = "SELECT * FROM players ORDER BY exp DESC";
		try (Statement stmt = dbConnection.createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				athletes.add(new Athlete(rs.getInt("id"), rs.getString("name"), rs.getString("skill"), rs.getInt("exp"),
						rs.getString("country"), rs.getDouble("overall_score")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return athletes;
	}

	@Override
	public void modifyAthlete(Athlete athlete) {
		// Check if the athlete has a valid ID before proceeding
		if (athlete.getPlayerId() <= 0) {
			System.out.println("Invalid athlete ID, update cannot be performed.");
			return;
		}

		String query = "UPDATE players SET name = ?, skill = ?, exp = ?, country = ?, overall_score = ? WHERE id = ?";

		try (PreparedStatement stmt = dbConnection.prepareStatement(query)) {
			stmt.setString(1, athlete.getPlayerName());
			stmt.setString(2, athlete.getPlayerSkill());
			stmt.setInt(3, athlete.getPlayerExperience());
			stmt.setString(4, athlete.getPlayerCountry());
			stmt.setDouble(5, athlete.getPlayerScore());
			stmt.setInt(6, athlete.getPlayerId());

			int rowsUpdated = stmt.executeUpdate();
			System.out.println("Rows updated: " + rowsUpdated);

			if (rowsUpdated > 0) {
				System.out.println("Athlete data updated successfully.");
			} else {
				System.out.println("No athlete found with the specified ID.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeAthlete(int playerId) {
		String query = "DELETE FROM players WHERE id = ?";
		try (PreparedStatement stmt = dbConnection.prepareStatement(query)) {
			stmt.setInt(1, playerId);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
