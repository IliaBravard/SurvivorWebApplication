package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import controller.MergeTribesDAO;
import controller.SeasonsDAO;
import model.MergeTribes;
import model.Seasons;

public class seasonsTester {

	static Scanner in = new Scanner(System.in);
	static SeasonsDAO sh = new SeasonsDAO();

	private static void addASeason() {
		System.out.print("Enter a season number: ");
		int seasonNum = in.nextInt();
		in.nextLine();
		System.out.print("Enter a the season name: ");
		String seasonName = in.nextLine();
		System.out.print("Enter the winner: ");
		String seasonWinner = in.nextLine();
		System.out.println("Enter the when the season first aired: ");
		String stringDate = in.nextLine(); // Receiving the date as a string

		// Specifying what date format we want
		DateTimeFormatter format = DateTimeFormatter.ofPattern("d MMMM, yyyy");

		// Parsing the string to the specified date format
		LocalDate date = LocalDate.parse(stringDate, format);

		Seasons toAdd = new Seasons(seasonNum, seasonName, seasonWinner, date);
		sh.insertSeason(toAdd);
	}

	private static void viewTheSeasons() {
		List<Seasons> allSeasons = sh.showAllSeasons();

		// Using an enhanced for loop to traverse the list and return each record
		for (Seasons traversedRecord : allSeasons) {
			System.out.println(traversedRecord.toString());
		}
	}

	private static void deleteASeason() {
		System.out.print("Enter the ID of the season to be removed: ");
		int seasonId = in.nextInt();
		in.nextLine();

		Seasons toDelete = sh.findSeason(seasonId);
		sh.deleteSeason(toDelete);
	}

	private static void editASeason() {
		System.out.print("Enter the ID of the record you would like to delete: ");

		int seasonId = in.nextInt();
		Seasons toEdit = sh.findSeason(seasonId);

		System.out.println("Found Results.");

		System.out.println(toEdit.toString());

		System.out.println("1 : Update the season number");
		System.out.println("2 : Update the season name");
		System.out.println("3 : Update the season winner");
		System.out.println("4 : Update the season's start date");

		int choice = in.nextInt();
		in.nextLine();

		switch (choice) {
		case 1:
			System.out.print("New Number: ");
			int newNumber = in.nextInt();
			toEdit.setSeasonNum(newNumber);
			break;
		case 2:
			System.out.print("New Name: ");
			String newName = in.nextLine();
			toEdit.setSeasonName(newName);
			break;
		case 3:
			System.out.print("New Winner: ");
			String newWinner = in.nextLine();
			toEdit.setSeasonName(newWinner);
			break;
		case 4:
			System.out.print("New Start Date: ");
			String newDate = in.nextLine();
			toEdit.setSeasonName(newDate);
			break;
		}

		sh.updateSeason(toEdit);

	}

	public static void main(String[] args) {
		// runMenu();
		
		
		// Testing for a one-to-one relationship
		MergeTribes chabogoMogo = new MergeTribes("ChabogoMogo", "Portmanteau of Chapera, Saboga, and Mogo Mogo", 9);
		MergeTribesDAO mth = new MergeTribesDAO();
		
		mth.insertMergeTribe(chabogoMogo);
		
		SeasonsDAO sh = new SeasonsDAO();
		Seasons allStars = new Seasons(8, "All Stars", "Amber Brkich", LocalDate.now(), chabogoMogo);
		
		sh.insertSeason(allStars);

		System.out.println(sh.showAllSeasons().toString());
		
		
		/**
		MergeTribes chabogoMogo = new MergeTribes("ChabogoMogo", "Portmanteau of Chapera, Saboga, and Mogo Mogo", 9);
		
		Players cameron = new Players("Cameron", "Bernard", 26);
		Players nichole = new Players("Nichole", "Atkinson", 35);
		
		List<Players> theAmazonList = new ArrayList<>();
		theAmazonList.add(nichole);
		theAmazonList.add(cameron);
		
		SeasonsDAO sh = new SeasonsDAO();
		Seasons theAmazon = new Seasons(1, "The Amazon", "TonyVlachos", LocalDate.now(), chabogoMogo);
		theAmazon.setListOfPlayers(theAmazonList);
		
		sh.insertSeason(theAmazon);
		
		System.out.println(sh.showAllSeasons().toString());
		**/
		
	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our awesome seasons! ---");
		while (goAgain) {
			System.out.println("*  Select your option:");
			System.out.println("*  1 -- Add a season");
			System.out.println("*  2 -- Edit a season");
			System.out.println("*  3 -- Delete a season");
			System.out.println("*  4 -- View all seasons");
			System.out.println("*  5 -- Exit the awesome program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addASeason();
			} else if (selection == 2) {
				editASeason();
			} else if (selection == 3) {
				deleteASeason();
			} else if (selection == 4) {
				viewTheSeasons();
			} else {
				sh.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}
		}
	}
}