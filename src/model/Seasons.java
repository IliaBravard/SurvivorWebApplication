package model; // Tha package where this entity is located at

// Including the needed imports
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	// One season has only one merge tribe, thus 1..1
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "TRIBE_ID")
	private MergeTribes mergeTribe;
	
	// One season can have many players in it, thus 1..n
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "PLAYERS_ID")
	private List<Players> listOfPlayers;
	
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
	 * This is the nondefault constructor that sets all fields of this entity.
	 * @param number - the season number
	 * @param name - the season's name
	 * @param winner - the winner of the season
	 * @param startDate - the date the season was first aired
	 * @param mergeTribes - the merge tribe object correpsonding to the particular season
	 */
	public Seasons(int number, String name, String winner, LocalDate startDate, MergeTribes mergeTribe) {
		setSeasonNum(number);
		setSeasonName(name);
		setSeasonWinner(winner);
		setFirstAired(startDate);
		setMergeTribe(mergeTribe);
	}
	
	/**
	 * This is the nondefault constructor that sets all fields of this entity.
	 * @param number - the season number
	 * @param name - the season's name
	 * @param winner - the winner of the season
	 * @param startDate - the date the season was first aired
	 * @param players - the list of players in a given season
	 */
	public Seasons(int number, String name, String winner, LocalDate startDate, List<Players> players) {
		setSeasonNum(number);
		setSeasonName(name);
		setSeasonWinner(winner);
		setFirstAired(startDate);
		setListOfPlayers(players);
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

	public MergeTribes getMergeTribe() {
		return mergeTribe;
	}

	public void setMergeTribe(MergeTribes mergeTribe) {
		this.mergeTribe = mergeTribe;
	}

	public List<Players> getListOfPlayers() {
		return listOfPlayers;
	}

	public void setListOfPlayers(List<Players> listOfPlayers) {
		this.listOfPlayers = listOfPlayers;
	}

	/**
	 * This is a helper method used for debugging purposes.
	 * @return the details for each specified field in this entity in a single line
	 */
	@Override
	public String toString() {
		return "Season " + seasonNum + " - " + seasonName;
	}
}