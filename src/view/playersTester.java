package view;

import java.util.List;
import java.util.Scanner;

import controller.PlayersDAO;
import model.Players;

public class playersTester {

	static Scanner in = new Scanner(System.in);
	static PlayersDAO ph = new PlayersDAO();

	private static void addAPlayer() {
		System.out.print("Enter the player's first name: ");
		String fName = in.nextLine();
		System.out.print("Enter the player's second name: ");
		String lName = in.nextLine();
		System.out.print("Enter the player's age at the time of casting: ");
		int age = in.nextInt();
		in.nextLine();

		Players toAdd = new Players(fName, lName, age);
		ph.insertPlayer(toAdd);
	}

	private static void viewTheSeasons() {
		List<Players> allPlayers = ph.showAllPlayers();

		// Using an enhanced for loop to traverse the list and return each record
		for (Players traversedRecord : allPlayers) {
			System.out.println(traversedRecord.toString());
		}
	}

	private static void deleteAPlayer() {
		System.out.print("Enter the ID of the player to be removed: ");
		int playerId = in.nextInt();
		in.nextLine();
		
		Players toDelete = ph.findPlayer(playerId);
		ph.deletePlayer(toDelete);
	}

	private static void editAPlayer() {
		System.out.print("Enter the ID of the record you would like to edit: ");

		int playerId = in.nextInt();
		Players toEdit = ph.findPlayer(playerId);

		System.out.println("Found Results.");

		System.out.println(toEdit.toString());

		System.out.println("1 : Update the player's first name");
		System.out.println("2 : Update the player's last name");
		System.out.println("3 : Update the player's age");

		int choice = in.nextInt();
		in.nextLine();

		switch (choice) {
		case 1:
			System.out.print("New First Name: ");
			String newFName = in.nextLine();
			toEdit.setFirstName(newFName);
			break;
		case 2:
			System.out.print("New Last Name: ");
			String newLName = in.nextLine();
			toEdit.setLastName(newLName);
			break;
		case 3:
			System.out.print("New Age: ");
			int newAge = in.nextInt();
			in.nextLine();
			toEdit.setAge(newAge);
			break;
		}

		ph.updatePlayer(toEdit);
	}

	public static void main(String[] args) {
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our awesome players! ---");
		while (goAgain) {
			System.out.println("*  Select your option:");
			System.out.println("*  1 -- Add a player");
			System.out.println("*  2 -- Edit a player");
			System.out.println("*  3 -- Delete a player");
			System.out.println("*  4 -- View all players");
			System.out.println("*  5 -- Exit the awesome program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAPlayer();
			} else if (selection == 4) {
				viewTheSeasons();
			}

			else if (selection == 3) {
				deleteAPlayer();
			}

			else if (selection == 2) {
				editAPlayer();
			} else {
				ph.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}
		}
	}
}