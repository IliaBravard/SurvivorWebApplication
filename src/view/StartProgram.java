package view;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		private static void deleteASeason() {
			System.out.print("Enter the store to delete: ");
			String store = in.nextLine();
			System.out.print("Enter the item to delete: ");
			String item = in.nextLine();

		}

		private static void editASeason() {
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Store");
			System.out.println("2 : Search by Item");
			int searchBy = in.nextInt();
			in.nextLine();
			/*List<ListItem> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the store name: ");
				String storeName = in.nextLine();
				
			} else {
				System.out.print("Enter the item: ");
				String itemName = in.nextLine();
				

			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (ListItem l : foundItems) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ListItem toEdit = lih.searchForItemById(idToEdit);
				System.out.println("Retrieved " + toEdit.getItem() + " from " + toEdit.getStore());
				System.out.println("1 : Update Store");
				System.out.println("2 : Update Item");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Store: ");
					String newStore = in.nextLine();
					toEdit.setStore(newStore);
				} else if (update == 2) {
					System.out.print("New Item: ");
					String newItem = in.nextLine();
					toEdit.setItem(newItem);
				}

				lih.updateItem(toEdit);

			} else {
				System.out.println("---- No results found");
			}
*/
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

		private static void viewTheSeasons() {
			
		}

	}