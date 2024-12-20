package javaCRUD;

public class Athlete {
	private int playerId;
	private String playerName;
	private String playerSkill;
	private int playerExperience;
	private String playerCountry;
	private double playerScore;

	// Constructor
	public Athlete(int playerId, String playerName, String playerSkill, int playerExperience, String playerCountry,
			double playerScore) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.playerSkill = playerSkill;
		this.playerExperience = playerExperience;
		this.playerCountry = playerCountry;
		this.playerScore = playerScore;
	}

	// Getters and setters
	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerSkill() {
		return playerSkill;
	}

	public void setPlayerSkill(String playerSkill) {
		this.playerSkill = playerSkill;
	}

	public int getPlayerExperience() {
		return playerExperience;
	}

	public void setPlayerExperience(int playerExperience) {
		this.playerExperience = playerExperience;
	}

	public String getPlayerCountry() {
		return playerCountry;
	}

	public void setPlayerCountry(String playerCountry) {
		this.playerCountry = playerCountry;
	}

	public double getPlayerScore() {
		return playerScore;
	}

	public void setPlayerScore(double playerScore) {
		this.playerScore = playerScore;
	}

	@Override
	public String toString() {
		return "Athlete{id=" + playerId + ", name='" + playerName + "', skill='" + playerSkill + "', experience="
				+ playerExperience + ", country='" + playerCountry + "', score=" + playerScore + "}";
	}
}
