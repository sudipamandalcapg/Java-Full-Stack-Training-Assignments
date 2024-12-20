package javaCRUD;

import java.util.List;

public interface AthleteOperations {
	void addAthlete(Athlete athlete);

	Athlete getAthleteById(int playerId);

	List<Athlete> getAllAthletes();

	List<Athlete> getAthletesByCountry(String country);

	List<Athlete> getAthletesByExperience();

	void modifyAthlete(Athlete athlete);

	void removeAthlete(int playerId);
}
