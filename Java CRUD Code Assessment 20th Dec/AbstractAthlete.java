package javaCRUD;

import java.sql.*;
import java.util.List;

public abstract class AbstractAthlete {
	protected Connection dbConnection;

	public AbstractAthlete() {
		try {
			this.dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/athleteDB", "root",
					"root@1204");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Abstract methods (for CRUD operations)
	public abstract void addAthlete(Athlete athlete);

	public abstract Athlete getAthleteById(int playerId);

	public abstract List<Athlete> getAllAthletes();

	public abstract List<Athlete> getAthletesByCountry(String country);

	public abstract List<Athlete> getAthletesByExperience();

	public abstract void modifyAthlete(Athlete athlete);

	public abstract void removeAthlete(int playerId);
}
