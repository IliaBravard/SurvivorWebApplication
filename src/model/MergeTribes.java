package model; // The package where this entity is located at

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "mtribes")
public class MergeTribes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRIBE_ID")
	private int tribeId; // The primary key

	@Column(name = "TRIBE_NAME")
	private String tribeName; // The merge tribe's name

	@Column(name = "NAME_MEANING")
	private String meaning; // The meaning of the merge tribe's name

	@Column(name = "PLAYERS_CNT")
	private int numOfPlayers; // The number of players in the merge tribe
	
	@JoinColumn(name = "SEASON")
	private Seasons season; // The season to which the merge tribe belongs to
	
	/**
	 * This is the default, no argument constructor.
	 */
	public MergeTribes() {
	}

	/**
	 * This is the nondefault constructor that sets the fields of this entity and
	 * auto-generates the primary key.
	 * 
	 * @param name         - the merge tribes name
	 * @param meaning      - the meaning of the tribe's name
	 * @param playersCount - the number of players in the tribe
	 */
	public MergeTribes(String name, String meaning, int playersCount) {
		setTribeName(name);
		setMeaning(meaning);
		setNumOfPlayers(playersCount);
	}

	/**
	 * This is the nondefault constructor that sets the fields of this entity and
	 * auto-generates the primary key.
	 * 
	 * @param name         - the merge tribes name
	 * @param meaning      - the meaning of the tribe's name
	 * @param playersCount - the number of players in the tribe
	 * @param season - the season to which the merge tribe belongs to
	 */
	public MergeTribes(String name, String meaning, int playersCount, Seasons season) {
		setTribeName(name);
		setMeaning(meaning);
		setNumOfPlayers(playersCount);
		setSeason(season);
	}
	
	/**
	 * This is the nondefault constructor that sets only the name field of this entity and
	 * auto-generates the primary key.
	 * 
	 * @param name         - the merge tribes name
	 */
	public MergeTribes(String name) {
		setTribeName(name);
	}
	
	// Declaring the needed accessors and mutators
	public int getTribeId() {
		return tribeId;
	}

	public void setTribeId(int tribeId) {
		this.tribeId = tribeId;
	}

	public String getTribeName() {
		return tribeName;
	}

	public void setTribeName(String tribeName) {
		this.tribeName = tribeName;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public int getNumOfPlayers() {
		return numOfPlayers;
	}

	public void setNumOfPlayers(int numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
	}

	public Seasons getSeason() {
		return season;
	}

	public void setSeason(Seasons season) {
		this.season = season;
	}

	/**
	 * This is a helper method used for debugging purposes.
	 * 
	 * @return the details for each specified field in this entity in a single line
	 */
	@Override
	public String toString() {
		return "MergeTribes [ID: " + tribeId + ", Name: " + tribeName + ", Meaning: " + meaning + ", Players Count: "
				+ numOfPlayers + ", Season: " + season + "]";
	}
}