package model; // Tha package where this entity is located at

// Including the needed imports
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seasons")
public class Seasons {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SEASON_ID")
	private int seasonId; // The primary key
	
	@Column(name = "SEASON_NUM")
	private int seasonNum; // The season number
	
	@Column(name = "SEASON_NAME")
	private String seasonName; // The season's name
	
	@Column(name = "SEASON_WINNER")
	private String seasonWinner; // The winner of the season
	
	@Column(name = "SEASON_FIRST_AIRED")
	private LocalDate firstAired; // The date the season was first aired
	
	/**
	 * This is the default, no argument constructor.
	 */
	public Seasons() {
	}
	
	/**
	 * This is the nondefault constructor that sets all fields of this entity.
	 * @param number - the season number
	 * @param name - the season's name
	 * @param winner - the winner of the season
	 * @param startDate - the date the season was first aired
	 */
	public Seasons(int number, String name, String winner, LocalDate startDate) {
		setSeasonNum(number);
		setSeasonName(name);
		setSeasonWinner(winner);
		setFirstAired(startDate);
	}
	
	/**
	 * This is a helper constructor that sets only the season number and the season name of each record.
	 * @param number - the season number
	 * @param name - the season's name
	 */
	public Seasons(int number, String name) {
		setSeasonNum(number);
		setSeasonName(name);
	}
	
	// Declaring the needed accessors and mutators
	public int getSeasonId() {
		return seasonId;
	}

	public void setSeasonId(int seasonId) {
		this.seasonId = seasonId;
	}
	
	public int getSeasonNum() {
		return seasonNum;
	}

	public void setSeasonNum(int seasonNum) {
		this.seasonNum = seasonNum;
	}
	public String getSeasonName() {
		return seasonName;
	}
	public void setSeasonName(String seasonName) {
		this.seasonName = seasonName;
	}
	public String getSeasonWinner() {
		return seasonWinner;
	}
	public void setSeasonWinner(String seasonWinner) {
		this.seasonWinner = seasonWinner;
	}
	public LocalDate getFirstAired() {
		return firstAired;
	}
	public void setFirstAired(LocalDate firstAired) {
		this.firstAired = firstAired;
	}

	/**
	 * This is a helper method used for debugging purposes.
	 * @return the details for each specified field in this entity in a single line
	 */
	@Override
	public String toString() {
		return "Seasons [ID: " + seasonId + " Season #" + seasonNum + ", Name: " + seasonName + ", Winner: " + seasonWinner
				+ ", First Aired: " + firstAired + "]";
	}
}