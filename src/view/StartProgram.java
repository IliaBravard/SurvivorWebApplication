package view;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import controller.SeasonsDAO;
import model.Seasons;

public class StartProgram {

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
			DateTimeFormatter format  = DateTimeFormatter.ofPattern("d MMMM, yyyy");
			
			// Parsing the string to the specified date format
			LocalDate date = LocalDate.parse(stringDate, format);
			
			Seasons toAdd = new Seasons(seasonNum, seasonName, seasonWinner, date);
			sh.insertSeason(toAdd);
		}

		private static void viewTheSeasons() {
			List<Seasons> allSeasons = sh.showAllSeasons();
			
			// Using an enhanced for loop to traverse the list and return each record
			for(Seasons traversedRecord : allSeasons) {
				System.out.println(traversedRecord.toString());
			}
		}
		
		private static void deleteASeason() {
			System.out.print("Enter the season number to be removed: ");
			int seasonNum = in.nextInt();
			in.nextLine();
			System.out.print("Enter the season's name: ");
			String seasonName = in.nextLine();
			
			Seasons toDelete = new Seasons(seasonNum, seasonName);
			sh.deleteSeason(toDelete);
		}
		
		private static void editASeason() {
			Seasons s = new Seasons();
			Seasons foundSeason;
			
			System.out.print("Enter the ID of the record you would like to delete: ");
			int seasonId = in.nextInt();
			
			foundSeason = sh.findSeason(seasonId);
			
			if (foundSeason != null ) {
				System.out.println("Found Results.");
				
				System.out.println(s.toString());

				Seasons toEdit = sh.findSeason(seasonId);
				
				
				System.out.println("1 : Update the season number");
				System.out.println("2 : Update the season name");
				System.out.println("3 : Update the season winner");
				System.out.println("4 : Update the season's start date");
				
				int choice = in.nextInt();
				in.nextLine();

				
				switch(choice) {
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

			} else {
				System.out.println("---- No results found");
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		public static void main(String[] args) {
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome shopping list! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add an item");
				System.out.println("*  2 -- Edit an item");
				System.out.println("*  3 -- Delete an item");
				System.out.println("*  4 -- View the list");
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
					//lih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

	}