package javaCRUD;

import java.util.List;

public class AthleteManager {
	public static void main(String[] args) {
		AthleteOperations athleteOps = new AthleteDao();

		// Add a new athlete
		Athlete newAthlete = new Athlete(0, "Michael Smith", "Batsman", 7, "USA", 92.4);
		athleteOps.addAthlete(newAthlete);

		Athlete newAthlete1 = new Athlete(0, "Sachin Tendulkar", "Batsman", 24, "India", 98.6);
		athleteOps.addAthlete(newAthlete1);

		Athlete newAthlete2 = new Athlete(0, "Shane Warne", "Bowler", 15, "Australia", 91.3);
		athleteOps.addAthlete(newAthlete2);

		Athlete newAthlete3 = new Athlete(0, "Ben Stokes", "All-rounder", 10, "England", 88.5);
		athleteOps.addAthlete(newAthlete3);

		// Retrieve all athletes
		System.out.println("\nRetrieving all athletes : \n");
		List<Athlete> athletes = athleteOps.getAllAthletes();
		athletes.forEach(System.out::println);

		// Modify the athlete's details (change name and experience)
		newAthlete1.setPlayerName("Sachin Ramesh Tendulkar"); // Modify name
		newAthlete1.setPlayerExperience(25); // Modify experience

		// Ensure that the athlete has a valid ID (it is set after adding the athlete)
		System.out.println("\nBefore modification: " + newAthlete1);
		athleteOps.modifyAthlete(newAthlete1); // Update the athlete in the database
		System.out.println("After modification: " + newAthlete1);

		// Listing athletes by country
		String country = "India"; // Example: Change this to the country you want to list
		System.out.println("\nAthletes from " + country + ":");
		List<Athlete> athletesByCountry = athleteOps.getAthletesByCountry(country);
		athletesByCountry.forEach(System.out::println);

		// List athletes by experience
		System.out.println("\nList athletes by experience:");
		List<Athlete> experiencedAthletes = athleteOps.getAthletesByExperience();
		experiencedAthletes.forEach(System.out::println);

		// Delete an athlete
		athleteOps.removeAthlete(newAthlete.getPlayerId());
	}
}
