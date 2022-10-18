package view;

import model.MergeTribes;

import java.util.List;
import java.util.Scanner;

import controller.MergeTribesDAO;

public class mergeTribesTester {

	static Scanner in = new Scanner(System.in);
	static MergeTribesDAO mth = new MergeTribesDAO();

	private static void addAMergeTribe() {
		System.out.print("Enter the tribe's name:  ");
		String tribeName = in.nextLine();
		System.out.print("Enter the meaning of the name: ");
		String nameMeaning = in.nextLine();
		System.out.print("Enter how many players are in that tribe: ");
		int playersCnt = in.nextInt();
		in.nextLine();

		MergeTribes toAdd = new MergeTribes(tribeName, nameMeaning, playersCnt);
		mth.insertMergeTribe(toAdd);
	}

	private static void viewTheTribes() {
		List<MergeTribes> allTribes = mth.showAllTribes();

		// Using an enhanced for loop to traverse the list and return each record
		for (MergeTribes traversedRecord : allTribes) {
			System.out.println(traversedRecord.toString());
		}
	}

	public static void main(String[] args) {
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our awesome tribes! ---");
		while (goAgain) {
			System.out.println("*  Select your option:");
			System.out.println("*  1 -- Add a merge tribe");
			System.out.println("*  2 -- View all tribes");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAMergeTribe();
			} else if (selection == 2) {
				viewTheTribes();
			} else {
				mth.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}
		}
	}
}