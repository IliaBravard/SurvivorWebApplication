package model; // The package where this entity is located at

//Including the needed imports
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "players")
public class Players {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PLAYER_ID")
	private int playerId; // The primary key
	
	@Column(name = "FIRST_NAME")
	private String firstName; // The player's first name
	
	@Column(name = "LAST_NAME")
	private String lastName; // The player's last name
	
	@Column(name = "CAST_AGE")
	private int age; // The player's age at the time of casting
	
	/**
	 * This is the default, no argument constructor.
	 */
	public Players() {
	}
	
	/**
	 * This is the nondefault constructor that sets each field of this entity and auto-generates the primary key.
	 * @param fName - the player's first name
	 * @param lName - the player's last name
	 * @param age - the player's age at the time of casting
	 */
	public Players(String fName, String lName, int age) {
		setFirstName(fName);
		setLastName(lName);
		setAge(age);
	}

	// Generating the needed accessors and mutators
	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * This is a helper method used for debugging purposes.
	 * @return the details for each specified field in this entity in a single line
	 */
	@Override
	public String toString() {
		return "Players [ID: " + playerId + ", First Name: " + firstName + ", Last Name: " + lastName + ", Age: " + age
				+ "]";
	}
}